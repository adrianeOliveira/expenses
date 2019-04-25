package br.com.exactaworks.expenses.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "Expense.findExpenseById",
                query = "from Expense ex where ex.idExpense = :id")
})
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue
    @Column(name = "id_expense", nullable = false)
    private Integer idExpense;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "tags")
    private String tags;

    public Integer getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Integer idExpense) {
        this.idExpense = idExpense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return idExpense.equals(expense.idExpense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExpense);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( id: ").append(idExpense);
        sb.append(", name: ").append(name);
        sb.append(", description: ").append(description);
        sb.append(", dateTime: ").append(dateTime);
        sb.append(", price: ").append(price);
        sb.append(", tags: ").append(tags);
        sb.append(")");
        return sb.toString();
    }
}
