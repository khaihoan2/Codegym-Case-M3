package com.codegym.dao;

import java.util.List;

public interface IGeneralDAO<T> {
    List<T> getAll();

    boolean save(T t);

    boolean update(int id, T t);

    boolean remove(int id);

    T findById(int id);
}
