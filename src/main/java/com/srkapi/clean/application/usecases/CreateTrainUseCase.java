package com.srkapi.clean.application.usecases;

import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.domain.exception.TrainExistException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateTrainUseCase extends UseCase<CreateTrainUseCase.CreateTrainCommand, CreateTrainUseCase.CreateTrainResponse> {

	private final FindTrainBySerialNumberPort findTrainBySerialNumberPort;
	private final PersistenceTrainPort persistenceTrainPort;
	private final MapperDomain mapperTrain;



	@Override
	public CreateTrainResponse execute(CreateTrainCommand input) {
		Train train = mapperTrain.toDomain(input);
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

	@Value
	public static class CreateTrainCommand implements UseCase.InputValues {
		Long carriageNumber;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class CreateTrainResponse implements UseCase.OutputValues {
		Long id;
		String serialNumber;
	}

}
