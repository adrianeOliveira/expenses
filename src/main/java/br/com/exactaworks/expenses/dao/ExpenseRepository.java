package br.com.exactaworks.expenses.dao;

import br.com.exactaworks.expenses.pojo.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository  extends CrudRepository<Expense, Long> {
}
