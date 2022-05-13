package com.srkapi.clean.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Train {
	private Long id;
	private Long numberCarriage;
	private String serialNumber;

}
