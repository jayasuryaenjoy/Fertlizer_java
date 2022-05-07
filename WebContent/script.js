/**
 * 
 */
//script for name validation
function nameValidation(v){
var regex = /^[a-zA-Z ]*$/;
var res =regex.test(v);

if(res==true)
{
document.getElementById("nameError").innerHTML="";
}
else
{
document.getElementById("nameError").innerHTML="name not valid";
document.getElementById("nameError").style.color="red";

}
}



// script for mail validation
function mailValidation(m)
{
var array=m.split("@");
if(array.length>=2)
{

if(array[0].length>=2)
{
var x=array[1];
var array1=x.split(".");
if(array1.length>=2)
{
if(array1[0].length>=5)
{
if(array1[1].length>=2)
{
document.getElementById("mailIdError").innerHTML="";
}
else
{
document.getElementById("mailIdError").innerHTML="E-mail id not valid";
document.getElementById("mailIdError").style.color="red";
}
}
else
{
document.getElementById("mailIdError").innerHTML="E-mail id not valid";
document.getElementById("mailIdError").style.color="red";
}
}
else
{
document.getElementById("mailIdError").innerHTML="E-mail id not valid";
document.getElementById("mailIdError").style.color="red";

}
}
else
{
document.getElementById("mailIdError").innerHTML="E-mail id not valid";
document.getElementById("mailIdError").style.color="red";
}
}
else
{
document.getElementById("mailIdError").innerHTML="E-mail id not valid";
document.getElementById("mailIdError").style.color="red";
}

}
// script for password validation
function passWordValidation(p)
{ var flag=0;
var a=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
for(var i=0;i<a.length;i++)
{
if(p.charAt(0)==a[i])
{
if(p.charAt(p.length-1)!='@' && p.charAt(p.length-1)!='#' && p.charAt(p.length-1)!='$' && p.charAt(p.length-1)!='&' && p.charAt(p.length-1)!='*' && p.charAt(p.length-1)!='%')
{
flag=1;
}
}
}
if(flag==1)
{
document.getElementById("passWordError").innerHTML="";

}
else
{
document.getElementById("passWordError").innerHTML="password is not valid(1st Letter should capital& Last letter should not symbol)";
document.getElementById("passWordError").style.color="red";
}
}
// script for password confirmation
function passwordConfirmation(n)
{
if(n=="")
{
document.getElementById("confirmationError").innerHTML="Cannot be null";
}
else if(document.getElementById("Password").value==n)
{

document.getElementById("confirmationError").innerHTML="Password Matched";
document.getElementById("confirmationError").style.color="green";

}
else
{

document.getElementById("confirmationError").innerHTML="password is not matched";
document.getElementById("confirmationError").style.color="red";
}
}


//script for mobile number validation
function mobileNumber(number)
{
var flag=0;
var a=[0,1,2,3,4,5,6,7,8,9];
if(number.charAt(0)==9 || number.charAt(0)==8 || number.charAt(0)==7)
{
flag=flag+1;
for(var i=1;i<number.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(number.charAt(i)==a[j])
{
flag=flag+1;
console.log(flag);
break;
}
}
}
}
if(flag==10)
{
document.getElementById("mobileNumberError").innerHTML="";
}
else
{
document.getElementById("mobileNumberError").innerHTML="Mobile number is not valid";
document.getElementById("mobileNumberError").style.color="red";
}
}
//script for age validation
function valid(age1)
{

var age = parseInt(age1);
if (isNaN(age) || age < 10 || age > 100)
{

document.getElementById("ageError").innerHTML="You cannot sign in";
document.getElementById("ageError").style.color="red";
}
else
{

document.getElementById("ageError").innerHTML="Age is valid";
document.getElementById("ageError").style.color="green";

}
}


function father(v){
if(v.length>=1)
{
var flag=0;
var a=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '];
var b=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '];
for(var i=0;i<v.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(v.charAt(0)==a[j] || v.charAt(0)==b[j])
{
flag=flag+1;

}
}
}
if(v.length==flag)
{
document.getElementById("fathernameError").innerHTML="";
}
else
{
document.getElementById("fathernameError").innerHTML="name not valid";
document.getElementById("fathernameError").style.color="red";

}
}

}

function parent(number)
{
var flag=0;
var a=[0,1,2,3,4,5,6,7,8,9];
if(number.charAt(0)==9 || number.charAt(0)==8 || number.charAt(0)==7)
{
flag=flag+1;
for(var i=1;i<number.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(number.charAt(i)==a[j])
{
flag=flag+1;
console.log(flag);
break;
}
}
}
}
if(flag==10)
{
document.getElementById("parentnumberError").innerHTML="";
}
else
{
document.getElementById("parentnumberError").innerHTML="Mobile number is not valid";
document.getElementById("parentnumberError").style.color="red";
}
}

