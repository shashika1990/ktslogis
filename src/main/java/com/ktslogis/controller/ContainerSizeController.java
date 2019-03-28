package com.ktslogis.controller;

import com.ktslogis.dto.ContainerSizeDto;
import com.ktslogis.service.ContainerSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/container/size")
public class ContainerSizeController {

    @Autowired
    ContainerSizeService service;

    @PostMapping
    public String save(@RequestBody ContainerSizeDto dto){
        System.out.println(dto);
        try {
            //if the generated id is greater than 0, record has been saved successfully
            if(0 <= service.save(dto)) {
                return "Successfully saved";
            } else {
                return "Record could not be saved";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occured";
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
            return "Record could not be deleted";
        }
    }

    @PutMapping
    public String update(@RequestBody ContainerSizeDto dto) {
        try {
            if(0 < service.update(dto)) {
                return "Successfully updated";
            } else {
                return "Record could not be updated";
            }
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return "No matching record found for the given ID.";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occured";
        }
    }

    @GetMapping
    public ContainerSizeDto retrieve(@RequestParam int id) {

        ContainerSizeDto dto = null;
        try {
            dto = service.getContainerSize(id);
            return dto;
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return dto;
        }

    }

    @GetMapping(value = "all")
    public List<ContainerSizeDto> retrieveAll(){
        List<ContainerSizeDto> dtos = new ArrayList<>();
        try {
            dtos = service.getAll();
            if (!dtos.isEmpty()) {
                return dtos;
            } else {
                System.out.println("No records found");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
