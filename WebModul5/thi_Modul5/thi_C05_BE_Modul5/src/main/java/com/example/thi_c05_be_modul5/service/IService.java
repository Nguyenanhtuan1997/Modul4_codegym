package com.de_thi_modul4.service;

import java.util.List;

public interface IService <E>{
    E save(E e);

    E edit(E e);

    void delete(int id);

    E findById(int id);

    List<E> getAll();
}
