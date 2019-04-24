package br.com.exactaworks.expenses.service;

import java.util.List;

public abstract class ServiceBase<T> {
    abstract void merge(T obj);
//    abstract T getByid(Integer id);
    abstract void delete(T obj);
    abstract List<T> list();
}
