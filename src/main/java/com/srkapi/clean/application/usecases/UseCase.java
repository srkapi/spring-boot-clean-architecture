package com.srkapi.clean.application.usecases;

import com.srkapi.clean.domain.exception.TrainDoesNotExistException;

public abstract class UseCase<I extends UseCase.InputValues, O extends UseCase.OutputValues> {

    public abstract O execute(I input) throws Exception;

    public interface InputValues {
    }

    public interface OutputValues {
    }
}