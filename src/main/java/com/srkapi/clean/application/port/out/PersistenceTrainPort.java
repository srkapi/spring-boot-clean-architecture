package com.srkapi.clean.application.port.out;

import com.srkapi.clean.application.domain.Train;

import java.util.Optional;

public interface PersistenceTrainPort {
    Optional saveTrain(Train train);
}
