package com.ktslogis.controller;

import com.ktslogis.dto.HireDto;
import com.ktslogis.dto.VehicleDto;
import com.ktslogis.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/hire")
public class HireController {

    @Autowired
    HireService service;

    @PostMapping
    public String save(@RequestBody HireDto dto) {
        try {
            if(0 <= service.save(dto)) {
                return "Successfully saved";
            } else {
                return "Record could not be saved";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @DeleteMapping
    public String delete(@RequestParam int id) {

        try {
            service.delete(id);
            return "Successfully deleted";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return "No matching record found for the given ID.";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @PutMapping
    public String update(@RequestBody HireDto dto) {
        try {
            if(0 <= service.update(dto)) {
                return "Successfully updated";
            } else {
                return "Record could not be updated";
            }
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return "No matching record found for the given ID.";
        } catch (Exception e) {
//            e.printStackTrace();
            return "An error occured";
        }

    }

    @GetMapping
    public HireDto get(@RequestParam int id) {

        System.out.println("Hire Id: " + id); //todo delete this code line
        HireDto dto = null;
        try {
            dto = service.get(id);
            return dto;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping(value = "/all")
    public List<HireDto> getAll() {

        try {
            List<HireDto> hireDtos = service.getAll();
            return hireDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
