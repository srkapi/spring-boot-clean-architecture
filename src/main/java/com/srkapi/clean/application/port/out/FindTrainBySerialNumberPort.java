package com.srkapi.clean.application.port.out;

import com.srkapi.clean.domain.entities.Train;

public interface FindTrainBySerialNumberPort {
    Train findBySerialNumber(String serialNumber);
}
