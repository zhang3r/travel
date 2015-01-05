function submitform() {
	document.myform.submit("addCity");
}

$(function() {
	var shoesData = [ {
		name : "Nike",
		price : 199.00
	}, {
		name : "Loafers",
		price : 59.00
	}, {
		name : "Wing Tip",
		price : 259.00
	} ];
	

	
	// Get the HTML from the template in the script tag​
	var theTemplateScript = $("#city-template").html();
	var theTemplate = Handlebars.compile(theTemplateScript);
	$(".cities").append(theTemplate(cityData));

});