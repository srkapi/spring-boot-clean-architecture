package com.srkapi.clean.adapter.in.web.annotation;

import com.srkapi.clean.application.usecases.CreateTrainUseCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TrainValidator implements ConstraintValidator<TrainCreatedValid, CreateTrainUseCase.CreateTrainCommand> {
    @Override
    public void initialize(TrainCreatedValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateTrainUseCase.CreateTrainCommand value, ConstraintValidatorContext context) {

        return true;
    }
}
