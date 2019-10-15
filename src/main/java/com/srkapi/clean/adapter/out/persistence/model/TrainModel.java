package com.srkapi.clean.adapter.out.persistence.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
public class TrainModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "serial_number", nullable = false)
    private String serialNumber;
    @Column(name = "carriage", nullable = false)
    private Long carriage;

}
