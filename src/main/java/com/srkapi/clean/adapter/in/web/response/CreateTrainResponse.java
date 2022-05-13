package com.srkapi.clean.adapter.in.web.response;

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
