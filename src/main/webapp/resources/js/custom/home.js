
$(function() {
	// Get the HTML from the template in the script tag​
	
	var minDateObj= new Date();
	var pickerOpts = {minDate: new Date()
			};  
	handlebarsTemplate();
	$('.datepicker').datepicker(pickerOpts);
	$('.selectpicker').selectpicker();


});

$('.modal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget); // Button that triggered the modal
	var recipient = button.data('whatever'); // Extract info from data-*
											// attributes
	// If necessary, you could initiate an AJAX request here (and then do the
	// updating in a callback).
	// Update the modal's content. We'll use jQuery here, but you could use a
	// data binding library or other methods instead.
	var modal = $(this)
	modal.find('.cityId').val(recipient);

});
function addCityForm() {

	var formData =($("#cityform")).serialize();
	
	$.ajax({
		type : "POST",
		url : "/travel/addCity",
		data :  formData,
		success : function(data) {cityData=data;
		handlebarsTemplate();
		},
		dataType : "json",
		contentType : "application/json"
			
	});
	 $('#cityModal').modal('hide');
}
function addTravelForm() {

	var formData = JSON.stringify(ConvertFormToJSON($("#travelform")));
	
	$.ajax({
		type : "POST",
		url : "/travel/addTravel",
		data :  formData,
		success : function(data) {cityData=data;
		handlebarsTemplate();
		},
		dataType : "json",
		contentType : "application/json"
			
	});
	 $('#travelModal').modal('hide');
}
function addTravelForm() {

	var formData = JSON.stringify(ConvertFormToJSON($("#toursform")));
	
	$.ajax({
		type : "POST",
		url : "/travel/addTours",
		data :  formData,
		success : function(data) {cityData=data;
		handlebarsTemplate();
		},
		dataType : "json",
		contentType : "application/json"
			
	});
	 $('#toursModal').modal('hide');
}

function addHotelForm() {

	var formData = JSON.stringify(ConvertFormToJSON($("#hotelform")));
	
	$.ajax({
		type : "POST",
		url : "/travel/addHotel",
		data :  formData,
		success : function(data) {cityData=data;
		handlebarsTemplate();
		},
		dataType : "json",
		contentType : "application/json"
			
	});
	 $('#hotelModal').modal('hide');
}

function ConvertFormToJSON(form){ 
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}
function handlebarsTemplate(){
	var theTemplateScript = $("#city-template").html();
	var theTemplate = Handlebars.compile(theTemplateScript);
	$(".cities").empty().append(theTemplate(cityData));
}

