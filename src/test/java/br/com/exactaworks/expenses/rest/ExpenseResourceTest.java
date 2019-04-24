package br.com.exactaworks.expenses.rest;

import br.com.exactaworks.expenses.pojo.Expense;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
public class ExpenseResourceTest {

    @Test
    public void insertNewExpenseWithoutError() {
        given().contentType("application/json").body(mockExpenseCorrect())
                .when().post("/expense").then().statusCode(HttpStatus.OK.value());
    }

    private Expense mockExpenseCorrect() {
        Expense expenseMock = new Expense();
        expenseMock.setDateTime(LocalDateTime.now().plusDays(5));
        expenseMock.setDescription("description mock");
        expenseMock.setName("Name mock");
        expenseMock.setPrice(new BigDecimal(20.34));
        expenseMock.setTags("screwdriver");
        return expenseMock;
    }
}
