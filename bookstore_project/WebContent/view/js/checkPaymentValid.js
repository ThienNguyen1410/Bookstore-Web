function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validate()
{
  if(!document.getElementById('agree1').checked)
  {
    alert('Please view the Checkbox carefully');
    return false;
  }
  
  else if(!document.getElementById('agree2').checked)
  {
	    alert('Please view the Checkbox carefully');
	    return false;
	  }

  return true;
  
  
}

function validate2()
{
  if(!document.getElementById('agree3').checked)
  {
    alert('Please view the Checkbox carefully');
    return false;
  }
  
  else if(!document.getElementById('agree4').checked)
  {
	    alert('Please view the Checkbox carefully');
	    return false;
	  }

  return true;
  
  
}