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

//view all resolved requests
getAllResolvedRequests = document.getElementById("get-all-resolved-requests")
getAllResolvedRequests.addEventListener("click", function(event){
    event.preventDefault();
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
        document.getElementById("all-resolved-reimrequest-data").innerHTML = "";
        console.log(list)
         let temp = ""
        let reimbType; 
        console.log(list)
        if(list.length > 0){
            list.forEach(element => {
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
            console.log(temp)
            document.getElementById("all-resolved-reimrequest-data").innerHTML = temp;
        }
    }
    getInfo();
})

//view all pending requests
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
         let temp = ""
        let reimbType; 
        console.log(list)
        if(list.length > 0){
            list.forEach(element => {
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
            console.log(temp)
            let new_tbody = document.createElement('tbody')
            new_tbody.setAttribute('id', 'all-pending-reim-data')
            new_tbody.innerHTML = temp; 
            let old_tbody = document.getElementById("all-pending-reim-data");
            old_tbody.parentNode.replaceChild(new_tbody, old_tbody)
        }
    }
    getInfo();
})


//view all employees
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