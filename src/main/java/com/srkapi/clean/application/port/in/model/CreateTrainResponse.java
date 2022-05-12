package com.srkapi.clean.application.port.in.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTrainResponse {
	private Long id;
	private String serialNumber;
}
