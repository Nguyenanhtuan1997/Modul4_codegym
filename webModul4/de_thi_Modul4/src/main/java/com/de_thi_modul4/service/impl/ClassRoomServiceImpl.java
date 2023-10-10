package com.de_thi_modul4.service.impl;

import com.de_thi_modul4.model.ClassRoom;
import com.de_thi_modul4.repository.IClassRoomRepo;
import com.de_thi_modul4.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {
    @Autowired
    private IClassRoomRepo iClassRoomRepo;


    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return iClassRoomRepo.save(classRoom);
    }

    @Override
    public ClassRoom edit(ClassRoom classRoom) {
        return iClassRoomRepo.save(classRoom);
    }

    @Override
    public void delete(int id) {
     iClassRoomRepo.deleteById(id);
    }

    @Override
    public ClassRoom findById(int id) {
        return iClassRoomRepo.findById(id).get();
    }

    @Override
    public List<ClassRoom> getAll() {
        return (List<ClassRoom>) iClassRoomRepo.findAll();
    }
}
