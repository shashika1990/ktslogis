package com.ktslogis.service;

import com.ktslogis.dto.VehicleDto;
import com.ktslogis.entity.Vehicle;
import com.ktslogis.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    @Autowired
    VehicleRepository repository;

    public int saveVehicle(VehicleDto dto) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNo(dto.getVehicleNo());
        vehicle.setVehicleStatus(dto.getVehicleStatus());

        Vehicle result = repository.save(vehicle);

        return result.getId();
    }

    public int updateVehicle(VehicleDto dto) throws Exception {
        Optional<Vehicle> optional = repository.findById(dto.getId());
        Vehicle vehicle = optional.get();

        vehicle.setVehicleNo(dto.getVehicleNo());
        vehicle.setVehicleStatus(dto.getVehicleStatus());

        Vehicle result = repository.save(vehicle);

        return result.getId();
    }

    public void deleteVehicle(int id) throws Exception {
        Optional<Vehicle> optional = repository.findById(id);
        Vehicle vehicle = optional.get();

        repository.delete(vehicle);
    }

    public VehicleDto getVehicle(int id) throws Exception {
        Optional<Vehicle> optional = repository.findById(id);
        Vehicle vehicle = optional.get();

        VehicleDto dto = new VehicleDto();
        dto.setId(vehicle.getId());
        dto.setVehicleNo(vehicle.getVehicleNo());
        dto.setVehicleStatus(dto.getVehicleStatus());

        return dto;
    }

}
