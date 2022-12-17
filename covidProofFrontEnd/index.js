// opening and closing the form
function openCloseform(x){
    document.getElementById(x).classList.toggle('formCnt');
}


// login
let loginForm = document.querySelector('#login>form');

loginForm.onsubmit = function(){
    event.preventDefault();

    let Obj = {
        'mobile': loginForm.mobile.value,
        'DOb': loginForm.Dob.value
    }

    fetch('https://reqbin.com/echo/post/json', {
    method: 'POST',
    body: JSON.stringify(Obj)
    })
    .then(response => response.json())
    .then(response => console.log(JSON.stringify(response)));

}

// registration
let regiForm = document.querySelector('#registration>form');

regiForm.onsubmit = function(){
     let Obj = {
        'name':regiForm.name.value,
        'DateOfBirth':regiForm.Dob.value,
        'gender':regiForm.gender.value,
        'address':regiForm.address.value,
        'city':regiForm.city.value,
        'state':regiForm.state.value,
        'pincode':regiForm.pincode.value,
        'adharCard':regiForm.adharCard.value,
        'pancard':regiForm.pancard.value
    }

    fetch('https://reqbin.com/echo/post/json', {
    method: 'POST',
    body: JSON.stringify(Obj)
    })
    .then(response => response.json())
    .then(response => console.log(JSON.stringify(response)));

    // registration successfull alert
}


// Admin login
let adminForm = document.querySelector('#admin>form');

adminForm.onsubmit = function(){
    event.preventDefault();
    let Obj = {
        'mobile':adminForm.mobile.value,
        'password':adminForm.password.value
    }

    // window.location.href = "admin.html"
}

const getapi=()=>{
    fetch("http://localhost:8880/admin/vaccinecenter").then(response=>response.json()).then(a=>console.log(a));
}
getapi();