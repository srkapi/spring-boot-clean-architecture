package com.srkapi.clean.application.port.in.model;

import com.srkapi.clean.adapter.in.web.annotation.TrainCreatedValid;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TrainCreatedValid
public class CreateTrainCommand implements Serializable{
    private Long numberCarriage;

}
