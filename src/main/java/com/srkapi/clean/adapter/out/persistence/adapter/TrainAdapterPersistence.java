package com.srkapi.clean.adapter.out.persistence.adapter;


import com.srkapi.clean.adapter.out.persistence.mapper.MapperPersistence;
import com.srkapi.clean.adapter.out.persistence.model.TrainModel;
import com.srkapi.clean.adapter.out.persistence.repository.TrainRepository;
import com.srkapi.clean.application.domain.Train;
import com.srkapi.clean.application.port.out.FindTrainByIdPort;
import com.srkapi.clean.application.port.out.FindTrainBySerialNumberPort;
import com.srkapi.clean.application.port.out.PersistenceTrainPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainAdapterPersistence implements PersistenceTrainPort, FindTrainBySerialNumberPort, FindTrainByIdPort {
    private final TrainRepository trainRepository;
    private final MapperPersistence mapperPersistence;

    @Override
    public Optional saveTrain(Train train) {
        TrainModel trainModel = this.mapperPersistence.toModelPersistence(train);
        TrainModel saveTrain = this.trainRepository.save(trainModel);
        return this.mapperPersistence.toDomain(saveTrain);
    }

    @Override
    public Optional findBySerialNumber(String serialNumber) {
        return this.mapperPersistence.toDomain(this.trainRepository.findBySerialNumber(serialNumber));
    }

    @Override
    public Optional findById(Long id) {

        Optional<TrainModel> byId = this.trainRepository.findById(id);
        Optional optional = byId.map(it -> {
                    return this.mapperPersistence.toDomain(it);
                }
        ).orElse(Optional.empty());
        return optional;
    }

}
