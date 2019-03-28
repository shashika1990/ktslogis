package com.ktslogis.repository;

import com.ktslogis.entity.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HireRepository  extends JpaRepository<Hire, Integer> {



}
