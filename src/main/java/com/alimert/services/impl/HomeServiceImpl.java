package com.alimert.services.impl;

import com.alimert.dto.DtoHome;
import com.alimert.dto.DtoRoom;
import com.alimert.entities.Home;
import com.alimert.entities.Room;
import com.alimert.repository.HomeRepository;
import com.alimert.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();
        List<Room> dbRooms = optional.get().getRoom();
        BeanUtils.copyProperties(dbHome, dtoHome);
        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room dbRoom : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(dbRoom, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;
    }
}
