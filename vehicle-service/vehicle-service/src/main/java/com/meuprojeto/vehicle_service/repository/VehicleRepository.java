package com.meuprojeto.vehicle_service.repository;

import com.meuprojeto.vehicle_service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
