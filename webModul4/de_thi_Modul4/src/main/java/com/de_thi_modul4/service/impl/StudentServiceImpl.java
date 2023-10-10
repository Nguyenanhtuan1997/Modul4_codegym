package com.de_thi_modul4.service.impl;


import com.de_thi_modul4.model.Student;
import com.de_thi_modul4.repository.IStudentRepo;
import com.de_thi_modul4.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IRoomService {
    @Autowired
    IStudentRepo iStudentRepo;


    @Override
    public Student save(Student student) {
        return iStudentRepo.save(student);
    }

    @Override
    public Student edit(Student student) {
        return iStudentRepo.save(student);
    }

    @Override
    public void delete(int id) {
    iStudentRepo.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) iStudentRepo.findAll();
    }

    public List<Student> findAllByUsernameHQL(String username) {
        return iStudentRepo.findAllByNameContaining(username);
    }
}
