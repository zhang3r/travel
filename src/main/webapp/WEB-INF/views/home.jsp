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
<title>Home</title>
<script type="text/javascript">
	var cityData = ${dataJson};
</script>
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
	<p>
	The List of cities:
	</p>
	<div class="cities"></div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/thirdparty/handlebars-v2.0.0.js"></script>
	<script src="resources/js/custom/home.js"></script>
	<script id="city-template" type="x-handlebars-template">
   {{#each this}}
    <div class="cities">
city name:{{name}}<br/>
city description:{{description}}<br/>
date:{{date}}<br/>
id:{{id}}<br/>
{{#each travel}}
travel type:{{travelType}}<br/>
company name:{{name}}<br/>
reservation number:{{reservationNumber}}<br/>
passenger name: {{passengerName}}<br/>
confirmation number:{{confirmationNumber}}<br/>
seat number:{{seatNumber}}<br/>
departure city:{{deapartureCity}}<br/>
arrival City:{{arrivalCity}}<br/>
departure time:{{departure}}<br/>
arrival time:{{arrival}}<br/>
cost:{{cost}}<br/>
id:{{id}}<br/>
<p>Travel</p>
{{/each}}
<form name="myform" action="/travel/add" method="post">
		<div>
			<h2>
				<input type='hidden' name='add' value='addTravel' /> <span
					class="label label-primary"><a
					href="javascript: submitform()">add Travel</a></span>
			</h2>
		</div>
	</form>

<p>Hotel</p>
		{{#each hotel}}
		{{hotelType}}
	{{name}}
{{confirmationNumber}}
	{{reservationNumber}}
	{{description}}
	{{address}}
	{{phoneNumber}}
	{{city}}
	{{country}}
	{{zipCode}}
	{{roomType}}
{{rating}}
{{nightNumber}}
{{arrival}}
{{departure}}
{{cost}}
{{id}}
		{{/each}}
<form name="myform" action="/travel/add" method="post">
		<div>
			<h2>
				<input type='hidden' name='add' value='addHotel' /> <span
					class="label label-primary"><a
					href="javascript: submitform()">add Hotel</a></span>
			</h2>
		</div>
	</form>
<p>Tours</p>
		{{#each tours}}
{{name}}
{{companyName}}
{{description}}
{{departure}}
{{arrival}}
{{departureLocation}}
{{arrivalLocation}}
{{isPickup}}
{{cost}}
{{id}}

		{{/each}}

<form name="myform" action="/travel/add" method="post">
		<div>
			<h2>
				<input type='hidden' name='add' value='addTours' /> <span
					class="label label-primary"><a
					href="javascript: submitform()">add Tours</a></span>
			</h2>
		</div>
	</form>
		<div class>
	</div>
<br/>
{{/each}}
</script>
</body>
</html>
