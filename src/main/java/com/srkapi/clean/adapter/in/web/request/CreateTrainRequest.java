package com.srkapi.clean.adapter.in.web.request;

import com.srkapi.clean.adapter.in.web.annotation.TrainCreatedValid;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TrainCreatedValid
public class CreateTrainRequest {
	private Long numberCarriage;
}
