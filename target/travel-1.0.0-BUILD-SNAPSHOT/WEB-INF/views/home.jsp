<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/custom/home.css" rel="stylesheet">
<script type="text/javascript">
	var cityData = ${jsonData};
</script>
<script src="${pageContext.request.contextPath}/resources/js/custom/json.js"></script>
<title>Home</title>
</head>
<body>
	<h1>Itinerary Planner</h1>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#cityModal" data-whatever="City">Add City</button>
	<!-- MODALS -->
	<!--  CITY -->
	<div class="modal fade" id="cityModal" tabindex="-1" role="dialog"
		aria-labelledby="cityModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="mainModalLabel">New City</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="cityForm" method="post" action="addCity"
						name="cityForm" id="cityform">
						<form:input path="id" type="hidden" class="form-control cityId"
							id="travel-city-id" name="id" />
						<label for="city-name" class="control-label">*City Name:</label>
						<form:input type="text" class="form-control" id="city-name"
							name="name" path="name" />
						<label for="city-date" class="control-label">Date:</label>
						<form:input type="text" class="form-control datepicker"
							id="city-date" name="date" path="date" />
						<label for="message-text" class="control-label">Description:</label>
						<form:textarea class="form-control" id="message-text"
							name="description" path="description"></form:textarea>

						<div class="modal-footer">
							<form:button path="" type="button" class="btn btn-default"
								data-dismiss="modal">Close</form:button>
							<form:button type="submit" class="btn btn-primary">Save</form:button>


						</div>
					</form:form>

				</div>

			</div>
		</div>
	</div>

	<!--  Travel -->
	<div class="modal fade" id="travelModal" tabindex="-1" role="dialog"
		aria-labelledby="TravelModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="mainModalLabel">New City</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="travelForm" method="post"
						action="addTravel" name="travelFrom" id="travelform">
						<form:input path="cityId" type="hidden"
							class="form-control cityId" id="travel-city-id" name="cityId" />
						<label for="travel-name" class="control-label">*Travel
							Name:</label>
						<form:input type="text" path="name" class="form-control"
							id="travel-name" name="name" />
						<label for="travel-departure-date" class="control-label">Departure
							Date:</label>
						<form:input path="departure" type="text"
							class="form-control datepicker" id="travel-departure-date"
							name="departure" />
						<label for="travel-arrival-date" class="control-label">Arrival
							Date:</label>
						<form:input path="arrival" type="text"
							class="form-control datepicker" id="travel-arrival-date"
							name="arrival" />
						<label for="travel-name" class="control-label">Departure
							City:</label>
						<form:input path="departureCity" type="text" class="form-control"
							id="travel-departureCity-name" name="departureCity" />
						<label for="travel-name" class="control-label">Arrival
							City:</label>
						<form:input path="arrivalCity" type="text" class="form-control"
							id="travel-arrvialCity-name" name="arrivalCity" />
						<label for="travel-name" class="control-label">Seat
							Number:</label>
						<form:input path="seatNumber" type="text" class="form-control"
							id="travel-seat" name="seatNumber" />
						<label for="travel-name" class="control-label">Confirmation
							Number:</label>
						<form:input path="confirmationNumber" type="text"
							class="form-control" id="travel-confirmation-number"
							name="confirmationNumber" />
						<label for="travel-name" class="control-label">Reservation
							Number:</label>
						<form:input path="reservationNumber" type="text"
							class="form-control" id="travel-reservation-number"
							name="reservationNumber" />

						<label for="travel-name" class="control-label">Passenger
							Name:</label>
						<form:input path="passengerName" type="text" class="form-control"
							id="travel-name" name="passengerName" />
						<label for="travel-name" class="control-label">Cost:</label>
						<form:input path="cost" type="number" class="form-control"
							id="travel-price" name="cost" />
						<label for="travel-name" class="control-label">Travel
							Type:</label>
						<form:select path="travelType"
							class="form-control btn dropdown-toggle selectpicker btn-default"
							name="travelType">

							<option>PLANE</option>
							<option>RAIL</option>
							<option>BUS</option>
							<option>FERRY</option>
							<option>CAR</option>
							<option>CRUISE</option>
							<option>OTHER</option>
						</form:select>


						<div class="modal-footer">
							<form:button type="button" class="btn btn-default"
								data-dismiss="modal">Close</form:button>
							<form:button type="submit" class="btn btn-primary">Save</form:button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	<!--  Hotel -->
	<div class="modal fade" id="hotelModal" tabindex="-1" role="dialog"
		aria-labelledby="hotelModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="hotelModalLabel">New Hotel</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="hotelForm" method="post"
						action="addHotel" name="hotelForm" id="hotelForm">
						<form:input path="cityId" type="hidden"
							class="form-control cityId" id="hotel-city-id" name="cityId" />
						<label for="hotel-name" class="control-label">*Hotel Name:</label>
						<form:input path="name" type="text" class="form-control"
							id="hotel-name" name="name" />
						<label for="hotel-departure-date" class="control-label">Departure
							Date:</label>
						<form:input path="departure" type="text"
							class="form-control datepicker" id="hotel-departure-date"
							name="departure" />
						<label for="hotel-arrival-date" class="control-label">Arrival
							Date:</label>
						<form:input path="arrival" type="text"
							class="form-control datepicker" id="hotel-arrival-date"
							name="arrival" />
						<label for="hotel-name" class="control-label">Address:</label>
						<form:input path="address" type="text" class="form-control"
							id="hotel-name" name="address" />
						<label for="hotel-name" class="control-label">City:</label>
						<form:input path="city" type="text" class="form-control"
							id="hotel-name" name="city" />
						<label for="hotel-name" class="control-label">Country:</label>
						<form:input path="country" type="text" class="form-control"
							id="hotel-country" name="country" />
						<label for="hotel-name" class="control-label">ZipCode:</label>
						<form:input path="zipCode" type="text" class="form-control"
							id="hotel-zipCode" name="zipCode" />
						<label for="hotel-name" class="control-label">Phone
							Number:</label>
						<form:input path="phoneNumber" type="text" class="form-control"
							id="hotel-name" name="phoneNumber" />
						<label for="hotel-name" class="control-label">Hotel
							rating:</label>
						<form:input path="rating" type="text" class="form-control"
							id="hotel-name" name="rating" />
						<label for="hotel-name" class="control-label">Number of
							Nights:</label>
						<form:input path="nightNumber" type="text" class="form-control"
							id="hotel-name" name="nightNumber" />
						<label for="hotel-name" class="control-label">Confirmation
							Number:</label>
						<form:input path="confirmationNumber" type="text"
							class="form-control" id="travel-confirmation-number"
							name="confirmationNumber" />
						<label for="hotel-name" class="control-label">Reservation
							Number:</label>
						<form:input path="reservationNumber" type="text"
							class="form-control" id="travel-reservation-number"
							name="reservationNumber" />
						<label for="hotel-type" class="control-label">Hotel Type:</label>
						<form:select path="hotelType"
							class="form-control btn dropdown-toggle selectpicker btn-default"
							name="hotelType">

							<option>AIRBNB</option>
							<option>HOTEL</option>
							<option>HOSTEL</option>
							<option>OTHER</option>
						</form:select>
						<label for="hotel-type" class="control-label">Room Type:</label>
						<form:select path="roomType"
							class="form-control btn dropdown-toggle selectpicker btn-default"
							name="roomType">
							<option>DORMITORY</option>
							<option>SINGLE</option>
							<option>TWIN</option>
							<option>FERRY</option>
							<option>DOUBLE</option>
							<option>DOUBLE_DOUBLE</option>
							<option>TRIPLE</option>
							<option>QUEEN</option>
							<option>KING</option>
							<option>OTHER</option>
						</form:select>
						<label for="message-text" class="control-label">Notes:</label>
						<form:textarea path="description" class="form-control"
							id="message-text" name="description"></form:textarea>
						<div class="modal-footer">
							<form:button type="button" class="btn btn-default"
								data-dismiss="modal">Close</form:button>
							<form:button type="submit" class="btn btn-primary">Save</form:button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>

	<!--  Tours -->
	<div class="modal fade" id="toursModal" tabindex="-1" role="dialog"
		aria-labelledby="toursModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="toursModalLabel">New City</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="toursForm" method="post"
						action="addTours" name="toursForm" id="toursForm">
						<form:input path="cityId" type="hidden"
							class="form-control cityId" id="tours-city-id" name="cityId" />
						<label for="tours-name" class="control-label">*Tour Name:</label>
						<form:input path="name" type="text" class="form-control"
							id="tours-name" name="name" />
						<label for="tours-departure-date" class="control-label">Departure
							Date:</label>
						<form:input path="departure" type="text"
							class="form-control datepicker" id="tours-departure-date"
							name="departure" />
						<label for="tours-arrival-date" class="control-label">Arrival
							Date:</label>
						<form:input path="arrival" type="text"
							class="form-control datepicker" id="tours-arrival-date"
							name="arrival" />
						<label for="tours-name" class="control-label">Tour Company
							Name:</label>
						<form:input path="companyName" type="text" class="form-control"
							id="tours-name" name="companyName" />
						<label for="tours-name" class="control-label">Pickup
							Location:</label>
						<form:input path="departureLocation" type="text"
							class="form-control" id="tours-name" name="departureLocation" />
						<label for="tours-name" class="control-label">Dropoff
							Location:</label>
						<form:input path="arrivalLocation" type="text"
							class="form-control" id="tours-name" name="arrivalLocation" />
						<label for="tours-name" class="control-label">Cost:</label>
						<form:input path="cost" type="text" class="form-control"
							id="tours-name" name="cost" />
						<label for="message-text" class="control-label">Description:</label>
						<form:textarea path="description" class="form-control"
							id="message-text" name="description"></form:textarea>

						<div class="modal-footer">
							<form:button type="button" class="btn btn-default"
								data-dismiss="modal">Close</form:button>
							<form:button type="submit" class="btn btn-primary">Save</form:button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>


	<p>${dataJson}</p>
	<p>The List of cities:</p>
	<div class="cities"></div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/thirdparty/handlebars-v2.0.0.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/custom/home.js"></script>
	<script id="city-template" type="x-handlebars-template">
   {{#each this}}
    <div class="cities">
city name:{{name}}<br/>
city description:{{description}}<br/>
date:{{date}}<br/>
id:{{id}}<br/>
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#cityModal" data-whatever={{id}}>Edit City</button>


<button type="Submit"  id="deleteCity" class="btn btn-primary" onClick = "deleteCity('{{id}}')">Delete</button>

<p>Travel</p>
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
<button type="Submit"  id="deleteTravel" class="btn btn-primary" onClick = "deleteTravel('{{id}}')">Delete</button>
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#travelModal" data-whatever={{id}}>Edit Travel</button>



{{/each}}
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#travelModal" data-whatever={{id}}>Add Travel</button>

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
<button type="Submit"  id="deleteHotel" class="btn btn-primary" onClick = "deleteHotel('{{id}}')">Delete</button>
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#hotelModal" data-whatever={{id}}>Edit hotel</button>



		{{/each}}
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#hotelModal" data-whatever={{id}}>Add Hotel</button>
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
<button type="Submit"  id="deleteTours" class="btn btn-primary" onClick = "deleteTour('{{id}}')">Delete</button>
<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#toursModal" data-whatever={{id}}>Edit hotel</button>
		{{/each}}

<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#toursModal" data-whatever="{{id}}">Add Tour</button>
		<div class>
	</div>
<br/>
{{/each}}
</script>
</body>
</html>
