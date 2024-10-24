package com.alimert.services.impl;

import com.alimert.dto.DtoAddress;
import com.alimert.dto.DtoCustomer;
import com.alimert.entities.Address;
import com.alimert.entities.Customer;
import com.alimert.repository.CustomerRepository;
import com.alimert.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();
        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }

    @Override
    public List<DtoCustomer> findAllCustomers() {
        List<DtoCustomer> dtoCustomers = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(customer,dtoCustomer);
            dtoCustomers.add(dtoCustomer);
        }
        return dtoCustomers;
    }
}
