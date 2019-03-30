package com.ktslogis.service;

import com.ktslogis.dto.ContainerDto;
import com.ktslogis.entity.Container;
import com.ktslogis.entity.ContainerSize;
import com.ktslogis.repository.ContainerRepository;
import com.ktslogis.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ContainerService {

    @Autowired
    ContainerRepository repository;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int save(ContainerDto dto) throws Exception{

        Container container = new Container();
        container.setContainerNo(Validate.validateContainerNo(dto.getContainerNo()));

        ContainerSize containerSize = new ContainerSize();
        containerSize.setId(dto.getContainerSize().getId());

        container.setContainerSize(containerSize);

        Container result = repository.save(container);
        return result.getId();
    }

    @Transactional(readOnly = false)
    public void delete(int id) throws Exception {
        Optional<Container> optional = repository.findById(id);
        repository.delete(optional.get());
    }

    @Transactional(readOnly = false)
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
