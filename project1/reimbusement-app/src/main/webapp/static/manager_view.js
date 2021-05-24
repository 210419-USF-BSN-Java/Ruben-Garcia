const getUserInfoButton = document.getElementById("get-user-info");

getUserInfoButton.addEventListener('click', function(event){
    //userloggedin
    console.log("clicked")
    let userData;
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/getEmployeeInfo")
         .then(Response => Response.json())
        try{
            userData = JSON.parse(data)
        } catch(e){
            userData = data
        }

        console.log(userData)
    }
    getInfo();
})

const logoutButton = document.getElementById("logout");
logoutButton.addEventListener("click", function(event){
    console.log("logout button was clicked")
      function invalidate(){
        fetch("http://localhost:8080/reimbursement-app/logout",{
             method: "POST"

         }); 
       console.log("the invalidate servlet was called to invalidat1e session, you should be redirected to home page")
       location.href='http://localhost:8080/reimbursement-app/'
    }
    invalidate(); 
})

let employeeHeaders = ["First Name", "Last Name", "Username", "UserType"];
tableDiv = document.getElementById("list-of-employees"); 
getAllEmployeeList = document.getElementById("get-all-employees")
getAllEmployeeList.addEventListener("click", function(event){
    let list; 
    console.log("get all employees endpoint fetched")
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/getAllEmployee")
         .then(Response => Response.json())
        try{
            list = JSON.parse(data)
        } catch(e){
            list  = data
        }

        console.log(list)
    }
    getInfo();
})

getAllPendingRequests = document.getElementById("view-all-pending-requests")
getAllPendingRequests.addEventListener("click", function(event){
    let list; 
    console.log("get all pending requests endpoint called")
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/getAllPendingRequests")
         .then(Response => Response.json())
        try{
            list = JSON.parse(data)
        } catch(e){
            list  = data
        }

        console.log(list)
    }
    getInfo();
})


getAllResolvedRequests = document.getElementById("view-all-resolved-requests")
getAllResolvedRequests.addEventListener("click", function(event){
    let list; 
    console.log("get all resolved requests endpoint called")
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/getAllResolvedRequests")
         .then(Response => Response.json())
        try{
            list = JSON.parse(data)
        } catch(e){
            list  = data
        }

        console.log(list)
    }
    getInfo();
})

//fetch method for updating ticket
/*
updateTicketButton = document.getElementById("update-ticket-submit")
getAllResolvedRequests.addEventListener("click", function(event){
    let list; 
    console.log("post request for updating a pending ticket issued")
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/reimbursement_resolve", {
             bo
             method: "Post", 
             headers: {
                 "Content-type": "application/json; charset=UTF-8"
             }
         }
         )
        

        console.log(list)
    }
    getInfo();
})
*/