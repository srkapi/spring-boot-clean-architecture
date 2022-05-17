package com.srkapi.clean.application.usecases;

import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.out.FindTrainByIdPort;
import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.domain.exception.TrainDoesNotExistException;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class FindTrainByIdUseCase extends UseCase<FindTrainByIdUseCase.FindTrainByIdInput, FindTrainByIdUseCase.FindTrainByIdOutput> {
	private final FindTrainByIdPort findTrainByidPort;
	private final MapperDomain mapperDomain;


	@Override
	public FindTrainByIdOutput execute(FindTrainByIdInput input) throws Exception {
		Train trainById = this.findTrainByidPort.findById(input.getId());
		if (trainById == null) throw new TrainDoesNotExistException();
		return this.mapperDomain.toResponseByID(trainById);
	}


	@Value
	public static class FindTrainByIdInput implements UseCase.InputValues {
		Long id;
	}

	@Builder
	@Data
	public static class FindTrainByIdOutput implements UseCase.OutputValues {
		Long id;
		String serialNumber;
	}
}
