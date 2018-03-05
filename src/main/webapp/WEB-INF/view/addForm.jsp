<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2018-03-04
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addCustStyle.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add Customer</h3>
        <form:form action = "addCustomer" modelAttribute="customer" method="post">

            <form:hidden path="id" />

            <div id="content">
                <div id="right">
                    <p class="inputRow"><label>First Name:</label><form:input path="firstName" /></p>
                    <p class="inputRow"><label>Last Name:</label><form:input path="lastName" /></p>
                    <p class="inputRow"><label>E-mail:</label><form:input path="email"/></p>
                </div>
            </div>

            <input type="submit" value="Add/Update" class="addBtn">
            <br><br>
            <a href="${pageContext.request.contextPath}/customer/list">Back to Customers List</a>
        </form:form>
    </div>

</body>
</html>
