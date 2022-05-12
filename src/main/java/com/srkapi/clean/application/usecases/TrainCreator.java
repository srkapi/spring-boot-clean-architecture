package com.srkapi.clean.application.usecases;

import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.CreateTrainResponse;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import com.srkapi.clean.application.port.usecases.CreateTrainUseCase;
import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.domain.exception.TrainExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TrainCreator implements CreateTrainUseCase {

	private final FindTrainBySerialNumberPort findTrainBySerialNumberPort;
	private final PersistenceTrainPort persistenceTrainPort;
	private final MapperDomain mapperTrain;


	@Override
	public CreateTrainResponse execute(CreateTrainCommand createTrainCommand) {
		Train train = mapperTrain.toDomain(createTrainCommand);

		String serialNumber = UUID.randomUUID().toString();
		verifyIfSerialNumberExist(serialNumber);
		train.setSerialNumber(serialNumber);
		train.setId(this.persistenceTrainPort.saveTrain(train));
		return this.mapperTrain.toResponseCreateTrain(train);
	}

	private void verifyIfSerialNumberExist(String serialNumber) {
		Train bySerialNumber = this.findTrainBySerialNumberPort.findBySerialNumber(serialNumber);
		if (bySerialNumber != null) throw new TrainExistException("Train exist with this serial number:" +
				serialNumber);
	}
}
