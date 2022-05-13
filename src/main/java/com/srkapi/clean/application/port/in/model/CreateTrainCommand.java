package com.srkapi.clean.application.port.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTrainCommand {
	private final Long numberCarriage;
}
