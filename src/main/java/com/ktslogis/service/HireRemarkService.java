package com.ktslogis.service;

import com.ktslogis.dto.HireDto;
import com.ktslogis.dto.HireRemarkDto;
import com.ktslogis.entity.Hire;
import com.ktslogis.entity.HireRemark;
import com.ktslogis.repository.HireRemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HireRemarkService {

    @Autowired
    HireRemarkRepository repository;

    public int save(HireRemarkDto dto) throws Exception {
        Hire hire = new Hire();
        hire.setId(dto.getHire().getId());

        HireRemark remark = new HireRemark();
        remark.setRemark(dto.getRemark());
        remark.setHire(hire);

        HireRemark result = repository.save(remark);

        return result.getId();

    }

    public int update(HireRemarkDto dto) throws Exception {
        Optional<HireRemark> optional = repository.findById(dto.getId());
        HireRemark remark = optional.get();

        Hire hire = new Hire();
        hire.setId(dto.getHire().getId());

        remark.setRemark(dto.getRemark());
        remark.setHire(hire);

        HireRemark result = repository.save(remark);

        return result.getId();

    }

    public void delete(int id) throws Exception {
        Optional<HireRemark> optional = repository.findById(id);
        HireRemark remark = optional.get();

        repository.delete(remark);


    }

    public List<HireRemarkDto> getAllByHireId(int id) {
        List<Object> objectList = repository.findHireRemarksByHireId(id);

        for (Object object : objectList) {
            System.out.println(object);
        }
        return null;
    }
}
