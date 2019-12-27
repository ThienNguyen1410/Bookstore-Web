

function checkForm(theForm){

     if(theForm.agree.checked === false){
          alert('Check your agreement!');
          return false;
        }
     else if(theForm.agree.checked === true){
         return true;
     }
    }
