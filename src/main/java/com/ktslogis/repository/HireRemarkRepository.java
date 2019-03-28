package com.ktslogis.repository;

import com.ktslogis.entity.HireRemark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HireRemarkRepository extends JpaRepository<HireRemark, Integer> {


    @Query(
            value = "SELECT * hire_remark.id, hire_remark.remark FROM hire_remark " +
                    "INNER JOIN hire on hire_remark.hire_id = hire.id " +
                    "WHERE hire.id = :id",
            nativeQuery = true)
    List<Object> findHireRemarksByHireId(@Param("id") int id);

}
