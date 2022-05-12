package com.srkapi.clean.application.port.out;

import com.srkapi.clean.domain.entities.Train;

public interface PersistenceTrainPort {
    Long saveTrain(Train train);
}
