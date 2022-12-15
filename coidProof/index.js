// opening and closing the form
function openCloseform(x){
    document.getElementById(x).classList.toggle('formCnt');
}


// login
let loginForm = document.querySelector('#login>form');

loginForm.onsubmit = function(){
    window.location.href = 'profile.html';
}

// registration
let regiForm = document.querySelector('#registration>form');

regiForm.onsubmit = function(){
    alert("successfull");
}


// Admin login
let adminForm = document.querySelector('#admin>form');

adminForm.onsubmit = function(){
    alert("successfull");
}