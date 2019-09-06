<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	window.onload = function () {
		document.getElementById("price").style.display="none";
		document.getElementById("fill").style.display="none";
	}
	
	function showLimit() {
		document.getElementById("price").style.display="block";
		document.getElementById("fill").style.display="block";
	}
	
	function hideLimit() {
		document.getElementById("price").style.display="none";
		document.getElementById("fill").style.display="none";
	}
</script>
<meta charset="ISO-8859-1">
<title>Place order</title>

<style>
h1 {
background-color : Plum;
  font-family: ComicSansMS;
  text-align:center;
  
}
 p1 {

 margin : 50px;
 colour : PowderBlue;  
 font-family : ComicSansMS;
 font-size : 18px;
 } 
</style>
</head>
<body>
<h1 style="font-size:25px;">Order Details</h1>
<p1>
<form action="addOrder" method="get">

 <br>
  Buy/Sell : <br>
  <br>
  
  <select name="Buy/Sell" required>
  <option value="Buy">Buy</option>
  <option value="Sell">Sell</option>
  </select>
  <br>
  <br>
  Quantity : <br>
  <input type="text" name="Quantity" min="1" max="1000" required><br>
  <br>
  Type of Order : <br>
  <input type="radio" onclick="javascript:hideLimit();" name="type" value="Market" checked required> Market<br>
  <input type="radio" onclick="javascript:showLimit();" name="type" value="Limit" required> Limit<br>
  <br>
  
  <div id="price">
  	Price : <br> 
  <input type="text" name="Price" required><br>
  <br>
  </div>
  
  <div id="fill">
  	Fill : <br>
  	<input type="radio" name="fill" value="all_none" checked required> All or None <br>
  	<input type="radio" name="fill" value="partial" required> Partial <br>
  </div>
   
  <br>
  <input type="submit" value="Submit">
   

</form>
</p1>

</body>
</html>