function profession(v){
if(v.length>=1)
{
var flag=0;
var a=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '];
var b=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '];
for(var i=0;i<v.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(v.charAt(0)==a[j] || v.charAt(0)==b[j])
{
flag=flag+1;

}
}
}
if(v.length==flag)
{
document.getElementById("professionError").innerHTML="";
}
else
{
document.getElementById("professionError").innerHTML="name not valid";
document.getElementById("professionError").style.color="red";

}
}

}

function proof(v){
if(v.length>=1)
{
var flag=0;
var a=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '];
var b=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '];
for(var i=0;i<v.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(v.charAt(0)==a[j] || v.charAt(0)==b[j])
{
flag=flag+1;

}
}
}
if(v.length==flag)
{
document.getElementById("proofError").innerHTML="";
}
else
{
document.getElementById("proofError").innerHTML="name not valid";
document.getElementById("proofError").style.color="red";

}
}

}
//script for mail validation in login slide
function mailValidation1(m)
{
var array=m.split("@");
if(array.length>=2)
{

if(array[0].length>=2)
{
var mani=array[1];
var array1=mani.split(".");
if(array1.length>=2)
{
if(array1[0].length>=5)
{
if(array1[1].length>=2)
{
document.getElementById("mailIdError1").innerHTML="";
}
else
{
document.getElementById("mailIdError1").innerHTML="E-mail id not valid";
document.getElementById("mailIdError1").style.color="red";
}
}
else
{
document.getElementById("mailIdError1").innerHTML="E-mail id not valid";
document.getElementById("mailIdError1").style.color="red";
}
}
else
{
document.getElementById("mailIdError1").innerHTML="E-mail id not valid";
document.getElementById("mailIdError1").style.color="red";

}
}
else
{
document.getElementById("mailIdError1").innerHTML="E-mail id not valid";
document.getElementById("mailIdError1").style.color="red";
}
}
else
{
document.getElementById("mailIdError1").innerHTML="E-mail id not valid";
document.getElementById("mailIdError1").style.color="red";
}

}
//script for password validation1

function passWordValidation1(p)
{ var flag=0;
var a=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
for(var i=0;i<a.length;i++)
{
if(p.charAt(0)==a[i])
{
if(p.charAt(p.length-1)!='@' && p.charAt(p.length-1)!='#' && p.charAt(p.length-1)!='$' && p.charAt(p.length-1)!='&' && p.charAt(p.length-1)!='*' && p.charAt(p.length-1)!='%')
{
flag=1;
}
}
}
if(flag==1)
{
document.getElementById("passWordError1").innerHTML="";

}
else
{
document.getElementById("passWordError1").innerHTML="password is not valid(1st Letter should capital& Last letter should not symbol)";
document.getElementById("passWordError1").style.color="red";
}
}

function myMap() {
var mapOptions = {
center: new google.maps.LatLng(17.5002218, 78.3939508),
zoom: 10,

mapTypeId: google.maps.MapTypeId.HYBRID
}
var map = new google.maps.Map(document.getElementById("map"), mapOptions);
}
//script for Amount validation
function amountValidation(number)
{
var flag=0;
var a=[0,1,2,3,4,5,6,7,8,9];
if(number.charAt(0)==9 || number.charAt(0)==8 || number.charAt(0)==7|| number.charAt(0)==6|| number.charAt(0)==5|| number.charAt(0)==4|| number.charAt(0)==3|| number.charAt(0)==2|| number.charAt(0)==1)
{
flag=flag+1;
for(var i=1;i<number.length;i++)
{
for(var j=0;j<a.length;j++)
{
if(number.charAt(i)==a[j])
{
flag=flag+1;
console.log(flag);
break;
}
}
}
}
if(flag==10)
{
document.getElementById("amountError").innerHTML="";
}
else
{
document.getElementById("amountError").innerHTML="Mobile number is not valid";
document.getElementById("amountError").style.color="red";
}
}

//script for sign up and sign in pages slide show



$(document).ready(function(){
$("#signupbtn").click(function(){
$("#form1").show(1000);
$("#form2").hide(1000);
});
});
$(document).ready(function(){
$("#signinbtn").click(function(){
$("#form2").show(1000);
$("#form1").hide(1000);
});
});