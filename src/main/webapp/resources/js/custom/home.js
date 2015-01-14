
$(function() {
	// Get the HTML from the template in the script tag​
	
	var minDateObj= new Date();
	var pickerOpts = {minDate: new Date()
			};  
	handlebarsTemplate();
	$('.datepicker').datepicker(pickerOpts);


});

$('#mainModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var recipient = button.data('whatever') // Extract info from data-*
											// attributes
	// If necessary, you could initiate an AJAX request here (and then do the
	// updating in a callback).
	// Update the modal's content. We'll use jQuery here, but you could use a
	// data binding library or other methods instead.
	var modal = $(this)
	modal.find('.modal-title').text('New ' + recipient)

});
function addCityform() {

	var formData = JSON.stringify(ConvertFormToJSON($("#cityform")));
	
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
	 $('#mainModal').modal('hide');
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

