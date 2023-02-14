<%-- 
    Document   : register
    Created on : Feb 1, 2023, 1:12:03 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
        <!-- ICON -->
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.2-web/css/all.min.css">
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="/DebtSystem/assets/css/register.css"/>

    </head>
    <body>
        <div class="h1 text-center mt-4 mb-4 header">Register Form</div>

        <div class="container">
            <div class="content mt-5">
                <div class="h3 text-center content-text">Register your account</div>
                <p class="text-center content-desc">
                    You have an account? <a href="login">Sign In Now !</a>
                </p>

                <form action="register" method="post"  name="" class="" id="registerForm">
                    <!-- Name -->
                    <div class="form-group  form-item">
                        <label for="email" class="label-field"
                               >Username <span class="text-danger">*</span></label
                        >
                        <input 
                            type="text"
                            class="form-control"
                            placeholder="Username"
                            id="name"
                            name="name"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!-- Email -->
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Email <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="E-mail"
                            id="email"
                            name="email"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!-- Phone -->
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Phone Number <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Phone Number"
                            id="phone"
                            name="phone"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!--  Dia chi--> 
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Address <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Address"
                            id="adr"
                            name="adr"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!--  Anh--> 
                    <div class="form-group form-item">
                        <label for="pic" class="label-field"
                               >Picture<span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Http only"
                            id="pic"
                            name="pic"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!--  Gioi Tinh--> 
                    <div class="form-group form-item mt-2  ">
                        <div class="gen_block ">
                            <label for="male" id="gen" class="gen "
                                   >Male<span class="">*</span></label
                            >
                            <input
                                type="radio"
                                class=""
                                placeholder=""
                                id="male"
                                name="gender"
                                value ="1"
                                />
                        </div>
                        <div class="gen_block">
                            <label for="female" id="gen1" class="gen"
                                   >Female<span class="">*</span></label
                            >
                            <input
                                type="radio"
                                class=""
                                placeholder=""
                                id="female"
                                name="gender"
                                value ="0"
                                />
                        </div>
                        <span id="er_mess_radio" class="errormess "></span>
                    </div>

                    <!-- Pass -->
                    <div class="form-group  form-item">
                        <label for="password" class="label-field"
                               >Password <span class="text-danger">*</span></label
                        >
                        <input
                            type="password"
                            class="form-control"
                            placeholder="Password"
                            id="password"
                            name="password"
                            />
                        <span class="errormess "></span>

                    </div>
                    <!-- Repass -->
                    <div class="form-group  form-item">
                        <label for="password" class="label-field"
                               >Re-password <span class="text-danger">*</span></label
                        >
                        <input
                            type="password"
                            class="form-control"
                            placeholder="Re-password"
                            id="repassword"
                            name="repassword"
                            />
                        <span class="errormess "></span>

                    </div>
                    <input name="type_otp" value="2" hidden></input>
                    <div class="form-group mt-1 form-item-btn mt-3">
                        <button
                            type="submit"
                            class="btn btn-primary btn-register form-control"
                            id="login-btn"
                            >
                            Sign up
                        </button>
                    </div>

                    <div class="form-group mt-1 form-item-btn mt-3 submit_btn">
                        <button
                            type="submit"
                            class="btn btn-primary btn-register form-control "
                            id="login-btn"
                            >
                            Sign up
                        </button>
                    </div>
                    <p class="mess-error">${requestScope.message}</p>
                </form>

            </div>
        </div>
        <script src="/DebtSystem/assets/js/register.js"></script>
    </body>
</html>
