const submitButtonReimb = document.getElementById("employee_reimb_submit"); 

submitButtonReimb.addEventListener("click", function(event){
    
let reimb_type = document.getElementById("Reimbursement-type").value; //works as intended 
let reimb_amount = document.getElementById("reimbursement-amount").value; 
//let reimb_receipt = document.getElementById("receipt").value;//need to research how to deserialize this for jackson api
let reimb_desc = document.getElementById("reimb_desc").value
event.preventDefault(); 
let formDataSubmitted = packageFormInput(reimb_type, reimb_amount,reimb_desc); //creates object from input values
console.log(formDataSubmitted);
let dataReady = packageReimbPostRequest(formDataSubmitted, state)
console.log("here is the data that will be sent for reimbursement submission " + dataReady)
sendData(dataReady); 

})

function packageFormInput (reimb_type="Lodging", reimb_amount, reimb_desc){
    const reimb_types = [1,2,3,4]
    let r = reimb_type
    let reimb_type_id; 
    //mapping value to id
    if(r === "Lodging") reimb_type_id = 1
    if(r === "Travel") reimb_type_id = 2
    if(r === "Food") reimb_type_id = 3
    if(r === "Other") reimb_type_id = 4
    return {
        reimb_amount: reimb_amount, 
        reimb_desc: reimb_desc, 
        reimb_type_id: reimb_type_id
    }
}
//packages object to mirror reimbursement model add(method needs)
function packageReimbPostRequest(formData, currentSessionUser){
    return{
        reimb_amount: formData.reimb_amount, 
        //reimb_recipt: formData.reimb_recipt,
        reimb_desc: formData.reimb_desc, 
        reimb_type_id: formData.reimb_type_id, 
        reimb_author: currentSessionUser.user.id,
        reimb_status_id: 1, 
        reimb_id: null,
        reimb_resolver: null 


    }
}

function sendData(jsDataObject){
    sendPostRequestReimbSub(jsDataObject);
    console.log("post request for form submission sent")
    //XHR method 
    /*
    let jsonData = JSON.stringify(jsDataObject);
    let xhr = new XMLHttpRequest(); 
    let url = "/reimbursement_submit"; 
    xhr.open("POST", url, true)

    xhr.setRequestHeader("Content-Type", "application/json")
    xhr.send(jsonData);
    let resultP = document.getElementById("result")
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            resultP.innerHTML = this.responseText;
        }else{
            resultP.innerHTML = "not 200 status"
        }
    }
    */


}

const sendPostRequestReimbSub = async function sendData(jsDataObject){
        try{
            fetch("http://localhost:8080/reimbursement-app/reimbursement_submit", {
                method: "Post",
                body: JSON.stringify(jsDataObject),
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            })
            .then(function(){
                console.log("ok")
            })
        }catch(e){
            console.log("error")
        }

        //add method to let user to let them  know submission was successful and clear form inputs 
            
    }


