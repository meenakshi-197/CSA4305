const email=document.getElementById("email");
const phone=document.getElementById("phone");

const emailError=document.getElementById("emailError");
const phoneError=document.getElementById("phoneError");

const emailPattern=/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

const phonePattern=/^[0-9]{10}$/;

email.addEventListener("keyup",function(){

if(emailPattern.test(email.value))
{

emailError.innerHTML="Valid Email";

emailError.style.color="green";

}
else
{

emailError.innerHTML="Invalid Email Address";

emailError.style.color="red";

}

});

phone.addEventListener("keyup",function(){

if(phonePattern.test(phone.value))
{

phoneError.innerHTML="Valid Phone Number";

phoneError.style.color="green";

}
else
{

phoneError.innerHTML="Phone Number must contain 10 digits";

phoneError.style.color="red";

}

});

document.getElementById("regForm").addEventListener("submit",function(e){

if(!emailPattern.test(email.value) || !phonePattern.test(phone.value))
{

alert("Please enter valid details.");

e.preventDefault();

}

});
