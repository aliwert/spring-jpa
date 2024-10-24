package com.alimert.services;

import com.alimert.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {

    public List<DtoEmployee> findAllEmployee();
}
