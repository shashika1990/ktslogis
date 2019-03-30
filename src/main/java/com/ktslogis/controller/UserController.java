package com.ktslogis.controller;

import com.ktslogis.dto.UserDto;
import com.ktslogis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public String save(@RequestBody UserDto dto){
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

    @PutMapping
    public String update(@RequestBody UserDto dto) {
        try {
            if(0 < service.update(dto)) {
                return "Successfully updated";
            } else {
                return "Record could not be updated";
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "No matching record found for the given ID.";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occured";
        }
    }


    @GetMapping(value = "all")
    public List<UserDto> getAll(){
        List<UserDto> dtos = new ArrayList<>();
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
