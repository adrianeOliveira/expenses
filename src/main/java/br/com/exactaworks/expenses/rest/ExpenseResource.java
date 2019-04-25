package br.com.exactaworks.expenses.rest;

import br.com.exactaworks.expenses.pojo.Expense;
import br.com.exactaworks.expenses.service.ExpenseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseResource {
    private final Logger log = LogManager.getLogger(ExpenseResource.class);

    @Autowired
    private ExpenseServiceImpl expenseService;

    @PutMapping(consumes = "application/json")
    public ResponseEntity<HttpStatus> saveExpense(@RequestBody @Valid Expense expense) {
        log.info("Received expense: {}", expense);
        expenseService.merge(expense);
        log.info("Expense saved!");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List> listAllExpenses() {
        log.info("Getting all the expenses");
        return new ResponseEntity<>(expenseService.list(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    public ResponseEntity<Expense> listExpenses(@PathVariable("id") Integer id) {
        log.info("Searching for expense from id: {}", id);
        Expense expense = expenseService.getByid(id);
        log.info("Expense found: {}", expense);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
}
