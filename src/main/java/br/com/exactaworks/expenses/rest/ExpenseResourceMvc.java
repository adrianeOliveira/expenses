package br.com.exactaworks.expenses.rest;

import br.com.exactaworks.expenses.pojo.Expense;
import br.com.exactaworks.expenses.service.ExpenseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/controller/expenses")
public class ExpenseResourceMvc {
    private final Logger log = LogManager.getLogger(ExpenseResourceMvc.class);

    @Autowired
    private ExpenseServiceImpl expenseService;

    @PostMapping
    public ModelAndView saveExpense(@RequestBody @ModelAttribute("expense") Expense expense) {
        log.info("Received expense: {}", expense);
        expenseService.merge(expense);
        log.info("Expense saved!");
        return listAllExpenses();
    }

    @GetMapping(produces = "application/json", value = "/list")
    public ModelAndView listAllExpenses() {
        log.info("Getting all the expenses");
        ModelAndView modelAndView = new ModelAndView("expense-list");
        modelAndView.addObject("expenses", expenseService.list());
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }

    @GetMapping(produces = "application/json", value = "/form/{id}")
    public ModelAndView listExpenses(@PathVariable("id") Integer id) {
        log.info("Searching for expense from id: {}", id);
        Expense expense = expenseService.getByid(id);
        if (expense == null) {
            log.info("Expense not found");
            ModelAndView model = new ModelAndView("expense-list");
            model.setStatus(HttpStatus.NOT_FOUND);
            return model;
        }
        log.info("Expense found: {}", expense);
        ModelAndView modelAndView = new ModelAndView("expense-form");
        modelAndView.addObject("expense", expense);
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }

    @GetMapping(value = "/form")
    public ModelAndView showForm() {
        return new ModelAndView("expense-form", "expense", new Expense());
    }
}
