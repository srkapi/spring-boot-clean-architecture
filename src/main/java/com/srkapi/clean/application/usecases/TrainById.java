package com.srkapi.clean.application.usecases;

import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import com.srkapi.clean.application.port.out.FindTrainByIdPort;
import com.srkapi.clean.application.port.usecases.FindTrainByIdUseCase;
import com.srkapi.clean.domain.entities.Train;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class TrainById implements FindTrainByIdUseCase {
	private final FindTrainByIdPort findTrainByidPort;
	private final MapperDomain mapperDomain;

	@Override
	public Optional<ResponseFindByIdTrain> execute(Long id) {
		Train trainById = this.findTrainByidPort.findById(id);
		if (trainById == null) return Optional.empty();
		return Optional.of(this.mapperDomain.toResponseByID(trainById));
	}
}
