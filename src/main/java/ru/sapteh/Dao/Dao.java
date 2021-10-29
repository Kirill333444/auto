package ru.sapteh.Dao;

import ru.sapteh.model.model;

import java.util.List;

public interface Dao<M, I extends Number> {
    model findById(Integer id);

    List<model> findAll();

    void save(model model);

    void update(model model);

    void deleteById(Integer id);
}
