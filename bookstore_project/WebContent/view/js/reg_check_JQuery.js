$(function() {
    $('.error').hide();
    $(".Register").click(function() {

    		
      $('.error').hide();
  	  var name = $("input#reg_form_usern").val();
  		if (name.match(/^\s*$/)) {
        $("label#reg_form_usern_check").show();
        $("input#reg_form_usern").focus();
        return false;
      }
  		var email = $("input#reg_form_mail").val();
  		if ((email.length < 9) || (email.indexOf('@') === -1) || (email.indexOf('.') === -1)) {
        $("label#reg_form_mail_check").show();
        $("input#reg_form_mail").focus();
        return false;
      }
  		var pass = $("input#reg_form_pass").val();
  		if (pass.length < 8) {
        $("label#reg_form_pass_check").show();
        $("input#reg_form_pass").focus();
        return false;
      }
  		
  		var passConf = $("input#reg_form_ret_pass").val();
  		if (passConf != pass) {
        $("label#reg_form_ret_pass_check").show();
        $("input#reg_form_ret_pass").focus();
        return false;
      }
  		
    });
  });