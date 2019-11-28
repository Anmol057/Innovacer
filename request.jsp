<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<link href="/css/main.css" rel="stylesheet"></link>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Java Sample Approach Demo</title>
</head>
<body>
 
  <form name="details"  onsubmit="return(validate());",action="/",method="POST">
   <div style="text-align:center;POSITION:RELATIVE; LEFT:600PX;TOP:220PX";   >
    <table>
      <tr>
        <td>Email:</td>
        <td><input type="text" name ="emailAdd"/></td>
        <td><p id="eml"></p></td>
        
      </tr>
   <tr>
   </tr>
   <tr>
   </tr>
   <tr>
   </tr>
      <tr>
        <td>User Name:</td>
        <td><input type="text" name="userName"/></td>
        <td><p id="usrname"></p></td>
      </tr>
      <tr>
      <tr>
   </tr>
   <tr>
   </tr>
   <tr>
   </tr>
        <td>Phone:</td>
        <td><input type="text" name="Phone"/></td>
        <td><p id="phone"></p></td>
      </tr>
      <tr>
   </tr>
   <tr>
   </tr>
   <tr>
   </tr>
      <tr>
        <td colspan="2"><input type="submit" id="login" value="submit"></td>
      </tr>
      <tr>
      <td><div id="ms"></div></td>
      </tr>
    </table>
    </div>
  </form>
 
</body>
<script>
 

function validate(){
	var flag=0;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!document.details.emailAdd.value.match(mailformat))
		{
		document.getElementById("eml").innerHTML = "Please enter valid email";
		flag=1
		}
	if(document.details.Phone.value=="")

	{
			document.getElementById("phone").innerHTML = "Please enter UserName";
			flag=1
	}
	
	if(document.details.userName.value=="")

	{
			document.getElementById("usrname").innerHTML = "Please enter UserName";
			flag=1
	}
		
	if(flag==1)
	return false;
	
	var UserName =document.details.userName.value
	var Email=document.details.emailAdd.value
	var phon=document.details.Phone.value
	alert("Details Submitted")
	var jscriptsobj={userName:UserName,emailAdd:Email,Phone:phon};
	  var jsonobj=JSON.stringify(jscriptsobj);
	

$.ajax({
	
	type : "POST",
	url: "/",  // handling method inside Controller
	data :  "jsonobj="+jsonobj,
	
	success : function(data) // return data from controller
			{
		
	
		<%System.out.println("success done");%>
				var alldata= JSON.parse(data);
					
			if(alldata.ms!="null")
				document.getElementById("ms").innerHTML=alldata.ms;
			},
	Error : function(data) 
			{
				$('#msg').html("Enter name");
		//"userName="+userName+"&branch="+branch+"&university="+university+"&text="+text+"&email="+email,	
}});
	
		return true;
}						




									</script>
						
</html>
