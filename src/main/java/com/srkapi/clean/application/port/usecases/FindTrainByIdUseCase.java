package com.srkapi.clean.application.port.usecases;

import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;

import java.util.Optional;

public interface FindTrainByIdUseCase {
    Optional<ResponseFindByIdTrain> execute(Long id);
}
