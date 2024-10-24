package com.alimert.controller.impl;

import com.alimert.controller.ICustomerController;
import com.alimert.dto.DtoCustomer;
import com.alimert.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;


    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoCustomer> findAllCustomers() {
        return customerService.findAllCustomers();
    }
}
