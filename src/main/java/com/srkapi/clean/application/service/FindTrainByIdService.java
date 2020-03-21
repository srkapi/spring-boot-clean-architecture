package com.srkapi.clean.application.service;

import com.srkapi.clean.application.domain.Train;
import com.srkapi.clean.application.port.in.mapper.MapperDomain;
import com.srkapi.clean.application.port.in.model.ResponseFindByIdTrain;
import com.srkapi.clean.application.port.out.FindTrainByIdPort;
import com.srkapi.clean.application.port.usecases.FindTrainByIdUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class FindTrainByIdService implements FindTrainByIdUseCases {
    private final FindTrainByIdPort findTrainByidPort;
    private final MapperDomain mapperDomain;

    @Override
    public Optional<ResponseFindByIdTrain> process(Long id) {

        Optional<Train> byId = this.findTrainByidPort.findById(id);

        Optional<ResponseFindByIdTrain> responseFindByIdTrain = Optional.ofNullable(byId.map(it -> {
            return this.mapperDomain.toResponseByID(it);
        }).orElse(null));
        return responseFindByIdTrain;
    }
}
