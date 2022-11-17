package com.baywa.powerDataAPI.repository;

import com.baywa.powerDataAPI.model.PowerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerDataRepository extends JpaRepository<PowerData, String> {
}
