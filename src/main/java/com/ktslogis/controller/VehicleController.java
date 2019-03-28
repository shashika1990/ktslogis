package com.ktslogis.controller;

import com.ktslogis.Other.JSONResponse;
import com.ktslogis.dto.VehicleDto;
import com.ktslogis.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    VehicleService service;

    @PostMapping
    public JSONResponse save(@RequestBody @Valid VehicleDto dto) {

        try {
            int id = service.saveVehicle(dto);
            if (0 <= id) {
                String response = "Record saved successfully";
                return new JSONResponse(response);
            } else {
                String response = "Record could not be saved";
                return new JSONResponse(response);
            }
        } catch (MethodArgumentNotValidException e) {
            String response = "Invalid data";
            return new JSONResponse(response);

        } catch (Exception e) {
            return new JSONResponse(e.getMessage());
        }

    }

    @PutMapping
    public JSONResponse update(@RequestBody VehicleDto dto) {
        try {
            int id = service.updateVehicle(dto);
            if (0 <= id) {
                String response = "Record updated successfully";
                return new JSONResponse(response);
            } else {
                String response = "Record could not be updated";
                return new JSONResponse(response);
            }
        } catch (MethodArgumentNotValidException e) {
            String response = "Invalid data";
            return new JSONResponse(response);

        } catch (Exception e) {
            return new JSONResponse(e.getMessage());
        }
    }


    @DeleteMapping
    public JSONResponse delete(@RequestParam int id) {
        try {
            service.deleteVehicle(id);
            String response = "Deleted successfully";
            return new JSONResponse(response);
        } catch (Exception e) {
//            e.printStackTrace();
            return new JSONResponse(e.getMessage());
        }

    }

    @GetMapping
    public VehicleDto get(@RequestParam int id) {
        try {
            VehicleDto dto = service.getVehicle(id);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
