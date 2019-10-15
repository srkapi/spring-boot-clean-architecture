package com.srkapi.clean.application.service;

import com.srkapi.clean.application.domain.Train;
import com.srkapi.clean.application.exception.ErrorPersistenceException;
import com.srkapi.clean.application.exception.TrainExistException;
import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.ResponseCreateTrain;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.usecases.CreateTrainUseCases;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateTrainService implements CreateTrainUseCases{

    private final FindTrainBySerialNumberPort findTrainBySerialNumberPort;
    private final PersistenceTrainPort persistenceTrainPort;
    private final MapperDomain mapperTrain;


    @Override
    public ResponseCreateTrain process(CreateTrainCommand createTrainCommand) {
        Train train = mapperTrain.toDomain(createTrainCommand);

        String serialNumber = UUID.randomUUID().toString();
        verifyIfSerialNumberExist(serialNumber);
        train.setSerialNumber(serialNumber);
        Optional<Train> responsePersistence = this.persistenceTrainPort.saveTrain(train);
        return responsePersistence.map(it ->
            this.mapperTrain.toResponse(it)
        ).orElseThrow(ErrorPersistenceException::new);
    }

    private void  verifyIfSerialNumberExist(String serialNumber){
        Optional<Train> bySerialNumber = this.findTrainBySerialNumberPort.findBySerialNumber(serialNumber);
        bySerialNumber.map( it ->{
            throw new TrainExistException("Train exist with this serial number:" +
                    it.getSerialNumber());
        });
    }
}
