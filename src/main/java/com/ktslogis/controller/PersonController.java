package com.ktslogis.controller;

import com.ktslogis.dto.PersonDto;
import com.ktslogis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping
    public String save(@RequestBody @Valid PersonDto dto){
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
    public String update(@RequestBody @Valid PersonDto dto) {
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


    @GetMapping(value = "all")
    public List<PersonDto> getAll(){
        List<PersonDto> dtos = new ArrayList<>();
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
