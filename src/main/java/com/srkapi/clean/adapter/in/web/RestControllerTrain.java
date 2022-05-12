package com.srkapi.clean.adapter.in.web;

import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.CreateTrainResponse;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import com.srkapi.clean.application.port.usecases.CreateTrainUseCase;
import com.srkapi.clean.application.port.usecases.FindTrainByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/train")
public class RestControllerTrain {

	private final CreateTrainUseCase createTrainUseCases;
	private final FindTrainByIdUseCase findTrainByIdUseCases;


	@PostMapping
	public ResponseEntity<CreateTrainResponse> createTrain(
			@Valid @RequestBody CreateTrainCommand createTrainCommand) {
		CreateTrainResponse result = this.createTrainUseCases.execute(createTrainCommand);
		return new ResponseEntity<>(result, OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseFindByIdTrain> findByIdTrain(@PathVariable("id") Long id) {
		Optional<ResponseFindByIdTrain> trainOptional = this.findTrainByIdUseCases.execute(id);
		return trainOptional.map(it ->
				new ResponseEntity<>(it, OK)
		).orElse(
				new ResponseEntity<>(INTERNAL_SERVER_ERROR)
		);
	}

}
