package com.ktslogis.service;

import com.ktslogis.dto.*;
import com.ktslogis.entity.*;
import com.ktslogis.repository.ContainerRepository;
import com.ktslogis.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HireService {

    @Autowired
    HireRepository hireRepository;

    @Autowired
    ContainerRepository containerRepository;

    @Transactional(readOnly = false)
    public int save(HireDto dto) throws Exception {

        //check if the container no is already available in the database. If available the same container no is used.
        // Else, the container no is saved before saving the hire record. If the container no cannot be saved an exception is
        //thrown and the transaction is aborted
        Container container = containerRepository.findByContainerNo(dto.getContainer().getContainerNo());
        if(null == container){
            container = new Container();
            container.setContainerNo(dto.getContainer().getContainerNo());
            //setting container size
            ContainerSize containerSize = new ContainerSize();
            containerSize.setId(dto.getContainer().getContainerSize().getId());

            Container c = containerRepository.save(container);

            if(null == c) {
                throw new Exception("Hire record could not be saved.");
            }

        }

        Person driver = new Person();
        driver.setId(dto.getDriver().getId());

        Person mate = new Person();
        mate.setId(dto.getMate().getId());

        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getVehicle().getId());

        List<HireRemarkDto> hireRemarkDtos = dto.getRemark();
        List<HireRemark> hireRemarkList = new ArrayList();
        if(null != hireRemarkDtos){
            for (HireRemarkDto hireRemarkDto: hireRemarkDtos) {

                HireRemark hireRemark = new HireRemark();
                hireRemark.setRemark(hireRemarkDto.getRemark());
                hireRemarkList.add(hireRemark);
            }
        }


        Hire hire = new Hire();
        hire.setContainer(container);
        hire.setDate(dto.getDate());
        hire.setDriver(driver);
        hire.setMate(mate);
        hire.setVehicle(vehicle);
        hire.setRemarks(hireRemarkList);

        Hire result = hireRepository.save(hire);

        return result.getId();
    }

    @Transactional(readOnly = false)
    public int update(HireDto dto) throws Exception {
        Optional<Hire> optional = hireRepository.findById(dto.getId());
        Hire hire = optional.get();

        /**
         *  check if the container no is already available in the database. If available the same container no is used.
         *  Else, the container no is saved before saving the hire record. If the container no cannot be saved an exception is
         *  thrown and the transaction is aborted
         */
        Container container = containerRepository.findByContainerNo(dto.getContainer().getContainerNo());
        if(null == container){
            container = new Container();
            container.setContainerNo(dto.getContainer().getContainerNo());
            //setting container size
            ContainerSize containerSize = new ContainerSize();
            containerSize.setId(dto.getContainer().getContainerSize().getId());

            Container c = containerRepository.save(container);

            if(null == c) {
                throw new Exception("Hire record could not be saved.");
            }

        }

        Person driver = hire.getDriver();
        driver.setId(dto.getDriver().getId());

        Person mate = hire.getMate();
        driver.setId(dto.getMate().getId());

        Vehicle vehicle = hire.getVehicle();
        vehicle.setId(dto.getVehicle().getId());

        hire.setContainer(container);
        hire.setDate(dto.getDate());
        hire.setDriver(driver);
        hire.setMate(mate);
        hire.setVehicle(vehicle);

        Hire result = hireRepository.save(hire);

        return result.getId();

    }

    @Transactional(readOnly = false)
    public void delete(int id) throws Exception {
        Optional<Hire> optional = hireRepository.findById(id);
        Hire hire = optional.get();

        hireRepository.delete(hire);
    }


    public HireDto get(int id) {
        Optional<Hire> optional = hireRepository.findById(id);
        Hire hire = optional.get();

        ContainerDto containerDto = new ContainerDto();
        containerDto.setContainerNo(hire.getContainer().getContainerNo());

        PersonDto driver = new PersonDto();
        driver.setId(hire.getDriver().getId());
        driver.setName(hire.getDriver().getName());

        PersonDto mate = new PersonDto();
        mate.setId(hire.getMate().getId());
        mate.setName(hire.getMate().getName());

        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleNo(hire.getVehicle().getVehicleNo());

        HireDto hireDto = new HireDto();
        hireDto.setContainer(containerDto);
        hireDto.setDate(hire.getDate());
        hireDto.setDriver(driver);
        hireDto.setMate(mate);
        hireDto.setVehicle(vehicleDto);

        return hireDto;
    }

    public List<HireDto> getAll() throws Exception {
        List<Hire> hireList = hireRepository.findAll();

        List<HireDto> hireDtoList = new ArrayList<>();

        for (Hire hire : hireList) {

            ContainerDto containerDto = new ContainerDto();
            containerDto.setContainerNo(hire.getContainer().getContainerNo());

            ContainerSizeDto containerSizeDto = new ContainerSizeDto();
            containerSizeDto.setId(hire.getContainer().getContainerSize().getId());
            containerSizeDto.setContainerSize(hire.getContainer().getContainerSize().getContainerSize());

            PersonDto driver = new PersonDto();
            driver.setId(hire.getDriver().getId());
            driver.setName(hire.getDriver().getName());

            PersonDto mate = new PersonDto();
            mate.setId(hire.getMate().getId());
            mate.setName(hire.getMate().getName());

            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setVehicleNo(hire.getVehicle().getVehicleNo());

            HireDto hireDto = new HireDto();
            hireDto.setContainer(containerDto);
            hireDto.setDate(hire.getDate());
            hireDto.setDriver(driver);
            hireDto.setMate(mate);
            hireDto.setVehicle(vehicleDto);

            hireDtoList.add(hireDto);
        }
        return hireDtoList;
    }
}
