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
        console.log(typeof list)
        let temp = ""
        let roleName; 
        if (list.userRoleId = 1)roleName = "Manager"
        if(list.userRoleId = 2) roleName = "Employee"

        if(list.length >0){
            list.forEach(element => {
                temp += "<tr>";
                temp += "<td>"+ element.id+"</td>"
                temp += "<td>"+ element.username+"</td>"
                temp += "<td>"+ element.firstName +"</td>"
                temp += "<td>"+ element.lastName +"</td>"
                temp += "<td>"+ element.email+"</td>"
                temp += "<td>" + roleName+ "</td>"
                temp += "</tr>"
            }) 
            document.getElementById("all-employee-list-data").innerHTML = temp;
        }
    }
    getInfo();
    //comment
})

//fetch method for updating ticket

updateTicketButton = document.getElementById("update-ticket-submit")
updateTicketButton.addEventListener("click", function(event){
    event.preventDefault();
    console.log("submit ticket update event listener clicked")
    let reimId = document.getElementById("ticket-id").value
    let updateStatusInput = document.querySelector('input[name="request-decision"]:checked').value;
    let jsdata = packageUpdateTicket(reimId, updateStatusInput)
    console.log(updateStatusInput + " string value for status update paramater")
    console.log(reimId + " id that was updated")
    console.log(jsdata + "js object sent to post request for updating a pending ticket issued; parsed as json")
    sendData(jsdata); 
})

function sendData(jsObject){
    sendPostRequest(jsObject)
}

 const sendPostRequest = async function updateTicket(data){
        try{
             fetch("http://localhost:8080/reimbursement-app/reimbursement_resolve", {
             method: "Post",
             body: JSON.stringify(data), 
             headers: {
                 "Content-type": "application/json; charset=UTF-8"
             }
         }
         )
         .then(function(){
             console.log("ok")
         })
        
        }catch(e){
            console.log("error")
        } 
    }

function packageUpdateTicket(reimId, updateStatusInput ){
    console.log(reimId)
    console.log(updateStatusInput)
    let status; 
    console.log(status)
    if(updateStatusInput === "reject") status = 3 
    if(updateStatusInput === "accept") status = 2
    return {
        reimb_id: reimId, 
        reimb_status_id: status 
    }
}