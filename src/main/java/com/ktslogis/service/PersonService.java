package com.ktslogis.service;

import com.ktslogis.dto.JobRoleDto;
import com.ktslogis.dto.PersonDto;
import com.ktslogis.entity.JobRole;
import com.ktslogis.entity.Person;
import com.ktslogis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository repository;

    public int save(PersonDto dto) throws Exception {

        JobRole jobRole = new JobRole();
        jobRole.setId(dto.getJobRole().getId());

        Person person = new Person();
        person.setName(dto.getName());
        person.setJobRole(jobRole);


        Person result = repository.save(person);

        return result.getId();

    }

    public int update(PersonDto dto) throws Exception {
        Optional<Person> optional = repository.findById(dto.getId());
        Person person = optional.get();

        person.setName(dto.getName());
        //changing the job role of the person
        person.getJobRole().setId(dto.getJobRole().getId());

        Person result = repository.save(person);

        return result.getId();


    }

    public void delete(int id) throws Exception {
        Optional<Person> optional = repository.findById(id);
        Person person = optional.get();

        repository.delete(person);


    }

    public List<PersonDto> getAll() {
        List<Person> personList = repository.findAll();

        //creating a PersonDtolist from the data retrived from database;
        List<PersonDto> personDtoList = new ArrayList<>();

        for (Person person : personList) {
            //adding a new PersonDto onject to the PersonDtolist
            personDtoList.add(
                    new PersonDto(
                        person.getId(),
                        person.getName(),
                        new JobRoleDto(
                                person.getJobRole().getId(),
                                person.getJobRole().getTitle())
                    )
            );
        }

        return personDtoList;
    }
}
