<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2018-03-01
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <input type="button" value="Add Customer" class="addBtn" onclick="window.location.href='addForm'; return false;" />
        <br>
        <!--Search functionality-->
        <form:form action="search" method="post">
            <p id="search"><label>Search for customer:</label><input type="text" name="searchName"><input type="submit" value="Search" class="addBtn"></p>

        </form:form>

        <div id="content">

            <!--add customer button -->


            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempCustomer" items="${customers}">
                    <!--creates update link with customer id-->
                    <c:url var="updateLink" value="/customer/updateForm">

                        <c:param name="customerId" value="${tempCustomer.id}"/>

                    </c:url>
                    <!--Create delete link-->
                    <c:url var="deleteLink" value="/customer/delete">

                        <c:param name="customerId" value="${tempCustomer.id}"/>

                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this?')))return false ">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

</body>
</html>
