package com.srkapi.clean.application.port.out;

import com.srkapi.clean.application.domain.Train;

import java.util.Optional;

public interface FindTrainBySerialNumberPort {
    Optional findBySerialNumber(String serialNumber);
}
