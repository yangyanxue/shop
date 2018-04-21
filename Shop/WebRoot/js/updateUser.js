 
       
		 function check_password(){
		    var pass = document.getElementById("password").value;
			var tips_check_pass=document.getElementById("tips_pass");
			if(pass == ''){
			  
              tips_check_pass.style.display="";
			}else{
			 tips_check_pass.style.display="none";
			}
		 }
		 function check_username(){
		 
		     var username = document.getElementById("username").value; 
		     var tips_username_exist=document.getElementById("tips_username_exist");
		     var tips_username_null=document.getElementById("tips_username_null");
		     tips_username_null.style.display="none";
		     tips_username_exist.style.display="none";
		     if(username != ''){
		    	 $.post("controller/CheckUsername","username="+username,function(data){
		         if(data.isCheck){
		             tips_username_exist.style.display="none";
		         }else{
		              tips_username_exist.style.display="";
		         }
		     },"json");
		     }else{
		    	 tips_username_null.style.display="";
		     }
		     
		 }