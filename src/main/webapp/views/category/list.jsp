<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2023
  Time: 9:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS -->
    <link rel="stylesheet" href="views/category/style.css">

    <title>Expense Tracker using JavaScript - @code.scientist x @coding torque</title>
</head>

<body>
<!-- Further code here -->
<header>
    <h2>Expense Tracker</h2>
</header>

<div class="container">
    <h4>Your Balance</h4>
    <h1 id="balance">$0.00</h1>

    <div class="inc-exp-container">
        <div>
            <h4>Income</h4>
            <p id="money-plus" class="money plus">+$0.00</p>
        </div>
        <div>
            <h4>Expense</h4>
            <p id="money-minus" class="money minus">-$0.00</p>
        </div>
    </div>

    <h3>History</h3>
    <ul id="list" class="list">
        <!-- List of income and expense  -->
    </ul>

    <h3>Add new transaction</h3>
    <form id="form">
        <div class="form-control">
            <label for="text">Name</label>
            <input type="text" id="text" placeholder="Enter name of transaction..." />
        </div>
        <div class="form-control">
            <label for="amount">Amount <br />
            </label>
            <input type="number" id="amount" placeholder="Enter amount..." />
        </div>
        <button class="btn">Add transaction</button>
    </form>
</div>
</body>
</html>
