package com.srkapi.clean.adapter.in.web;

import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.ResponseCreateTrain;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import com.srkapi.clean.application.port.usecases.CreateTrainUseCases;
import com.srkapi.clean.application.port.usecases.FindTrainByIdUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/train")
public class RestControllerTrain {

    private final CreateTrainUseCases createTrainUseCases;
    private final FindTrainByIdUseCases findTrainByIdUseCases;


    @PostMapping
    public ResponseEntity<ResponseCreateTrain> createTrain(
            @Valid @RequestBody CreateTrainCommand createTrainCommand) {

        ResponseCreateTrain result = this.createTrainUseCases.process(createTrainCommand);
        return new ResponseEntity<ResponseCreateTrain>(result, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFindByIdTrain> findByIdTrain(@PathVariable("id") Long id) {

        Optional<ResponseFindByIdTrain> trainOptional = this.findTrainByIdUseCases.process(id);


        ResponseEntity<ResponseFindByIdTrain> result = trainOptional.map(it ->
                new ResponseEntity<ResponseFindByIdTrain>(it, OK)
        ).orElse(
                new ResponseEntity<ResponseFindByIdTrain>(INTERNAL_SERVER_ERROR)
        );


        return result;
    }


}
