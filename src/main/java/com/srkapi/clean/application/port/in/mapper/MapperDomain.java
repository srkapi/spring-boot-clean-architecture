package com.srkapi.clean.application.port.in.mapper;


import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.adapter.in.web.response.CreateTrainResponse;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import org.springframework.stereotype.Component;

@Component
public class MapperDomain {

    public Train toDomain(CreateTrainCommand createTrainCommand) {
        return Train.builder().numberCarriage(createTrainCommand.getNumberCarriage())
                .build();
    }

    public CreateTrainResponse toResponseCreateTrain(Train responsePersistence) {
        return CreateTrainResponse.builder()
                .id(responsePersistence.getId())
                .serialNumber(responsePersistence.getSerialNumber())
                .build();
    }

    public ResponseFindByIdTrain toResponseByID(Train train) {
        return ResponseFindByIdTrain.builder().id(train.getId()).serialNumber(train.getSerialNumber()).build();
    }
}
