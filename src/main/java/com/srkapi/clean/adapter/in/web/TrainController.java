package com.srkapi.clean.adapter.in.web;

import com.srkapi.clean.adapter.in.web.request.CreateTrainRequest;
import com.srkapi.clean.application.usecases.CreateTrainUseCase;
import com.srkapi.clean.application.usecases.FindTrainByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/train")
public class TrainController {

	private final CreateTrainUseCase createTrainUseCases;
	private final FindTrainByIdUseCase findTrainByIdUseCases;


	@PostMapping
	public ResponseEntity<com.srkapi.clean.application.usecases.CreateTrainUseCase.CreateTrainResponse> createTrain(@Valid @RequestBody CreateTrainRequest createTrainCommand) {
		com.srkapi.clean.application.usecases.CreateTrainUseCase.CreateTrainResponse result = this.createTrainUseCases.execute(new CreateTrainUseCase.CreateTrainCommand(createTrainCommand.getNumberCarriage()));
		return new ResponseEntity<>(result, OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FindTrainByIdUseCase.FindTrainByIdOutput> findByIdTrain(@PathVariable("id") Long id) throws Exception {
		FindTrainByIdUseCase.FindTrainByIdOutput response = this.findTrainByIdUseCases.execute(new FindTrainByIdUseCase.FindTrainByIdInput(id));
		return new ResponseEntity<>(response, OK);
	}

}
