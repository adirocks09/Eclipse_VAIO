function myFunction(p){
	console.log("MyJavaScript.js : inside JS Function : myFunction")
	document.getElementById("valueBox").value=p;
	console.log(p)
}

function mySumPOST(){
	console.log("inside JS Function : mySumPOST")
	var a = document.getElementById("num1").value;
	var b = document.getElementById("num2").value;
    var c =a+b;
    document.getElementById("sum1").value=c;
}

function mySumGET(){
	console.log("inside JS Function : mySumGET")
	var a = document.getElementById("num3").value;
	var b = document.getElementById("num4").value;
    var c =a+b;
    document.getElementById("sum2").value=c;
}

function makeAjaxCall(){
	console.log("inside JS Function : makeAjaxCall")
	var nameForm = document.getElementById("name").value;
	var ageForm = document.getElementById("age").value;
	var salaryForm = document.getElementById("salary").value;
	console.log("Form Parametres");
	console.log(nameForm , ageForm , salaryForm );
	console.log("----------------------------");
	
	
	var reqObject ={
			name : nameForm,
			age  : ageForm,
			salary : salaryForm
	}
	console.log("Request Object");
	console.log(reqObject);
	console.log("----------------------------");

	var requestJSONInString= JSON.stringify(reqObject);
	console.log("Request Object in JSON String");
	console.log(requestJSONInString);
	console.log("----------------------------");

	
	$.ajax({
	    url: "/api/viewResponse",
	    headers: {
	        "Content-Type":"application/json",
	        "Accept":"application/json",
	        "My-Custom_Header":"AdityaAnand"
	    },
	    method: "POST",
	    dataType: "json",
	    data: requestJSONInString,
	    success: function(respObject){
	      console.log("Sucesss....");
	  	  console.log("Response Object");
	  	  console.log(respObject);
		  console.log("----------------------------");
		  
	  	  console.log("Response Object in String");
	  	  var responseJSONInString = JSON.stringify(respObject);
	  	  console.log(responseJSONInString);
	  	  
	  	  document.getElementById("updatedName").value=respObject.petName;
	  	  document.getElementById("updatedAge").value=respObject.oldAge;
	  	  document.getElementById("updatedSalary").value=respObject.increasedSalary;

	    }
	  });
}