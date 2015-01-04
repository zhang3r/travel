<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="resources/css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="resources/css/custom/home.css" rel="stylesheet">
<script src="resources/js/thirdparty/handlebars-v2.0.0.js"></script>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>${add}</p>
	<p>${dataJson}</p>
	<form name="myform" action="/travel/add" method="post">
		<div>
			<h2>
				<input type='hidden' name='add' value='addCity' /> <span
					class="label label-primary"><a
					href="javascript: submitform()">add city</a></span>
			</h2>
		</div>
	</form>
	The List of Shoes:
	<ul class="shoesNav"></ul>
	<script id="shoe-template" type="x-handlebars-template">
   {{#each this}}
    <li class="shoes"><a href="/{{name}}">{{name}} -- Price: {{price}} </a></li>
{{/each}}
</script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>

	<script src="resources/js/custom/home.js"></script>
</body>
</html>
