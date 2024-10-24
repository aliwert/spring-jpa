package com.alimert.controller;

import com.alimert.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {
    public List<DtoEmployee> findAllEmployee();
}
