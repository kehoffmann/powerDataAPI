package com.baywa.powerDataAPI.config;

import com.baywa.powerDataAPI.model.PowerData;
import com.baywa.powerDataAPI.repository.PowerDataRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PowerDataRepository repository) {

        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<PowerData>> typeReference = new TypeReference<>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/powerProduced.json");
            try {
                List<PowerData> powerData = mapper.readValue(inputStream, typeReference);
                repository.saveAll(powerData);
                log.info("PowerData Saved!");
            } catch (IOException e) {
                log.error("Unable to save powerData: " + e.getMessage());
            }
        };
    }
}