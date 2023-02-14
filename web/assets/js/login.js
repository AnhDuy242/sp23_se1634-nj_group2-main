//Initial References
let submitButton = document.getElementById("login-btn");
let userInput = document.getElementById("captcha-input");
let canvas = document.getElementById("canvas");
let reloadButton = document.getElementById("reload-btn");
let text = "";
//Generate Text
const textGenerator = () => {
    let generatedText = "";
    /* String.fromCharCode gives ASCII value from a given number */
    // total 9 letters hence loop of 3
    for (let i = 0; i < 2; i++) {
        //65-90 numbers are capital letters
        generatedText += String.fromCharCode(randomNumber(65, 90));
        //97-122 are small letters
        generatedText += String.fromCharCode(randomNumber(97, 122));
        //48-57 are numbers from 0-9
        generatedText += String.fromCharCode(randomNumber(48, 57));
    }
    return generatedText;
};
//Generate random numbers between a given range
const randomNumber = (min, max) =>
    Math.floor(Math.random() * (max - min + 1) + min);
//Canvas part
function drawStringOnCanvas(string) {
    //The getContext() function returns the drawing context that has all the drawing properties and functions needed to draw on canvas
    let ctx = canvas.getContext("2d");
    //clear canvas
    ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);
    //array of text color
    const textColors = ["rgb(0,0,0)", "rgb(130,130,130)"];
    //space between letters
    const letterSpace = 150 / string.length;
    //loop through string
    for (let i = 0; i < string.length; i++) {
        //Define initial space on X axis
        const xInitialSpace = 25;
        //Set font for canvas element
        ctx.font = "20px Roboto Mono";
        //set text color
        ctx.fillStyle = textColors[randomNumber(0, 1)];
        ctx.fillText(
                string[i],
                xInitialSpace + i * letterSpace,
                randomNumber(25, 40),
                100
                );
    }
}
//Initial Function
function triggerFunction() {
    //clear Input
    userInput.value = "";
    text = textGenerator();
    console.log(text);
    //Randomize the text so that everytime the position of numbers and small letters is random
    text = [...text].sort(() => Math.random() - 0.5).join("");
    drawStringOnCanvas(text);
}
//call triggerFunction for reload button
reloadButton.addEventListener("click", triggerFunction);
//call triggerFunction when page loads
window.onload = () => triggerFunction();

jQuery.validator.addMethod('valid_captcha', function (value) {
    var regex = text;
    return value.trim().match(regex);
});

$(document).ready(function () {
    $("#loginForm").validate({
        rules: {
            email: {
                required: true,
            },
            password: {
                required: true,
            },
            captcha: {
                required: true,
                valid_captcha: true,
            },
        },

        messages: {
            email: {
                required: "Email cannot empty !"
            },
            password: {
                required: "Password cannot empty !",
            }, captcha: {
                required: "Captcha cannot empty ",
                valid_captcha: "Captcha is not match !",
            },
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") == "email") {
                error.appendTo("#email-error");
            } else if (element.attr("name") == "password") {
                error.appendTo("#password-error");
            } else if (element.attr("name") == "captcha") {
                error.appendTo("#captcha-error");
            } else {
                error.insertAfter(element);
            }
        },
    });
    $(document).on("click", "#addButton", function () {
        let result = $("#loginForm").valid();
    });
})



