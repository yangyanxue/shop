 
        function password_sure(){
           var pass = document.getElementById("password");
           var sure_pass = document.getElementById("surepassword");
           var tips_pass =  document.getElementById("tips_pass");
           if(pass.value != sure_pass.value){
		      tips_pass.style.display="";
		   }else{
		      tips_pass.style.display="none";
		   }
         }
		 function check_password(){
		    var pass = document.getElementById("password").value;
			var tips_check_pass=document.getElementById("tips_check_pass");
			if(pass.length !=6){
			  
              tips_check_pass.style.display="";
			}else{
			 tips_check_pass.style.display="none";
			}
		 }
		 function check_username(){
		 
		     var username = document.getElementById("username").value; 
		     var tips_username=document.getElementById("tips_name");
		     $.post("controller/CheckUsername","username="+username,function(data){
		     if(data.isCheck){
		             tips_username.style.display="";
		         }else{
		             tips_username.style.display="none";
		         }
		     },"json");
		 }