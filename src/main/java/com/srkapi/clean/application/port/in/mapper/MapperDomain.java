package com.srkapi.clean.application.port.in.mapper;


import com.srkapi.clean.application.domain.Train;
import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.ResponseCreateTrain;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import org.springframework.stereotype.Component;

@Component
public class MapperDomain {

    public Train toDomain(CreateTrainCommand createTrainCommand) {
        return Train.builder().numberCarriage(createTrainCommand.getNumberCarriage())
                .build();
    }

    public ResponseCreateTrain toResponse(Train responsePersistence) {
        return ResponseCreateTrain.builder()
                .id(responsePersistence.getId())
                .serialNumber(responsePersistence.getSerialNumber())
                .build();
    }

    public ResponseFindByIdTrain toResponseByID(Train train) {
        return ResponseFindByIdTrain.builder().id(train.getId()).serialNumber(train.getSerialNumber()).build();
    }
}
