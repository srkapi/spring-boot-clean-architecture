package com.srkapi.clean.application.port.in.mapper;


import com.srkapi.clean.application.usecases.CreateTrainUseCase;
import com.srkapi.clean.application.usecases.FindTrainByIdUseCase;
import com.srkapi.clean.domain.entities.Train;
import org.springframework.stereotype.Component;

@Component
public class MapperDomain {

    public Train toDomain(CreateTrainUseCase.CreateTrainCommand createTrainCommand) {
        return Train.builder().numberCarriage(createTrainCommand.getCarriageNumber())
                .build();
    }

    public CreateTrainUseCase.CreateTrainResponse toResponseCreateTrain(Train responsePersistence) {
        return CreateTrainUseCase.CreateTrainResponse.builder()
                .id(responsePersistence.getId())
                .serialNumber(responsePersistence.getSerialNumber())
                .build();
    }

    public FindTrainByIdUseCase.FindTrainByIdOutput toResponseByID(Train train) {
        return FindTrainByIdUseCase.FindTrainByIdOutput.builder().id(train.getId()).serialNumber(train.getSerialNumber()).build();
    }
}
