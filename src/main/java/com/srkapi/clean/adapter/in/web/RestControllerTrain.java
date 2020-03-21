package com.srkapi.clean.adapter.in.web;

import com.srkapi.clean.application.port.in.model.CreateTrainCommand;
import com.srkapi.clean.application.port.in.model.ResponseCreateTrain;
import com.srkapi.clean.application.port.usecases.CreateTrainUseCases;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/train")
public class RestControllerTrain {

    private final CreateTrainUseCases createTrainUseCases;


    @PostMapping
    public ResponseEntity<ResponseCreateTrain> createTrain(
            @Valid @RequestBody CreateTrainCommand createTrainCommand){

        ResponseCreateTrain result = this.createTrainUseCases.process(createTrainCommand);
        return new ResponseEntity<ResponseCreateTrain>(result,HttpStatus.OK);
    }

    @GetMapping
    public String hello(){
                return "holita";
    }






}
