function registerUser(){
    let email = $("#email").val(),
        password = $("#password").val(),
        repassword = $("#repassword").val();
    if(validateEmail(email)){
        if(validarPassword(password,repassword)){
            let data = {
                identification : $("#identification").val(),
                name : $("#name").val(),
                lastname : $("#lastname").val(),
                address : $("#address").val(),
                cellPhone : $("#cellPhone").val(),
                email : email,
                password : password,
                repassword : repassword,
                zone : $("#zone").val(),
                type : $("#type").val()
            }

            let dataToSend = JSON.stringify(data);
            $.ajax({
                url: "http://158.101.116.78:8080/api/user/new",
                data: dataToSend,
                type: "POST",
                dataType: "application/JSON",
                contentType: "json",
                success: function(response){
                    alert("Usuario creado correctamente!");
                },
                error: function(xhr, status){
                    console.log(status);
                }
            });
        };        
    };                
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