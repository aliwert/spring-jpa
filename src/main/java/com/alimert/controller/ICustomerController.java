package com.alimert.controller;

import com.alimert.dto.DtoCustomer;

import java.util.List;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
    public List<DtoCustomer> findAllCustomers();
}
