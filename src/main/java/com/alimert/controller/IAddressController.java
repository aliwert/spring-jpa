package com.alimert.controller;

import com.alimert.dto.DtoAddress;

public interface IAddressController {
    public DtoAddress findAddressById(Long id);
}
