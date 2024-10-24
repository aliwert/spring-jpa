package com.alimert.controller;

import com.alimert.dto.DtoHome;

public interface IHomeController {
    public DtoHome findByHomeId(Long id);
}
