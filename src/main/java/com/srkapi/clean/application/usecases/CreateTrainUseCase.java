package com.srkapi.clean.application.usecases;

import com.srkapi.clean.application.port.in.mapper.DomainMapper;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.domain.exception.TrainExistException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateTrainUseCase implements UseCase<CreateTrainUseCase.CreateTrainInput, CreateTrainUseCase.CreateTrainOutput> {

	private final FindTrainBySerialNumberPort findTrainBySerialNumberPort;
	private final PersistenceTrainPort persistenceTrainPort;

	@Override
	public CreateTrainOutput execute(CreateTrainInput input) {
		Train train = DomainMapper.toDomain(input);
		String serialNumber = UUID.randomUUID().toString();
		verifyIfSerialNumberExist(serialNumber);
		train.setSerialNumber(serialNumber);
		train.setId(this.persistenceTrainPort.saveTrain(train));
		return DomainMapper.toResponseCreateTrain(train);
	}

	private void verifyIfSerialNumberExist(String serialNumber) {
		Train bySerialNumber = this.findTrainBySerialNumberPort.findBySerialNumber(serialNumber);
		if (bySerialNumber != null) throw new TrainExistException("Train exist with this serial number:" +
				serialNumber);
	}

	@Value
	public static class CreateTrainInput implements UseCase.InputValues {
		Long carriageNumber;
	}

	@Getter
	@Setter
	@Builder
	public static class CreateTrainOutput implements UseCase.OutputValues {
		Long id;
		String serialNumber;
	}

}
