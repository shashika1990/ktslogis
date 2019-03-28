package com.ktslogis.service;

import com.ktslogis.dto.ContainerDto;
import com.ktslogis.entity.Container;
import com.ktslogis.entity.ContainerSize;
import com.ktslogis.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ContainerService {

    @Autowired
    ContainerRepository repository;

    public int save(ContainerDto dto) throws Exception{

        Container container = new Container();
        container.setContainerNo(dto.getContainerNo());

        ContainerSize containerSize = new ContainerSize();
        containerSize.setId(dto.getContainerSize().getId());

        container.setContainerSize(containerSize);

        Container result = repository.save(container);
        return result.getId();
    }

    public void delete(int id) throws Exception {
        Optional<Container> optional = repository.findById(id);
        repository.delete(optional.get());
    }

    public int update(ContainerDto dto, int containerSizeId) throws Exception{

        Optional<Container> optional = repository.findById(dto.getId());
        Container container = optional.get();

        container.setContainerNo(dto.getContainerNo());

        ContainerSize containerSize = container.getContainerSize();
        containerSize.setId(containerSizeId);

        container.setContainerSize(containerSize);

        Container result = repository.save(container);

        return result.getId();
    }

    public ContainerDto get(int id) throws Exception {
        Optional<Container> optional = repository.findById(id);
        Container container = optional.get();

        ContainerDto dto = new ContainerDto();
        dto.setId(container.getId());
        dto.setContainerNo(container.getContainerNo());

        //Todo = set container size object
        dto.setContainerSize(null);

        return dto;
    }
}
