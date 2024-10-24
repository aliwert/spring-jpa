package com.alimert.services;

import com.alimert.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
