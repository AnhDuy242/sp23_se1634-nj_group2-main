<%-- 
    Document   : Profile
    Created on : Feb 6, 2023, 4:32:07 PM
    Author     : nguye
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<!--        <body>
          <h1 style="font-weight: strong"> Information</h1>
        <table>
         <tr>
            <td>  UserName:</td>
            <td>  ${sessionScope.user.display_name}</td>
            
        </tr> 
         <tr>
            <td>  Email: </td>
            <td>  ${sessionScope.user.email} </td>
         </tr> 
         <tr>
            <td>  Phone Number: </td>
            <td>  ${sessionScope.user.phone_number}</td>
         </tr> 
         <tr>
            <td>  Address: </td>
            <td>  ${sessionScope.user.adr} </td>
         </tr> 
          </table>
        
         <a href="editprofile">Edit Profile</a>
       
        
    </body>-->
<h1 style="font-weight: strong">Profile</h1>
 <form action="UserProfileController" method="post">
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
                          padding:0 20px 20px 0;" type="textarea" name="address" value="${sessionScope.user.adr}"></br>  
           
            <input style="margin-left: 150px; margin-top: 20px;
                   padding: 10px 30px; 
                   background-color: green;
                   color: white;" 
            type="submit" value="Update">
            
            <button  type="button" class="btn btn-primary"><a href=editprofile>Edit Profile</a> </button>
        </form>
</html>
