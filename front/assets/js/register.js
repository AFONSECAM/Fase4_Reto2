function postUserData(){
    var email =  $("#email").val();
    var password = $("#password").val();
    var repassword = $("#repassword").val();
    if(validateEmail(email)){
        if(validarPassword(password, repassword)){
            var data = {
                identification : $("#identification").val(),
                name : $("#name").val() + " " + $("#lastname").val(),        
                address : $("#address").val(),
                cellPhone : $("#cellPhone").val(),
                email : email,
                password : password,        
                zone : $("#zone").val(),
                type : $("#type").val()
            }
            $.ajax({
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify(data),
                url: "http://localhost:8080/api/user/new",
                type: "POST",
                success: function(response){
                    console.log(response);
                    alert("Usuario creado correctamente!");
                },
                error: function(xhr, status){
                    console.log(xhr);
                }
            }); 
        }
    }                 
}

function validarPassword(p1, p2){
    if(p1 != p2){
        alert("Las contraseñas no coinciden");
    }
}

function validateEmail(email) {
    var emailReg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return emailReg.test(email);
}