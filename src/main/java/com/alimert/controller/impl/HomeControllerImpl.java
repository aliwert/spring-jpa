package com.alimert.controller.impl;

import com.alimert.controller.IHomeController;
import com.alimert.dto.DtoHome;
import com.alimert.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/api/home")
public class HomeControllerImpl implements IHomeController {
    @Autowired
    private IHomeService homeService;

    @Override
    @GetMapping(path = "/{id}")
    public DtoHome findByHomeId(@PathVariable(name = "id") Long id) {
        return homeService.findHomeById(id);
    }
}
