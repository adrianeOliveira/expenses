package br.com.exactaworks.expenses.rest;

import br.com.exactaworks.expenses.pojo.Expense;
import br.com.exactaworks.expenses.service.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseResource {

    @Autowired
    private ExpenseServiceImpl expenseService;

    @PutMapping(consumes = "application/json")
    public ResponseEntity<HttpStatus> saveExpense(@RequestBody @Valid Expense expense) {
        expenseService.merge(expense);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List> listAllExpenses() {
        return new ResponseEntity<>(expenseService.list(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    public ResponseEntity<Expense> listExpenses(@PathVariable("id") Integer id) {
        Expense expense = expenseService.getByid(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
}
