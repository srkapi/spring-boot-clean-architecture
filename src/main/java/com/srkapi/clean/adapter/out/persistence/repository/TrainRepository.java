package com.srkapi.clean.adapter.out.persistence.repository;

import com.srkapi.clean.adapter.out.persistence.model.TrainModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<TrainModel,Long> {
    TrainModel findBySerialNumber(String serialNumber);
}