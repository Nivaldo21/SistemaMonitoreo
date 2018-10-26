$(document).ready(function(){
  //SELECCIONAR TODOS LOS ROWS
  $('#cbGen').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbSelec').prop('checked',true);
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
    }
  });

});

//EVENTO DEL ICONO DE EDITAR EN EL ARCHIVO
$('.ico-edit').on('click', function(){
  //PRIMERO SE BORRAN LOS DIVS POR SI HAY RECIDUOS DE OTRO MODAL
  $('#titleName').remove();
  $('#bodyEdit').remove();

  //OBTENEMOS LOS PARAMETROS
  var id = $(this).attr('id');//ID DEL ROW
  id = parseInt(id); //CONVERTIR A INTEGER
  var valor = $(this).attr('value'); //VALORES DEL ROW (NOMBRE, TIPO, DURACION)
  valor = valor.toString();//CONVERTIMOS EN CADENA
  var str = valor.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
  var nombre = str[0];//NOMBRE
  var tipo = str[1];//TIPO
  var duracion = str[2];//DURACION
  duracion = parseInt(duracion);//DURACIÓN ES INTEGER

  $('#modalEditarArchivo').modal('show');//ABRIMOS EL MODAL
  //SE ESCRIBE EL CONTENIDO DEL MODAL, JUNTO CON LOS INPUTS, LABELS, ETC
  $('#titleModal').append('<h5 class="modal-title" id="titleName">Editar '+ nombre +'</h5> ');
  $('#modal-body').append('<div id="bodyEdit">'
  //INPUT HIDDEN CON EL VALOR DEL ID
     +'<input type="hidden" id="id" name="id" value="'+id+'" />'
       + '<div class="col-sm-12 row d-flex justify-content-start align-items-center mt-3 mb-2">'
          +'<label for="duracion" class="col-sm-3 form-control-label">Duración:</label>'
          +'<input class="form-control col-sm-4" id="duracion" placeholder="Segundos" type="number" name="duracion" required="required">'
       +'</div>'
  + '</div>');

  //LES DAMOS VALORES A LOS INPUTS PARA FACILITAR AL USUARIO
  $('#duracion').val(duracion);

});

//EVENTO DEL ICONO DE BORRAR EN EL ARCHIVO
$('.ico-del').on('click', function(){
  //PRIMERO SE BORRAN LOS DIVS POR SI HAY RECIDUOS DE OTRO MODAL
  $('#titleNameDel').remove();
  $('#bodyDel').remove();

  //OBTENEMOS LAS VARIABLES DEL ROW
  var id = $(this).attr('id');
  var name = $(this).attr('name');

  //ABRIMOS EL MODAL
  $('#modalBorrarArchivo').modal('show');
  //SE ESCRIBE EL CONTENIDO DEL MODAL
  $('#titleModalDel').append('<h5 class="modal-title" id="titleNameDel">Borrar '+ name +'</h5> ');
  $('#modal-bodyDel').append('<div id="bodyDel">'
  + '<h2 class="text-center">¿Estás seguro de borrar el archivo ' + name + '?</h2>'
  + '</div>');
  //INPUT HIDDEN CON EL VALOR DEL ID (EL QUE SERÁ ENVIADO POR AJAX)
  $('#DelFile').append('<input type="hidden" id="id" name="id" value="'+id+'" />')

  //var url = '<c:url value="Delete_File.htm?id='+id+'" />'
  //$('#borrarArchivo').attr("href",url);
});