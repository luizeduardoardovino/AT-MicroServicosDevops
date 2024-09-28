package com.meuprojeto.vehicle_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuprojeto.vehicle_service.model.Vehicle;
import com.meuprojeto.vehicle_service.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setmanufactureYear(2020);

        mockMvc.perform(post("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.make", is("Toyota")))
                .andExpect(jsonPath("$.model", is("Corolla")));
    }

    @Test
    void shouldGetAllVehicles() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setmanufactureYear(2020);
        vehicleRepository.save(vehicle);

        mockMvc.perform(get("/vehicles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].make", is("Toyota")));
    }

    @Test
    void shouldGetVehicleById() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setmanufactureYear(2020);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        mockMvc.perform(get("/vehicles/{id}", savedVehicle.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.make", is("Toyota")));
    }

    @Test
    void shouldUpdateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setmanufactureYear(2020);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        Vehicle updatedVehicle = new Vehicle();
        updatedVehicle.setMake("Honda");
        updatedVehicle.setModel("Civic");
        updatedVehicle.setmanufactureYear(2021);

        mockMvc.perform(put("/vehicles/{id}", savedVehicle.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedVehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.make", is("Honda")))
                .andExpect(jsonPath("$.model", is("Civic")))
                .andExpect(jsonPath("$.manufactureYear", is(2021)));
    }

    @Test
    void shouldDeleteVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setmanufactureYear(2020);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        mockMvc.perform(delete("/vehicles/{id}", savedVehicle.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/vehicles/{id}", savedVehicle.getId()))
                .andExpect(status().isNotFound());
    }
}
