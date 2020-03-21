package com.srkapi.clean.application.port.out;

import java.util.Optional;

public interface FindTrainByIdPort {

    Optional findById(Long id);
}
