package com.srkapi.clean.application.port.usecases;

import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.CreateTrainResponse;

public interface CreateTrainUseCase {
    CreateTrainResponse execute(CreateTrainCommand createTrainCommand);
}
