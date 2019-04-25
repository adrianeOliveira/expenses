package br.com.exactaworks.expenses.rest;

import br.com.exactaworks.expenses.pojo.Expense;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class ExpenseResourceTest {

    @LocalServerPort
    int port = 8080;

    @Test
    public void insertNewExpenseWithoutError() {
        given().contentType("application/json").body(mockExpenseCorrect())
                .when().put("/expenses").then().statusCode(HttpStatus.ACCEPTED.value());
    }

    @Test
    public void getListAllExpensesWithoutError() {
        given().contentType("application/json").when().get("/expenses").then().statusCode(HttpStatus.OK.value()).log();
    }

    @Test
    public void getExpenseByIdWithoutError() {
        given().contentType("application/json").when().get("/expenses/2").then().statusCode(HttpStatus.OK.value()).log();
    }

    private Expense mockExpenseCorrect() {
        Expense expenseMock = new Expense();
        expenseMock.setDateTime(LocalDateTime.now().plusDays(5));
        expenseMock.setDescription("description mock");
        expenseMock.setName("Name mock");
        expenseMock.setPrice(new BigDecimal(20.34).setScale(2, RoundingMode.HALF_UP));
        expenseMock.setTags("screwdriver");
        return expenseMock;
    }
}
