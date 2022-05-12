package com.srkapi.clean.adapter.out.persistence.mapper;


import com.srkapi.clean.adapter.out.persistence.model.TrainModel;
import com.srkapi.clean.domain.entities.Train;
import org.springframework.stereotype.Component;

@Component
public class MapperPersistence {

	public TrainModel toModelPersistence(Train domain) {
		return TrainModel.builder()
				.carriage(domain.getNumberCarriage())
				.serialNumber(domain.getSerialNumber())
				.build();
	}

	public Train toDomain(TrainModel model) {
		if (model == null) {
			return null;
		}
		return Train.builder().id(model.getId())
				.serialNumber(model.getSerialNumber())
				.numberCarriage(model.getCarriage())
				.build();

	}
}
