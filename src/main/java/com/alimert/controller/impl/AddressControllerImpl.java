package com.alimert.controller.impl;

import com.alimert.controller.IAddressController;
import com.alimert.dto.DtoAddress;
import com.alimert.repository.AddressRepository;
import com.alimert.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/rest/api/address")
public class AddressControllerImpl implements IAddressController {
    @Autowired
    private IAddressService addressRepository;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
        return addressRepository.findAddressById(id);
    }
}
