package com.baywa.powerDataAPI.service;

import com.baywa.powerDataAPI.model.PowerData;

import java.util.List;

public interface PowerDataService {

    List<PowerData> getPowerDataList();

    PowerData getPowerData(String id);

    PowerData updatePowerProducedById(String id, PowerData powerData);

}
