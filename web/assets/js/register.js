

function checkEmptyInputWithInput() {
    //Take all input tags
    var inputs = document.querySelectorAll("input");
    let isEmpty;
    //Loop through all input tags
    inputs.forEach(function (cur) {
        if (cur.id != 'male' && cur.id != 'female' ) {
            cur.oninput = () => {
                // If input value is empty
                var valueInput = cur.value;
                var emptyInput = valueInput.trim() ? true : "Please input information field!";
                // Return a message error
                if (emptyInput !== true) {
                    if(cur.id != 'pic'){
                        isEmpty = false;
                        // Find next element equal level of current element are focused
                        cur.nextElementSibling.textContent = emptyInput;
                        cur.classList.add("invalid");
                        cur.nextElementSibling.classList.add("invalid");
                    }else{
                        isEmpty = true;
                        // Find next element equal level of current element are focused
                        cur.nextElementSibling.textContent = "";
                        cur.classList.remove("invalid");
                        cur.nextElementSibling.classList.remove("invalid");
                    }
                } else {
                    cur.nextElementSibling.textContent = "";
                    cur.classList.remove("invalid");
                    cur.nextElementSibling.classList.remove("invalid");
                    // If all inputs are note empty then check format of phonenumber
                    switch (cur.id) {
                        //Check phone format
                        case "phone":
                            let isformat = formatPhone(cur);
                            if (isformat === false) {
                                isEmpty = false;
                            } else {
                                isEmpty = true;
                            }
                            break;
                        //Check account format 
                        case "email":
                            let isEmail = formatEmail(cur);
                            if (isEmail !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isEmail;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        case "name":
                            let isName = formatName(cur);
                            if (isName !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isName;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        //Check password format 
                        case "password":
                            let isPass = formatPassword(cur);
                            if (isPass !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isPass;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        case "repassword":
                            let isRePass = checkBothPassword(cur);
                            if (isRePass !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isRePass;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                            case "pic":
                                let isPic = checkLinkImg(cur);
                                if (isPic !== true) {
                                    isEmpty = false;
                                    cur.nextElementSibling.textContent = isPic;
                                    cur.classList.add("invalid");
                                    cur.nextElementSibling.classList.add("invalid");
                                } else {
                                    isEmpty = true;
                                    cur.nextElementSibling.textContent = "";
                                    cur.classList.remove("invalid");
                                    cur.nextElementSibling.classList.remove("invalid");
                                }
                                break;
                        default:
                            break;
                    }

                }
            };
        }
    });
    return isEmpty;
}
function checkEmptyInputWithBlur() {
    //Take all input tags
    var inputs = document.querySelectorAll("input");
    let isEmpty;
    //Loop through all input tags
    inputs.forEach(function (cur) {
        if (cur.id != 'male' && cur.id != 'female') {
            cur.onblur = () => {
                // If input value is empty
                var valueInput = cur.value;
                var emptyInput = valueInput.trim() ? true : "Please input information field!";
                // Return a message error
                if (emptyInput !== true) {
                    if(cur.id != 'pic'){
                        isEmpty = false;
                        // Find next element equal level of current element are focused
                        cur.nextElementSibling.textContent = emptyInput;
                        cur.classList.add("invalid");
                        cur.nextElementSibling.classList.add("invalid");
                    }
                } else {
                    cur.nextElementSibling.textContent = "";
                    cur.classList.remove("invalid");
                    cur.nextElementSibling.classList.remove("invalid");
                    // If all inputs are note empty then check format of phonenumber
                    switch (cur.id) {
                        //Check phone format
                        case "phone":
                            let isformat = formatPhone(cur);
                            if (isformat === false) {
                                isEmpty = false;
                            } else {
                                isEmpty = true;
                            }
                            break;
                        //Check account format 
                        case "email":
                            let isEmail = formatEmail(cur);
                            if (isEmail !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isEmail;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        case "name":
                            let isName = formatName(cur);
                            if (isName !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isName;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        //Check password format 
                        case "password":
                            let isPass = formatPassword(cur);
                            if (isPass !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isPass;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        case "repassword":
                            let isRePass = checkBothPassword(cur);
                            if (isRePass !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isRePass;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;
                        //Check img link
                        case "pic":
                            let isPic = checkLinkImg(cur);
                            if (isPic !== true) {
                                isEmpty = false;
                                cur.nextElementSibling.textContent = isPic;
                                cur.classList.add("invalid");
                                cur.nextElementSibling.classList.add("invalid");
                            } else {
                                isEmpty = true;
                                cur.nextElementSibling.textContent = "";
                                cur.classList.remove("invalid");
                                cur.nextElementSibling.classList.remove("invalid");
                            }
                            break;

                        default:
                            break;
                    }

                }
            };
        }
       
    });
    return isEmpty;
}
function checkEmptyInputWhenSubmit() {
    //Take all input tags
    var inputs = document.querySelectorAll("input");
    let isEmpty;
    let checkRadioMale = true;
    let checkRadioFemale = true;
    //Loop through all input tags
    inputs.forEach(function (cur) {
        if (cur.id == 'male' || cur.id == 'female' || cur.id == 'pic') {
            if (cur.id == 'male') {
                if (cur.checked != true) {
                    checkRadioMale = false;
                }
            }
            if (cur.id == 'female') {
                if (cur.checked != true) {
                    checkRadioFemale = false;
                }
            }
            if (cur.id == 'pic') {
                //Check img link
                if (cur.value !== '') {
                    let isPic = checkLinkImg(cur);
                    if (isPic !== true) {
                        isEmpty = false;
                        cur.nextElementSibling.textContent = isPic;
                        cur.classList.add("invalid");
                        cur.nextElementSibling.classList.add("invalid");
                    } else {
                        isEmpty = true;
                        cur.nextElementSibling.textContent = "";
                        cur.classList.remove("invalid");
                        cur.nextElementSibling.classList.remove("invalid");
                    }
                }
            }


        } else {
            // If input value is empty
            var valueInput = cur.value;
            var emptyInput = valueInput.trim() ? true : "Please input information field!";
            // Return a message error
            if (emptyInput !== true) {
                isEmpty = false;
                // Find next element equal level of current element are focused
                cur.nextElementSibling.textContent = emptyInput;
                cur.classList.add("invalid");
                cur.nextElementSibling.classList.add("invalid");
            } else {
                cur.nextElementSibling.textContent = "";
                cur.classList.remove("invalid");
                cur.nextElementSibling.classList.remove("invalid");
                // If all inputs are note empty then check format of phonenumber
                switch (cur.id) {
                    //Check phone format
                    case "phone":
                        let isformat = formatPhone(cur);
                        if (isformat === false) {
                            isEmpty = false;
                        } else {
                            isEmpty = true;
                        }
                        break;
                    //Check account format 
                    case "email":
                        let isEmail = formatEmail(cur);
                        if (isEmail !== true) {
                            isEmpty = false;
                            cur.nextElementSibling.textContent = isEmail;
                            cur.classList.add("invalid");
                            cur.nextElementSibling.classList.add("invalid");
                        } else {
                            isEmpty = true;
                            cur.nextElementSibling.textContent = "";
                            cur.classList.remove("invalid");
                            cur.nextElementSibling.classList.remove("invalid");
                        }
                        break;
                    case "name":
                        let isName = formatName(cur);
                        if (isName !== true) {
                            isEmpty = false;
                            cur.nextElementSibling.textContent = isName;
                            cur.classList.add("invalid");
                            cur.nextElementSibling.classList.add("invalid");
                        } else {
                            isEmpty = true;
                            cur.nextElementSibling.textContent = "";
                            cur.classList.remove("invalid");
                            cur.nextElementSibling.classList.remove("invalid");
                        }
                        break;
                    //Check password format 
                    case "password":
                        let isPass = formatPassword(cur);
                        if (isPass !== true) {
                            isEmpty = false;
                            cur.nextElementSibling.textContent = isPass;
                            cur.classList.add("invalid");
                            cur.nextElementSibling.classList.add("invalid");
                        } else {
                            isEmpty = true;
                            cur.nextElementSibling.textContent = "";
                            cur.classList.remove("invalid");
                            cur.nextElementSibling.classList.remove("invalid");
                        }
                        break;
                    case "repassword":
                        let isRePass = checkBothPassword(cur);
                        if (isRePass !== true) {
                            isEmpty = false;
                            cur.nextElementSibling.textContent = isRePass;
                            cur.classList.add("invalid");
                            cur.nextElementSibling.classList.add("invalid");
                        } else {
                            isEmpty = true;
                            cur.nextElementSibling.textContent = "";
                            cur.classList.remove("invalid");
                            cur.nextElementSibling.classList.remove("invalid");
                        }
                        break;


                    default:
                        break;
                }

            }
        }
    });
    if (checkRadioMale == false && checkRadioFemale == false) {
        document.getElementById("er_mess_radio").textContent = "Please chose field!";
        document.getElementById("er_mess_radio").classList.add("invalid");
        document.getElementById("gen").classList.add("invalid");
        document.getElementById("gen1").classList.add("invalid");
    } else {
        document.getElementById("er_mess_radio").textContent = "";
        document.getElementById("er_mess_radio").classList.remove("invalid");
        document.getElementById("gen").classList.remove("invalid");
        document.getElementById("gen1").classList.remove("invalid");
    }
    return isEmpty;
}
function formatPhone(phone) {
    // let phoneNumber = document.querySelector("#phone").value;
    let checkFormat = /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(phone.value);
    let messageFormat = checkFormat ? true : "Wrong format of phone number";
    let isFormat = true;
    if (messageFormat !== true) {
        isFormat = false;
        // Find next element equal level of current element are focused
        phone.nextElementSibling.textContent = messageFormat;
        phone.classList.add("invalid");
        phone.nextElementSibling.classList.add("invalid");
    } else {
        isFormat = true;
        phone.nextElementSibling.textContent = "";
        phone.classList.remove("invalid");
        phone.nextElementSibling.classList.remove("invalid");
    }
    return isFormat;
}

function formatEmail(email) {
    let check;
    // before the @gmail.com and accepts everything else
    //Not except @ () , . : " " [] <> \ , dấu cách 
    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let formatEmail = regexp.test(String(email.value).toLowerCase());
    if (formatEmail !== true) {
        check = "Wrong email format!";
    } else {
        check = true;
    }
    return check;
}

function formatPassword(pass) {
    let check;
    if (pass.value.length < 6) {
        check = "Length of password mute above 6 characters";
    } else {
        let regExp = /^(?=.*[a-zA-Z])(?=.*[0-9])/;
        let isMatch = regExp.test(pass.value);
        if (isMatch) {
            check = true;
        } else {
            check = "Password do not have both letter and number";
        }
    }
    return check;
}
function formatName(name) {
    let check;

    let regExp = /^[A-Za-z0-9 ]+$/;
    let isMatch = regExp.test(name.value);
    let re = /^\S+$/;
    if (isMatch) {
        if (re.test(name.value)) { // ko có space 
            check = true;
        } else { // có space
            check = "Name not allow space between characters";
        }
    } else { // có special character
        check = "Name not allow to have special character";
    }
    return check;
}
function clickRadio() {
    var male = document.getElementById('male');
    var female = document.getElementById('female');
    male.onclick = function () {
        document.getElementById("er_mess_radio").textContent = "";
        document.getElementById("er_mess_radio").classList.remove("invalid");
        document.getElementById("gen").classList.remove("invalid");
        document.getElementById("gen1").classList.remove("invalid");
    };

    female.onclick = function () {
        document.getElementById("er_mess_radio").textContent = "";
        document.getElementById("er_mess_radio").classList.remove("invalid");
        document.getElementById("gen").classList.remove("invalid");
        document.getElementById("gen1").classList.remove("invalid");
    };

}


function checkBothPassword(repassword) {
    let pass = document.querySelector("#password");
    let check;
    if (repassword.value === pass.value) {
        check = true;
    } else {
        check = "Repassword is no duplicate with password!";
    }
    return check;
}

function checkLinkImg(img) {
    if (img.value.startsWith('https')) {
        return true;
    } else {
        return "Picture is not link https";
    }
}

function formatPhone(phone) {
    // let phoneNumber = document.querySelector("#phone").value;
    let checkFormat = /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(phone.value);
    let messageFormat = checkFormat ? true : "Wrong format of phone number";
    let isFormat = true;
    if (messageFormat !== true) {
        isFormat = false;
        // Find next element equal level of current element are focused
        phone.nextElementSibling.textContent = messageFormat;
        phone.classList.add("invalid");
        phone.nextElementSibling.classList.add("invalid");
    } else {
        isFormat = true;
        phone.nextElementSibling.textContent = "";
        phone.classList.remove("invalid");
        phone.nextElementSibling.classList.remove("invalid");
    }
    return isFormat;
}

function formatEmail(email) {
    let check;
    // before the @gmail.com and accepts everything else
    //Not except @ () , . : " " [] <> \ , dấu cách 
    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let formatEmail = regexp.test(String(email.value).toLowerCase());
    if (formatEmail !== true) {
        check = "Wrong email format!";
    } else {
        check = true;
    }
    return check;
}

function formatPassword(pass) {
    let check;
    if (pass.value.length < 6) {
        check = "Length of password mute above 6 characters";
    } else {
        let regExp = /^(?=.*[a-zA-Z])(?=.*[0-9])/;
        let isMatch = regExp.test(pass.value);
        if (isMatch) {
            check = true;
        } else {
            check = "Password do not have both letter and number";
        }
    }
    return check;
}
function formatName(name) {
    let check;

    let regExp = /^[A-Za-z0-9 ]+$/;
    let isMatch = regExp.test(name.value);
    let re = /^\S+$/;
    if (isMatch) {
        if (re.test(name.value)) { // ko có space 
            check = true;
        } else { // có space
            check = "Name not allow space between characters";
        }
    } else { // có special character
        check = "Name not allow to have special character";
    }
    return check;
}
function clickRadio() {
    var male = document.getElementById('male');
var female = document.getElementById('female');
male.onclick = function () {
    document.getElementById("er_mess_radio").textContent = "";
    document.getElementById("er_mess_radio").classList.remove("invalid");
    document.getElementById("gen").classList.remove("invalid");
    document.getElementById("gen1").classList.remove("invalid");
};

female.onclick = function () {
    document.getElementById("er_mess_radio").textContent = "";
    document.getElementById("er_mess_radio").classList.remove("invalid");
    document.getElementById("gen").classList.remove("invalid");
    document.getElementById("gen1").classList.remove("invalid");
};

}


function checkBothPassword(repassword) {
    let pass = document.querySelector("#password");
    let check;
    if (repassword.value === pass.value) {
        check = true;
    } else {
        check = "Repassword is no duplicate with password!";
    }
    return check;
}

function checkLinkImg(img) {
    if (img.value.startsWith('https')) {
        return true;
    } else {
        return "Picture is not link https";
    }
}


var formRegister = document.querySelector("#registerForm");
if (formRegister) {
     clickRadio();
    var checkEmptyAllInput;
    formRegister.onsubmit = function (e) {
        e.preventDefault();
        // All inputs can not be empty
        checkEmptyAllInput = checkEmptyInputWhenSubmit();
        //        // equal false min one of these inputs are empty
        if (checkEmptyAllInput === true) {
            document.getElementById("registerForm").submit();

        }
        document.querySelector(".submit_btn").classList.add("btn_appear");
    };
    //   addEventListener('submit', (e) => {
    //         e.preventDefault();
    //         checkEmptyInputWhenSubmit();
    ////         var checkEmptyAllInput = checkEmptyInputWhenSubmit();
    ////         console.log(checkEmptyAllInput);
    //    });

}
//When user input then check
checkEmptyInputWithInput();
//When user blur then check
checkEmptyInputWithBlur();


