package com.example.dao;

import com.example.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDAO {
    List<Emp> findAll();
}
