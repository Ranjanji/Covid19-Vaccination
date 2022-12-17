// opening and closing the form
function openCloseform(x){
    document.getElementById(x).classList.toggle('formCnt');
    document.querySelector('body').classList.toggle('stopScroll');
}


// Appending vaccine detail table
vaccDetail();
function vaccDetail(){

    // fetching the data

    // appending the data

    document.getElementById("vaccDet").innerHTML=null;

   let arrVaccDetail = [
    {
        "vaccID":1,
        "vaccName":"covidShild",
        "description":"Inauntated",
        "price":300
    },
    {
        "vaccID":2,
        "vaccName":"covidShild",
        "description":"Inauntated",
        "price":700
    },
    {
        "vaccID":3,
        "vaccName":"covidShild",
        "description":"Inauntated",
        "price":450
    },
    {
        "vaccID":4,
        "vaccName":"covidShild",
        "description":"Inauntated",
        "price":200
    }
   ];


   for(i=0; i<arrVaccDetail.length; i++){
    let row = '<tr><td>' + Number(i+1) + '</td><td>' +
     arrVaccDetail[i].vaccName + '</td><td>' + arrVaccDetail[i].description + '</td><td>' +
     arrVaccDetail[i].price + '</td><td onclick="deleteVacc('+arrVaccDetail[i].vaccID+')">' + "Delete" + '</td></tr>';

    document.getElementById("vaccDet").innerHTML+=(row);

   }

}

// deleting the vaccine
function deleteVacc(id){
    console.log(id);
}

// appendig the center data
centerDetail();
function centerDetail(){

    // fetching upi

    // appending to detail

    document.getElementById("centDet").innerHTML=null;
    let arrCenterDet = [
        {
            'center_ID':1,
            'name':'ORN_Hospital',
            'city':'Karol Bagh',
            'state':'Delhi',
            'pincode':12354,
        },

        {
            'center_ID':2,
            'name':'ORN_Hospital',
            'city':'Karol Bagh',
            'state':'Delhi',
            'pincode':12354,
        },

        {
            'center_ID':2,
            'name':'ORN_Hospital',
            'city':'Karol Bagh',
            'state':'Delhi',
            'pincode':12354,
        },

        {
            'center_ID':2,
            'name':'ORN_Hospital',
            'city':'Karol Bagh',
            'state':'Delhi',
            'pincode':12354,
        },

        {
            'center_ID':2,
            'name':'ORN_Hospital',
            'city':'Karol Bagh',
            'state':'Delhi',
            'pincode':12354,
        },
    ];

    for(i=0; i<arrCenterDet.length; i++){

        let row = '<tr><td>' + Number(i+1) + '</td><td>' +
        arrCenterDet[i].name + '</td><td>' + arrCenterDet[i].city + '</td><td>' +
        arrCenterDet[i].state +'</td><td>' + arrCenterDet[i].pincode + 
        '</td><td onclick="showInventory('+arrCenterDet[i].center_ID+')">' + 
        "Show Inventory" + '</td><td onclick="deleteCenter('+arrCenterDet[i].center_ID+')">'+ "Delete" + '</td></tr>';
   
        document.getElementById("centDet").innerHTML+=(row);
    }

}

// showing center
function showInventory(centerId){
    openCloseform('inventoryDisplay');
}

// delteing the cneter
function deleteCenter(centerID){
    alert(centerID+ " deleted");
}


// adding the vaccine
let addVaccine = document.querySelector("#addVacc>form");

addVaccine.addEventListener(onsubmit, function(){
    event.preventDefault();

    let Obj = {
        'name':addVaccine.name.value,
        'price':addVaccine.price.value
    }


})