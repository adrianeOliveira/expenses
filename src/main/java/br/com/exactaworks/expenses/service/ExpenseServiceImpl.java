package br.com.exactaworks.expenses.service;

import br.com.exactaworks.expenses.dao.ExpenseRepository;
import br.com.exactaworks.expenses.pojo.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ExpenseServiceImpl extends ServiceBase<Expense> {
    @Autowired
    private ExpenseRepository expenseDao;

    @Override
    public void merge(Expense expense) {
        expenseDao.save(expense);
    }

    public Expense getByid(Integer id) {
        return expenseDao.findExpenseById(id);
    }

    @Override
    public void delete(Expense expense) {
        expenseDao.delete(expense);
    }

    @Override
    public List<Expense> list() {
        return StreamSupport.stream(expenseDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
