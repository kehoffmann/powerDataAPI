package com.baywa.powerDataAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PowerData {

    @Id
    private String id;
    private String windPark;
    private double powerProduced;
    private String period;
    private String timestamp;
    private String createdOn;
    private String updatedOn;

}