const getUserInfo = async function getInfo(){
        let userData;
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




let pendingReim; 
let resolvedReim; 
const viewPendingReimbursementsButton = document.getElementById("show-user-pending-reim")
viewPendingReimbursementsButton.addEventListener("click", function(event){
    console.log("pending viewPendingReimbursements funtion called"); 
    getUserPendingReimData()
})

const viewResolvedReimbursementsButton = document.getElementById("show-user-resolved-reim")
viewResolvedReimbursementsButton.addEventListener("click", function(event){
    console.log("resolved viewResolvedReimbursements funtion called"); 
    getUserResolvedReimbData()
})

const getUserResolvedReimbData = async function(){
    let data = await fetch("http://localhost:8080/reimbursement-app/getEmployeeResolvedRequest").then(Response => Response.json())
    .then(data => {
        let temp = ""
        let reimbType; 
        console.log(data)
        if(data.length > 0){
            data.forEach(element => {
                if(element.reimb_type_id === 1)reimbType="Lodging" 
                if(element.reimb_type_id === 2)reimbType="Travel"
                if(element.reimb_type_id === 3)reimbType="Food" 
                if(element.reimb_type_id === 4)reimbType="Other"        
                temp += "<tr>";
                temp += "<td>"+ element.reimb_id+"</td>"
                temp += "<td>"+ element.reimb_author+"</td>"
                temp += "<td>"+ element.reimb_amount +"</td>"
                temp += "<td>"+ element.reimb_desc +"</td>"
                temp += "<td>"+ reimbType+"</td>"
                temp += "<td>" + `${new Date(element.reimb_submitted)}` +"</td>"
                temp += "<td>" + `${new Date(element.reimb_resolved)}` +"</td>"
                temp += "<td>" + element.reimb_resolver +"</td>"
                temp += "</tr>"
            }) 
            console.log(temp)
            let new_tbody = document.createElement('tbody')
            new_tbody.setAttribute('id', "user-resolved-reim-data")
            new_tbody.innerHTML = temp; 
            let old_tbody = document.getElementById("user-resolved-reim-data");
            old_tbody.parentNode.replaceChild(new_tbody, old_tbody)
        }
    })
}

const getUserPendingReimData = async function getPendingRequest(){
            let data = await fetch("http://localhost:8080/reimbursement-app/getEmployeePendingRequest")
            .then(Response => Response.json())
            .then(data => {
                console.log(data)
                let temp = ""
        let reimbType; 
        console.log(data)
        if(data.length > 0){
            data.forEach(element => {
                if(element.reimb_type_id === 1)reimbType="Lodging" 
                if(element.reimb_type_id === 2)reimbType="Travel"
                if(element.reimb_type_id === 3)reimbType="Food" 
                if(element.reimb_type_id === 4)reimbType="Other"        
                temp += "<tr>";
                temp += "<td>"+ element.reimb_id+"</td>"
                temp += "<td>"+ element.reimb_author+"</td>"
                temp += "<td>"+ element.reimb_amount +"</td>"
                temp += "<td>"+ element.reimb_desc +"</td>"
                temp += "<td>"+ reimbType+"</td>"
                temp += "<td>" + `${new Date(element.reimb_submitted)}` +"</td>"
                temp += "</tr>"
            }) 
            let new_tbody = document.createElement('tbody')
            new_tbody.setAttribute('id', "user-pending-reim-data")
            new_tbody.innerHTML = temp; 
            let old_tbody = document.getElementById("user-pending-reim-data");
            console.log("new table data" +new_tbody)
            console.log("old table data" + old_tbody)
            old_tbody.parentNode.replaceChild(new_tbody, old_tbody)
        }

            })
            
    }

   const editInfoForm = document.getElementById("edit_user_submit"); 
   editInfoForm.addEventListener("click",function(event){
        let firstName = document.getElementById("edit-first-name").value; 
        let lastName = document.getElementById("edit-last-name").value;
        let email = document.getElementById("edit-email").value; 
        let password = document.getElementById("edit-password").value; 
        let jsData = packageEditUserInfo(firstName, lastName, email, password)
        console.log(jsData)
        sendPostRequestUpdateUserInfo(jsData)
   })
   
   function packageEditUserInfo(firstName, lastName, email, password){
       return {
           firstName: firstName, 
           lastName: lastName, 
           email: email, 
           password: password
       }
   }

   const sendPostRequestUpdateUserInfo = async function sendData(jsDataObject){
        try{
            fetch("http://localhost:8080/reimbursement-app/UpdateUserInfo", {
                method: "Post",
                body: JSON.stringify(jsDataObject),
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            })
            .then(function(){
                console.log("ok")
            })
        }catch(e){
            console.log("error")
        }

        //add method to let user to let them  know submission was successful and clear form inputs 
            
    }


    //toggle function 

    function toggleHide(elementId){
        let element = document.getElementById(elementId); 
        element.classList.toggle("hide");
    }
    
    //handles state of the user session, got data from getInfo() function; 
//TODO update html page to fetch user data upon loading document
let state = {
    user: null
}

//this get user's info upon logging in
    window.onload = function onloadInit(){
        getUserInfo();
        //getUserPendingReimData()
        //getUserResolvedReimbData()
    }