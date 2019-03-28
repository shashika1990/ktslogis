package com.ktslogis.controller;

import com.ktslogis.dto.ContainerDto;
import com.ktslogis.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    private ContainerService service;

    @PostMapping
    public String save(@RequestBody ContainerDto dto) {
        System.out.println(dto.toString());

        try {
            if(0 <= service.save(dto)) {
                return "Successfully saved";
            } else {
                return "Record could not be saved";
            }

        } catch (Exception e) {
//            e.printStackTrace();
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
    public String update(@RequestBody ContainerDto dto, int id) {
        try {
            if(0 <= service.update(dto, id)) {
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
    public ContainerDto get(@RequestParam int id) {

        ContainerDto dto = null;
        try {
            dto = service.get(id);
            return dto;
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
