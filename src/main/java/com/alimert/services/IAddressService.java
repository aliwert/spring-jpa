package com.alimert.services;

import com.alimert.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress findAddressById(Long id);
}
