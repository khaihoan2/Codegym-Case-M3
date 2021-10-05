package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    public List<T> getAll();

    boolean save(T t);

    boolean update(String username, T t);

    boolean delete(String username);

    public List<T> findByName(String username);
}
