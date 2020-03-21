package com.srkapi.clean.application.port.in.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Builder
public class ResponseFindByIdTrain implements Serializable {
    private Long id;
    private String serialNumber;
}
