<%-- 
    Document   : edit
    Created on : Feb 6, 2023, 4:32:12 PM
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
          <h1 style="font-weight: strong">Edit Information</h1>
        <form action="EditProfileController" method="post">
            <input type="hidden" name="userID" maxlength="150" value="${sessionScope.user.user_id}">
           UserName:  <input style="margin-bottom: 10px;
                              margin-left: 27px;
                              padding-right: 65px;
                              padding: 5px 0;" type="text" name="name" value="${sessionScope.user.display_name}"></br>
           
           Phone number: <input style="margin-bottom: 10px;
                                padding-left: 68px;
                                padding: 5px 0;" type="text" name="phoneNumber" value="${sessionScope.user.phone_number}"> </br>
           
           Email: <input style="margin-bottom: 10px;
                                margin-left: 56px;
                                padding-right: 65px;
                                padding: 5px 0;" type="text" name="email" value="${sessionScope.user.email}"></br>
           
           Address:<input style="margin: 10px 23px; 
                          padding:0 70px 70px 0;" type="textarea" name="address" value="${sessionScope.user.adr}"></br>  
           
            <input style="margin-left: 150px; margin-top: 20px;
                   padding: 10px 30px; 
                   background-color: green;
                   color: white;" 
            type="submit" value="Update">
            
            <button  type="button" class="btn btn-primary"><a href=changepassword>Change Password</a> </button>
        </form>
    </body>
</html>
