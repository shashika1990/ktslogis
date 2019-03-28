package com.ktslogis.service;

import com.ktslogis.dto.JobRoleDto;
import com.ktslogis.entity.JobRole;
import com.ktslogis.repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobRoleService {

    @Autowired
    JobRoleRepository repository;

    public int save(JobRoleDto dto) throws Exception {

        JobRole jobRole = new JobRole();
        jobRole.setTitle(dto.getTitle());

        JobRole result = repository.save(jobRole);

        return result.getId();

    }

    public int update(JobRoleDto dto) throws Exception {

        Optional<JobRole> optional = repository.findById(dto.getId());

        JobRole jobRole = optional.get();
        jobRole.setTitle(dto.getTitle());

        JobRole result = repository.save(jobRole);

        return result.getId();
    }

    public void delete(int id) throws Exception {
        Optional<JobRole> optional = repository.findById(id);

        JobRole jobRole = optional.get();

        repository.delete(jobRole);


    }

    public List<JobRoleDto> getAll() {
        List<JobRole> jobRoleList = repository.findAll();

        //creating a PersonDtolist from the data retrived from database;
        List<JobRoleDto> jobRoleDtos = new ArrayList<>();

        for (JobRole jobRole : jobRoleList) {
            //adding a new PersonDto onject to the PersonDtolist
            jobRoleDtos.add(
                    new JobRoleDto(
                            jobRole.getId(),
                            jobRole.getTitle()
                    )
            );
        }

        return jobRoleDtos;
    }
}
