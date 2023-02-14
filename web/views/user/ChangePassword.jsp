<%-- 
    Document   : ChangePassword
    Created on : Feb 6, 2023, 4:31:55 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1 style="font-weight: strong">Change Password</h1>
        <form action="UpdateController" method="post">
<!--            Full Name:  <input style="margin-bottom: 10px;
                              margin-left: 27px;
                              padding-right: 65px;
                               padding: 5px 0;" type="text" name="fullname"></br>
           -->
            
           New Password:  <input style="margin-bottom: 10px;
                              margin-left: 27px;
                              padding-right: 65px;
                              padding: 5px 0;" type="password" name="new" value=""></br>
           
           Retype password: <input style="margin-bottom: 10px;
                                padding-left: 68px;
                                padding: 5px 0;" type="password" name="retype"> </br>
          
           
            <input style="margin-left: 150px; margin-top: 20px;
                   padding: 10px 30px; 
                   background-color: green;
                   color: white;" 
                   type="submit" value="Change"><br>
             <span style="color:red">
               ${No}
           </span> 
           
           <span style="color:green">
               ${Yes}
           </span> 
        </form>
    </body>
</html>
