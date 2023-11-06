package com.de_thi_modul4.service.impl;


import com.de_thi_modul4.model.Tuors;
import com.de_thi_modul4.repository.IToursRepo;
import com.de_thi_modul4.service.ITuorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuorsServiceImpl implements ITuorsService {
    @Autowired
    IToursRepo iToursRepo;


    @Override
    public Tuors save(Tuors student) {
        return iToursRepo.save(student);
    }

    @Override
    public Tuors edit(Tuors student) {
        return iToursRepo.save(student);
    }

    @Override
    public void delete(int id) {
    iToursRepo.deleteById(id);
    }

    @Override
    public Tuors findById(int id) {
        return iToursRepo.findById(id).get();
    }

    @Override
    public List<Tuors> getAll() {
        return (List<Tuors>) iToursRepo.findAll();
    }

    public List<Tuors> findAllByUsernameHQL(String username) {
        return iToursRepo.findAllByNameContaining(username);
    }
}
