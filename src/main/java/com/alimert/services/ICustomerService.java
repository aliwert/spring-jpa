package com.alimert.services;

import com.alimert.dto.DtoCustomer;

import java.util.List;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
    public List<DtoCustomer> findAllCustomers();
}
