package com.srkapi.clean.application.usecases;

public interface UseCase<I extends UseCase.InputValues, O extends UseCase.OutputValues> {

	O execute(I input) throws Exception;

	interface InputValues {
	}

	interface OutputValues {
	}
}