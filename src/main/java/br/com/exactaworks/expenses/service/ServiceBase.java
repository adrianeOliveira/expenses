package br.com.exactaworks.expenses.service;

import java.util.List;

public abstract class ServiceBase<T> {
    public abstract void merge(T obj);
    public abstract void delete(T obj);
    public abstract List<T> list();
}
