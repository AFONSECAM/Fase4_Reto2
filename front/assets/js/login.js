function login(){
    var email = $("#email").val();
    let password = $("#password").val();
    $.ajax({
        type: "GET",
        url: "http://158.101.116.78:8080/api/user/"+ email +"/"+ password,
        dataType: "JSON",
        success: function(response){
            mensaje(response);
        },
        error: function(xhr, status){
            console.log(status)
        }
    });
}

function mensaje(respuesta){
    if(respuesta.id == null){
        alert("Usuario no registrado!");
    }else{
        alert("Bienvenido " + user);
        window.location.href = './sections/admin/dash.html';
    }
}