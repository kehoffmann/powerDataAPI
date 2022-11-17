package com.baywa.powerDataAPI.controller;

import com.baywa.powerDataAPI.model.PowerData;
import com.baywa.powerDataAPI.service.PowerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/powerData")
public class PowerDataController {

    private final PowerDataService powerDataService;

    @GetMapping()
    public List<PowerData> getPowerDataList() {
        return powerDataService.getPowerDataList();
    }

    @GetMapping("/{id}")
    public PowerData getPowerDataById(@PathVariable String id) {
        return powerDataService.getPowerData(id);
    }

    @PutMapping("/{id}")
    public PowerData updatePowerProducedById(@PathVariable String id, @RequestBody PowerData newPowerData) {
        return powerDataService.updatePowerProducedById(id, newPowerData);
    }

}
