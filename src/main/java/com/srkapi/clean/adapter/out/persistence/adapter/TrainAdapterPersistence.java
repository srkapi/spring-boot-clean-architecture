package com.srkapi.clean.adapter.out.persistence.adapter;


import com.srkapi.clean.adapter.out.persistence.mapper.MapperPersistence;
import com.srkapi.clean.adapter.out.persistence.model.TrainModel;
import com.srkapi.clean.adapter.out.persistence.repository.TrainRepository;
import com.srkapi.clean.application.port.out.FindTrainByIdPort;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import com.srkapi.clean.domain.entities.Train;
import com.srkapi.clean.domain.exception.ErrorPersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainAdapterPersistence implements PersistenceTrainPort, FindTrainBySerialNumberPort, FindTrainByIdPort {
	private final TrainRepository trainRepository;
	private final MapperPersistence mapperPersistence;

	@Override
	public Long saveTrain(Train train) {
		try {
			TrainModel trainModel = this.mapperPersistence.toModelPersistence(train);
			TrainModel saveTrain = this.trainRepository.save(trainModel);
			return saveTrain.getId();
		} catch (Exception e) {
			throw new ErrorPersistenceException();
		}
	}

	@Override
	public Train findBySerialNumber(String serialNumber) {
		return this.mapperPersistence.toDomain(this.trainRepository.findBySerialNumber(serialNumber));
	}

	@Override
	public Train findById(Long id) {
		Optional<TrainModel> byId = this.trainRepository.findById(id);
		return byId.map(this.mapperPersistence::toDomain).orElse(null);
	}

}
