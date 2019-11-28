package com.example.demo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

import javax.validation.Validator;

import org.json.JSONException;
import org.json.JSONObject;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

 


@Controller 
public class WebController {
	InnovacerBean ib=new InnovacerBean();
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String doGet()
	{
		return "request";
	}
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null)
        {
            return false;
        }
        return pat.matcher(email).matches(); 
    }
	 JSONObject ja= new JSONObject();
	  @RequestMapping(value="/",method=RequestMethod.POST)
	  public @ResponseBody String  doPost(@RequestParam("jsonobj") String json) throws JSONException
	  {
		 System.out.println("received");
		//  JSONParser parser = new JSONParser();
		  JSONObject jsohhn = new JSONObject(json);  //It is used to make jsonobject of string json received from request.jsp
		  RequestInfo  requestInfo=new Gson().fromJson(json,RequestInfo.class);
		  //this validates the string received from request.jsp with the model RequestInfo but it needs to be binded binding result
		  // to get error messages
		
		  int flag=0;
		  
			
		  System.out.println(json);
		  System.out.println(requestInfo.getPhone());
		  System.out.println(requestInfo.getUserName());
		  System.out.println(requestInfo.getEmailAdd());
		  String sub="Innovacer Visit";
		  String msg="Thank you for visiting Innovacer.\n\n";
		  msg=msg+"Name - "+requestInfo.getUserName()+"\nEmail - "+requestInfo.getEmailAdd()+"\nPhone No. - "+requestInfo.getPhone();
		  String to=requestInfo.getEmailAdd();
		  String user="innovacernoida@gmail.com";
		  String pass="Anmol@123";
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));
		    String d=" ";
		     d=""+date;
		     msg=msg+"\nEntry Time - "+d;
		     msg=msg+"\n\nRegards,\nInnovacer Team";
		     send(to,sub,msg,user,pass);
		    System.out.println(d);
		    
		    String us=" ";
		     us=requestInfo.getUserName();
		     String ed=" ";
		     ed=requestInfo.getEmailAdd();
		     String ph=" ";
		     ph=requestInfo.getPhone();
		    
		    	ib.insertDetails( us,ed ,ph ,d); 	
		    
		    
			
			  ja.put("ms", "Successful");
			  System.out.println("no errors");
			  return ja.toString();
			  }
	  
		
	

    public static void send(String to, String sub,String msg, final String user, final String pass) 
    {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(user, pass);
            }
        });

        try 
        {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(sub);
            message.setText(msg);

            Transport.send(message);
            
            System.out.println("Email sent");
            
        } catch (MessagingException e) 
        {
            JOptionPane.showMessageDialog(null,"Something happened!");
            
            throw new RuntimeException(e);
        }
        
    }
    
}


//,@Valid @ModelAttribute("requestInfo") RequestInfo requestInfo,BindingResult bindingResult,ModelMap model