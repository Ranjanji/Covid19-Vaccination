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
        'dob': loginForm.Dob.value
    }

    const logInApplicant = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/user/login', options)
        let response = await p.json()
        console.log(response);
        return response
    };

    if(logInApplicant!=null){
        alert("Login Sucessfull");
        window.location.href="profile.html";
    }else{
        alert("Invalid Username Or Password");
    }

}

// registration
let regiForm = document.querySelector('#registration>form');

regiForm.onsubmit = function(){
     let Obj = {
        'name':regiForm.name.value,
        'dob':regiForm.Dob.value,
        'gender':regiForm.gender.value,
        'address':regiForm.address.value,
        'mobile':regiForm.mobile.value,
        'city':regiForm.city.value,
        'state':regiForm.state.value,
        'pincode':regiForm.pincode.value,
        'adharCard':{
            'mobile':regiForm.mobile.value,
             'adNo':regiForm.adharCard.value
        },
        'pancard':{
            'panNumber':regiForm.pancard.value
        }
    }

    const registerApplicant = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/user/register/'+regiForm.adharCard.value, options)
        let response = await p.json()
        console.log(response);
        return response
    }

    // registration successfull alert
    if(registerApplicant!=null){
        alert("Applicant Registered Sucessfully");
    }else{
        alert("Applicant Registration Failed!!!");
    }
}


// Admin login
let adminForm = document.querySelector('#admin>form');

adminForm.onsubmit = function(){
    event.preventDefault();
    let Obj = {
        'mobile':adminForm.mobile.value,
        'password':adminForm.password.value
    }

    const logInAdmin = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/admin/login', options)
        let response = await p.json()
        console.log(response);
        return response
    }

    if(logInAdmin!=null) {
        alert("Login Successfull");
        window.location.href = "admin.html";
    }else{
        alert("Invalid Username Or Password!!!");
    }
}

// Admin Registration
let adminRegi = document.querySelector('#adminRegi>form');

adminRegi.onsubmit = function(){
    event.preventDefault();
    let Obj = {
        'name':adminRegi.name.value,
        'mobile':adminRegi.mobile.value,
        'password':adminRegi.password.value
    }

    const registerAdmin = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/admin/register', options)
        let response = await p.json()
        console.log(response);
        return response
    }

    if(registerAdmin!=null){
        alert("Admin Registered Sucessfully");
    }else{
        alert("Admin Registration Failed!!!");
    }
    // window.location.href = "admin.html"
}