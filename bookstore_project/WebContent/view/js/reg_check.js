var reg_form_usern;
var reg_form_mail;
var reg_form_pass;
var reg_form_ret_pass;
var valid;

function checkForm(theForm){
     valid = true;
     reg_form_usern = document.getElementById('reg_form_usern').value;
     reg_form_mail = document.getElementById('reg_form_mail').value;
     reg_form_pass = document.getElementById('reg_form_pass').value;
     reg_form_ret_pass = document.getElementById('reg_form_ret_pass').value;
     
     if (reg_form_usern.match(/^\s*$/)) {
            document.getElementById('reg_form_usern_check').innerHTML = "Username is empty or wrong!";
            valid = false;
        } 
     else{
            document.getElementById('reg_form_usern_check').innerHTML = "";
        }

     if ((reg_form_mail.length < 9) || (reg_form_mail.indexOf('@') === -1) || (reg_form_mail.indexOf('.') === -1)){
            document.getElementById('reg_form_mail_check').innerHTML = "Invalid Email address!";
            valid = false;
        } 
     else {
            document.getElementById('reg_form_mail_check').innerHTML = "";
        }


     if(theForm.agree.checked === false){
          alert('You do not agree with our Term and Policy?');
          return false;
        }
     else if(theForm.agree.checked === true){
         return true;
        }
     if (valid === true) {
            storeData(reg_form_usern, reg_form_mail, reg_form_pass);
            return true;
        } 
     else {
            return false;
        }
    }



    function storeData(reg_form_usern, reg_form_mail, reg_form_pass) {
        setCookie("reg_form_usern", reg_form_usern, 365);
        setCookie("reg_form_mail", reg_form_mail, 365);
        setCookie("reg_form_pass", reg_form_pass, 365);
    } 