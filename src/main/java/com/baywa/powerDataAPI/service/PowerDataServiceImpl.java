package com.baywa.powerDataAPI.service;

import com.baywa.powerDataAPI.error.PowerDataNotFoundException;
import com.baywa.powerDataAPI.model.PowerData;
import com.baywa.powerDataAPI.repository.PowerDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baywa.powerDataAPI.util.DateUtils.getNow;

@Service
@RequiredArgsConstructor
public class PowerDataServiceImpl implements PowerDataService {

    private final PowerDataRepository powerDataRepository;

    @Override
    public List<PowerData> getPowerDataList() {
        return powerDataRepository.findAll();
    }

    @Override
    public PowerData getPowerData(String id) {
        return powerDataRepository.findById(id).orElseThrow(() -> new PowerDataNotFoundException(id));
    }

    @Override
    public PowerData updatePowerProducedById(String id, PowerData newPowerData) {
        return powerDataRepository.findById(id).map(powerData -> {
            powerData.setPowerProduced(newPowerData.getPowerProduced());
            powerData.setUpdatedOn(getNow());
            return powerDataRepository.save(powerData);
        }).orElseThrow(() -> new PowerDataNotFoundException(id));
    }
}
