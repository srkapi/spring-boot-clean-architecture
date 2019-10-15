package com.srkapi.clean.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Train {
    private Long id;
    private Long numberCarriage;
    private String serialNumber;

}
