package com.de_thi_modul4.repository;

import com.de_thi_modul4.model.Tuors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IToursRepo extends CrudRepository<Tuors, Integer> {
    List<Tuors> findAllByNameContaining(String name);

}
