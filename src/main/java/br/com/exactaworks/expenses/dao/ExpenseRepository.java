package br.com.exactaworks.expenses.dao;

import br.com.exactaworks.expenses.pojo.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository  extends CrudRepository<Expense, Long> {
    Expense findExpenseById(@Param("id")Integer id);
}
