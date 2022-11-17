package com.baywa.powerDataAPI.service;

import com.baywa.powerDataAPI.error.PowerDataNotFoundException;
import com.baywa.powerDataAPI.model.PowerData;
import com.baywa.powerDataAPI.repository.PowerDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.baywa.powerDataAPI.util.DateUtils.getNow;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PowerDataServiceImplTest {

    @Mock
    private PowerDataRepository powerDataRepository;
    @InjectMocks
    private PowerDataServiceImpl powerDataService;


    @Test
    public void shouldReturnPowerDataList() {
        PowerData powerData1 = buildPowerData("1");
        PowerData powerData2 = buildPowerData("2");
        when(powerDataRepository.findAll()).thenReturn(List.of(powerData1, powerData2));

        List<PowerData> resultList = powerDataService.getPowerDataList();

        assertNotNull(resultList);
        assertEquals(2, resultList.size());
    }

    @Test
    public void shouldReturnPowerData() {
        PowerData powerData = buildPowerData("1");

        when(powerDataRepository.findById("1")).thenReturn(Optional.of(powerData));

        PowerData result = powerDataService.getPowerData("1");

        assertNotNull(result);
    }

    @Test
    public void shouldThrowNotFoundException() {
        when(powerDataRepository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(PowerDataNotFoundException.class, () -> powerDataService.getPowerData("wrongId"));
    }

    @Test
    public void shouldUpdatePowerProducedOfPowerData() {
        PowerData powerData = buildPowerData("1");

        when(powerDataRepository.findById("1")).thenReturn(Optional.of(powerData));
        when(powerDataRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        double updatePowerProduced = 8.5;
        PowerData result = powerDataService.updatePowerProducedById("1", PowerData.builder().powerProduced(updatePowerProduced).build());

        assertNotNull(result);
        assertEquals(updatePowerProduced, result.getPowerProduced());
    }

    private PowerData buildPowerData(String id) {
        return PowerData.builder()
                .id(id)
                .windPark("testWindPark").
                powerProduced(6.35)
                .period("30M")
                .createdOn(getNow())
                .timestamp(getNow())
                .updatedOn(getNow())
                .build();
    }

}