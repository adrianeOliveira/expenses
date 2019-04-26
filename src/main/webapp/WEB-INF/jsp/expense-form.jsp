<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="application/json;">
    <title>Expense Form</title>
</head>
<body>
    <s:form method="POST" action="/controller/expenses" modelAttribute="expense">
        <table>
            <s:hidden path="idExpense" value="${idExpense}"/>
            <tr>
                <td><s:label path="name">Name:</s:label></td>
                <td><s:input path="name"/>${name}</td>
            </tr>
            <tr>
                <td><s:label path="description">Description:</s:label></td>
                <td><s:input path="description"/>${description}</td>
            </tr>
            <tr>
                <td><s:label path="dateTime">Date:</s:label></td>
                <td><s:input path="dateTime"/>${dateTime}</td>
            </tr>
            <tr>
                <td><s:label path="price">Price:</s:label></td>
                <td><s:input path="price"/>${price}</td>
            </tr>
            <tr>
                <td><s:label path="tags">Tags:</s:label></td>
                <td><s:input path="tags"/>${tags}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
