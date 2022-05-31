package com.srkapi.clean.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindTrainByIdResponse {
	private Long id;
	private String serialNumber;
}
