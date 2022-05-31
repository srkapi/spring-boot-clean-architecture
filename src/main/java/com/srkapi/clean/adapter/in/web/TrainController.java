package com.srkapi.clean.adapter.in.web;

import com.srkapi.clean.adapter.in.web.request.CreateTrainRequest;
import com.srkapi.clean.adapter.in.web.response.CreateTrainResponse;
import com.srkapi.clean.adapter.in.web.response.FindTrainByIdResponse;
import com.srkapi.clean.application.usecases.CreateTrainUseCase;
import com.srkapi.clean.application.usecases.FindTrainByIdUseCase;
import com.srkapi.clean.application.usecases.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequestMapping("/train")
public class TrainController {

	private final UseCase<CreateTrainUseCase.CreateTrainInput, CreateTrainUseCase.CreateTrainOutput> createTrainUseCases;
	private final UseCase<FindTrainByIdUseCase.FindTrainByIdInput, FindTrainByIdUseCase.FindTrainByIdOutput>  findTrainByIdUseCases;

	public TrainController(UseCase<CreateTrainUseCase.CreateTrainInput, CreateTrainUseCase.CreateTrainOutput> createTrainUseCases, UseCase<FindTrainByIdUseCase.FindTrainByIdInput, FindTrainByIdUseCase.FindTrainByIdOutput> findTrainByIdUseCases) {
		this.createTrainUseCases = createTrainUseCases;
		this.findTrainByIdUseCases = findTrainByIdUseCases;
	}


	@PostMapping
	public ResponseEntity<CreateTrainResponse> createTrain(@Valid @RequestBody CreateTrainRequest createTrainCommand) throws Exception {
		CreateTrainUseCase.CreateTrainOutput result = this.createTrainUseCases.execute(new CreateTrainUseCase.CreateTrainInput(createTrainCommand.getNumberCarriage()));
		return new ResponseEntity<>(fromCreateTrainDomainToResponse(result), CREATED);
	}


	@GetMapping("/{id}")
	public ResponseEntity<FindTrainByIdResponse> findByIdTrain(@PathVariable("id") Long id) throws Exception {
		FindTrainByIdUseCase.FindTrainByIdOutput result = this.findTrainByIdUseCases.execute(new FindTrainByIdUseCase.FindTrainByIdInput(id));
		return new ResponseEntity<>(fromFindTrainByIdToResponse(result), OK);
	}

	private FindTrainByIdResponse fromFindTrainByIdToResponse(FindTrainByIdUseCase.FindTrainByIdOutput response) {
		return new FindTrainByIdResponse(response.getId(), response.getSerialNumber());
	}

	private CreateTrainResponse fromCreateTrainDomainToResponse(CreateTrainUseCase.CreateTrainOutput result) {
		return new CreateTrainResponse(result.getSerialNumber());
	}

}
