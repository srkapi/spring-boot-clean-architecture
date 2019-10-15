package com.srkapi.clean.application.port.usecases;

import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.ResponseCreateTrain;

public interface CreateTrainUseCases {
    ResponseCreateTrain process(CreateTrainCommand createTrainCommand);
}
