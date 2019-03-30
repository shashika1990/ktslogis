package com.ktslogis.repository;


import com.ktslogis.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, Integer> {

    Container findByContainerNo(String containerNo);
}
