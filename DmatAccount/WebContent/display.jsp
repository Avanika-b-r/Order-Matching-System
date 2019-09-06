<%@page import="com.pojos.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
p {
  border: 2px solid powderblue;
  margin: 50px;
}
p1 {
	font-family : ComicSansMS;
 	font-size : 18px;
	text-align:center;
}
h2 {
	font-family : ComicSansMS;
 	font-size : 18px;	

}
</style>

</head>
<body>

<h2> Welcome </h2>
<br> <br> <br>
<p> Balance </p>

<table border="2" width="70%">

<tr>

<br> <p1> My Orders </p1> <br>

<th>Order id</th>
<th>Category</th>
<th>Quantity</th>
<th>Type</th>
<th>Price</th>
<th>Fill</th>
<th>Date Time</th>
</tr>

<c:forEach items ="${getOrders}" var="ord"> 
<tr>
<td><c:out value="${ord.order_id }"></c:out> </td>
<td><c:out value="${ord.category }"></c:out> </td>
<td><c:out value="${ord.quantity }"></c:out> </td>
<td><c:out value="${ord.type }"></c:out> </td>
<td><c:out value="${ord.price }"></c:out> </td>
<td><c:out value="${ord.fill }"></c:out> </td>
<td><c:out value="${ord.timestamp }"></c:out> </td>
<td><a href="cancelOrder?id=${ord.order_id}">CANCEL</a></td>
</tr>
</c:forEach>
</table>
<br> <br> <br>

<table border="2" width="80%">
<tr>
<p1> My Transactions </p1>
<th>Transaction Id</th>
<th>ISIN</th>

<th>Quantity</th>
<th>Price</th>
<th>Date Time</th>
</tr>
<c:forEach  items ="${getTrans }" var="tr">
<br>
<tr>
<td><c:out value="${tr.transaction_id }"></c:out> </td>
<td><c:out value="${tr.ISIN }"></c:out> </td>
<td><c:out value="${tr.quantity }"></c:out> </td>
<td><c:out value="${tr.price }"></c:out> </td>
<td><c:out value="${tr.timestamp }"></c:out> </td>
</tr>
</c:forEach>
</table>


</body>
</html>