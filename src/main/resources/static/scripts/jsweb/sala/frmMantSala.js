$(document).on("click", "#btnagregar", function(){
    $("#txtdescsala").val("");
    $("#txtnroasientos").val("");
    $("#hddidsala").val("0");
    $("#cboestado").empty();
    $.ajax({
        type: "GET",
        url: "/Estado/listarEstados",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboestado").append(
                    `<option value="${value.idestado}">${value.descestado}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtdescsala").val($(this).attr("data-descsala"));
    $("#txtnroasientos").val($(this).attr("data-asientos"));
    $("#hddidsala").val($(this).attr("data-idsala"));
    $("#cboestado").empty();
    var idestado = $(this).attr("data-idestado");
    $.ajax({
        type: "GET",
        url: "/Estado/listarEstados",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboestado").append(
                    `<option value="${value.idestado}">${value.descestado}</option>`
                )
            })
            $("#cboestado").val(idestado);
        }
    })
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/Sala/registrarSala",
        contentType: "application/json",
        data: JSON.stringify({
            idsala: $("#hddidsala").val(),
            descsala: $("#txtdescsala").val(),
            asientos: $("#txtnroasientos").val(),
            idestado: $("#cboestado").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarSala();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function ListarSala(){
    $.ajax({
        type: "GET",
        url: "/Sala/listarSalas",
        dataType: "json",
        success: function(resultado){
            $("#tblsala > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblsala > tbody").append("<tr>"+
                    "<td>"+value.idsala+"</td>"+
                    "<td>"+value.descsala+"</td>"+
                    "<td>"+value.asientos+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idsala='"+value.idsala+"'"+
                                     "data-descsala='"+value.descsala+"'"+
                                     "data-asientos='"+value.asientos+"'"+
                                     "data-idestado='"+value.idestado+"'>Actualizar</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-idsala='"+value.idsala+"'"+
                                     "data-descsala='"+value.descsala+"'>Eliminar</button>"+
                    "</td></tr>");
            })
        }
    })
}