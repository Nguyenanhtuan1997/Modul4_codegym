package service;

import java.util.List;

public interface IStaffService<E> {
    void add(E e);

    void delete(int id);

    List<E> findAll();

    void edit(int id, E e);
}
