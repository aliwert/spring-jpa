package com.alimert.services.impl;

import com.alimert.dto.DtoDepartment;
import com.alimert.dto.DtoEmployee;
import com.alimert.entities.Employee;
import com.alimert.repository.EmployeeRepository;
import com.alimert.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<DtoEmployee> findAllEmployee() {
        List<DtoEmployee> dtoEmployees = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList != null && !employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee, dtoEmployee);

                dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getDepartmentName()));
                dtoEmployees.add(dtoEmployee);
            }

        }
        return dtoEmployees;
    }
}
