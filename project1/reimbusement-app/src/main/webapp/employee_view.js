const submitButtonReimb = document.getElementById("employee_reimb_submit"); 

submitButtonReimb.addEventListener("click", function(event){
    
let reimb_type = document.getElementById("Reimbursement-type").value; //works as intended 
let reimb_amount = document.getElementById("reimbursement-amount").value; 
let reimb_receipt = document.getElementById("receipt").value;//need to research 
let reimb_descr = document.getElementById("reimb_desc").value
event.preventDefault(); 
console.log(reimb_type, reimb_amount, reimb_descr, reimb_receipt)
let formDataSubmitted = packageFormInput(reimb_type, reimb_amount, reimb_receipt,reimb_descr); //creates object from input values
console.log(formDataSubmitted);
let dataReady = packageReimbPostRequest(formDataSubmitted, state)
console.log("here is the data that will be sent for reimbursement submission " + dataReady)
})

function packageFormInput (reimb_type="Lodging", reimb_amount, reimb_recipt = null, reimb_desc){
    const reimb_types = [1,2,3,4]
    let r = reimb_type
    let reimb_type_id; 
    //mapping value to id
    if(r === "Lodging") reimb_type_id = 1
    if(r === "Travel") reimb_type_id = 2
    if(r === "Food") reimb_type_id = 3
    if(r === "Other") reimb_type_id = 4
    return {
        reimb_type: reimb_type,
        reimb_amount: reimb_amount, 
        reimb_recipt: reimb_recipt,
        reimb_desc: reimb_desc, 
        reimb_type_id: reimb_type_id
    }
}

function packageReimbPostRequest(formData, currentSessionUser){
    return{
        reimb_type: formData.reimb_type,
        reimb_amount: formData.reimb_amount, 
        reimb_recipt: formData.reimb_recipt,
        reimb_desc: formData.reimb_desc, 
        reimb_type_id: formData.reimb_type_id, 
        reimb_author: currentSessionUser.user.id,
        reimb_status_id: 1
    }
}

function sendData(jsDataObject){
    //XHR method 
    let jsonData = JSON.stringify(jsDataObject);
    let xhr = new XMLHttpRequest(); 
    let url = "/reimbursement_submit"; 
    xhr.open("POST", url, true)

    xhr.setRequestHeader("Content-Type", "application/json")
    xhr.send(jsonData);
    let resultP = document.getElementsByClassName("result")
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            resultP.innerHTML = this.responseText;
        }
    }

}

const getUserInfoButton = document.getElementById("get-user-info");

getUserInfoButton.addEventListener('click', function(event){
    console.log("clicked")
})

const getUserInfo = async function getInfo(){
            let data = await fetch("http://localhost:8080/reimbursement-app/getEmployeeInfo")
            .then(Response => Response.json())
            try{
                userData = JSON.parse(data)
            } catch(e){
                userData = data
            }
            state.user = userData
        }

const logoutButton = document.getElementById("logout");
logoutButton.addEventListener("click", function(event){
    console.log("logout button was clicked")
      function invalidate(){
        fetch("http://localhost:8080/reimbursement-app/logout",{
             method: "POST"

         }); 
        state.user = null;  
       console.log("the invalidate servlet was called to invalidat1e session, you should be redirected to home page")
       location.href='http://localhost:8080/reimbursement-app/'
    }
    invalidate(); 
})

//handles state of the user session, got data from getInfo() function; 
//TODO update html page to fetch user data upon loading document
let state = {
    user: null
}


const stateButton = document.getElementById("check-user-state")
//for debugging purposes
stateButton.addEventListener("click", function(event){
    console.log(state.user)
})

window.onload = getUserInfo;