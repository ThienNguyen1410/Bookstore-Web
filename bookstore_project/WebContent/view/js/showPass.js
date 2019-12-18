function myFunctionShow() {
  var x = document.getElementById("log_form_pass");
  var y = document.getElementById("log_form_pass");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function myFunctionShowReg() {
	  var x = document.getElementById("reg_form_pass");
	  var y = document.getElementById("reg_form_ret_pass");
	  if (x.type === "password" || y.type === "password" ) {
	    x.type = "text";
	    y.type = "text";
	  } else {
	    x.type = "password";
	    y.type = "password";
	  }
	}

function myFunctionShowEdit() {
	  var x = document.getElementById("profile_pass_edit");
	  if (x.type === "password" ) {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}