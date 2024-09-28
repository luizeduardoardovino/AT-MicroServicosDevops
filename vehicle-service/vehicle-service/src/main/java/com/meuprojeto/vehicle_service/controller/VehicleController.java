package com.meuprojeto.vehicle_service.controller;

import com.meuprojeto.vehicle_service.model.Vehicle;	
import com.meuprojeto.vehicle_service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updatedVehicle) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicle.setMake(updatedVehicle.getMake());
                    vehicle.setModel(updatedVehicle.getModel());
                    vehicle.setmanufactureYear(updatedVehicle.getmanufactureYear());
                    return vehicleRepository.save(vehicle);
                })
                .orElseGet(() -> {
                    updatedVehicle.setId(id);
                    return vehicleRepository.save(updatedVehicle);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }
}
