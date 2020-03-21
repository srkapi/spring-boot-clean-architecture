package com.srkapi.clean.application.port.usecases;

import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;

import java.util.Optional;

public interface FindTrainByIdUseCases {
    Optional<ResponseFindByIdTrain> process(Long id);
}
