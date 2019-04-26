<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Expense list</title>
</head>
<body>
    <table>
        <tr>
            <td>Name:</td>
            <td>Description:</td>
        </tr>
        <c:forEach items="${expenses}" var="expense" >
            <tr>
                <td>${expense.name}</td>
                <td>${expense.description}</td>
                <td><a href="/controller/expenses/form/${expense.idExpense}">Exibir</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
