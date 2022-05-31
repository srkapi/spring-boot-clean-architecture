package com.srkapi.clean.application.port.in.mapper;


import com.srkapi.clean.application.usecases.CreateTrainUseCase;
import com.srkapi.clean.application.usecases.FindTrainByIdUseCase;
import com.srkapi.clean.domain.entities.Train;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DomainMapper {

	public Train toDomain(CreateTrainUseCase.CreateTrainInput createTrainCommand) {
		return Train.builder().numberCarriage(createTrainCommand.getCarriageNumber())
				.build();
	}

	public CreateTrainUseCase.CreateTrainOutput toResponseCreateTrain(Train responsePersistence) {
		return CreateTrainUseCase.CreateTrainOutput.builder()
				.id(responsePersistence.getId())
				.serialNumber(responsePersistence.getSerialNumber())
				.build();
	}

	public FindTrainByIdUseCase.FindTrainByIdOutput toResponseByID(Train train) {
		return FindTrainByIdUseCase.FindTrainByIdOutput.builder().id(train.getId()).serialNumber(train.getSerialNumber()).build();
	}
}
