const getUserInfoButton = document.getElementById("get-user-info");

getUserInfoButton.addEventListener('click', function(event){
    console.log("clicked")
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