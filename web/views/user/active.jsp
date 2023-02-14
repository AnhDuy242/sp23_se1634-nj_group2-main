<%-- 
    Document   : active_page
    Created on : Feb 1, 2023, 3:38:20 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
        .container{
            background-color: #ccc;
            width: 100vw;
        }
      .block_active{
        padding: 10px;
        text-align: justify;
        margin-left: 45%;
       
      }
      .active_btn{
        margin-top: 15px;
        padding: 10px;
        color: #fff;
        background-color: #ff9800;
        cursor: pointer;
        margin-bottom: 20px;
      }
     .note_bock{
        padding: 20px;
        font-size: 25px;
        font-style: italic;
        opacity: 0.6;
     }
       .mess-error{
                font-style: italic;
                font-size: 25px;
                color: red;
            }
    </style>

    <div class="container">
        <div class="block_active">
            <h1 class="heading_block">Kích  hoạt tài khoản</h1>
            <form action="active" method="get" class="active_code_user">
              <p class="nickname">Nickname : ${requestScope.user.getDisplay_name()}</p>
            <p class="account">Account: ${requestScope.user.getEmail()}</p>
            <input type="text" name="user_id" hidden value="${requestScope.user.getUser_id()}">
            <input type="text" name="otp_id" hidden value="${requestScope.otp_id}">
            <div class="code">Code Active : <input type="text" name ="code"/></div>
            <a href="resend?user_id=${requestScope.user.getUser_id()}&type_otp=2">Resend Code</a>
            <p></p>
            <button class="active_btn">Xác nhận kích hoạt tài khoản</button>
              <p class="mess-error">${requestScope.message}</p>
              <p class="mess-error">${requestScope.code_time}</p>
          </form>
        </div>
        <div class="note_bock">
            <p>Lưu ý :</p>
            <p class="note">+ Đoạn mã chỉ được sử dụng 01 lần và có thời hạn trong vòng 2 phút. Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản.</p>
            <p class="note">+ Nếu không tìm thấy thông tin mã kích hoạt được gửi đến trong Email hãy bấm nút 'Resend Code' hoặc kiểm tra mục 'Spam' trong Email!</p>
            <p class="note">+ Nếu không thấy Email gửi về hay kiểm tra lại Email đăng ký!!</p>
        </div>
    </div>
    </body>
</html>
