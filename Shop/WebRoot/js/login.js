function check_username(){
     
       var username = document.getElementById("username").value;
       var tips_username = document.getElementById("tips_username");
       if(username != ''){
          tips_username.style.display="none";
       }else{
          tips_username.style.display="";
       }
     }
      function check_password(){
       var pass = document.getElementById("password").value;
       var tips_pass = document.getElementById("tips_pass");
       if(pass != ''){
          tips_pass.style.display="none";
       }else{
          tips_pass.style.display="";
       }
     }
     function check_code(){
       var code = document.getElementById("code").value;
       var tips_code_null = document.getElementById("tips_code_null");
       var tips_code_succ = document.getElementById("tips_code_success");
       var tips_code_fail = document.getElementById("tips_code_fail");
       
       tips_code_null.style.display="none";
       tips_code_succ.style.display="none";
       tips_code_fail.style.display="none";
       if(code == ''){
          tips_code_null.style.display="";
       }else {
          tips_code_null.style.display="none";
           $.post("controller/CheckImgCode","code="+code,function(data){
		     if(data.isCheck){
		    	
		             tips_code_succ.style.display="";
		         }else{
		        	 tips_code_succ.style.display="none";
		             tips_code_fail.style.display="";
		         }
		     },"json");
          
       }
     }