package com.ktslogis.service;

import com.ktslogis.dto.ContainerDto;
import com.ktslogis.dto.ContainerSizeDto;
import com.ktslogis.entity.ContainerSize;
import com.ktslogis.repository.ContainerSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContainerSizeService {

    @Autowired
    ContainerSizeRepository repository;

    public int save(ContainerSizeDto dto) throws Exception{
        ContainerSize containerSize = new ContainerSize();
        containerSize.setContainerSize(dto.getContainerSize());

        ContainerSize result = repository.save(containerSize);

        System.out.println(result); //test

        //returning the generated id
        return result.getId();
    }

    public void delete(int id) throws Exception{
        Optional<ContainerSize> optional = repository.findById(id);
        ContainerSize containerSize = optional.get();

        repository.delete(containerSize);
    }

    public int update(ContainerSizeDto dto) throws Exception{
        Optional<ContainerSize> optional = repository.findById(dto.getId());

        ContainerSize containerSize = optional.get();

        containerSize.setContainerSize(dto.getContainerSize());

        //returning the id of updated entity
        return repository.save(containerSize).getId();
    }

    public ContainerSizeDto getContainerSize(int id) throws Exception {
        Optional<ContainerSize> optional = repository.findById(id);

        ContainerSize containerSize = optional.get();

        ContainerSizeDto dto = new ContainerSizeDto(
                containerSize.getId(),
                containerSize.getContainerSize()
        );

        return  dto;
    }

    public List<ContainerSizeDto> getAll() throws Exception {
        List<ContainerSizeDto> dtos = dtos = new ArrayList<>();
        List<ContainerSize> containerSizes = repository.findAll();

        if(!containerSizes.isEmpty()) { for (ContainerSize e : containerSizes) {
                dtos.add(
                        new ContainerSizeDto(
                                e.getId(),
                                e.getContainerSize()
                        )
                );
            }
        }

        return dtos;
    }

}
