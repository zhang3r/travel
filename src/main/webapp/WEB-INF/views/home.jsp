<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> ${add}</p>
<p>${dataJson}</p>
<form action="/travel/add" method="post">
<div>
<input type="submit"  name="add" value="addCity"/>
</div>
</form>

</body>
</html>
