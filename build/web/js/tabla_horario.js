/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function seleccionarCelda(fila, columna) {
                    
    var colorID = document.getElementById(fila + '_' + columna);
                    
    if(!colorID.classList.contains('celda_activa')){
        colorID.classList.add('celda_activa');
    }else{
        colorID.classList.remove('celda_activa');
    }
} 

function ObtenerCeldasSeleccionadas(){
                
    // concatenando celdas pintadas en verde
    var color_id;
    var celdasPintadas = "";
    
    for(var i=8; i<=21; i++){
        for(var j=1; j<=7; j++){
            color_id = document.getElementById(i + '_' + j);
            if(color_id.classList.contains('celda_activa')){
                celdasPintadas += (i + '_' + j) + ',';                            
            }   
        }
    }
    
    return celdasPintadas;  
                            
}

function ObtenerCantidadCeldasSeleccionadas(){
                
    // concatenando celdas pintadas en verde
    var color_id;
    var cantidadCeldasPintadas = 0;
    
    for(var i=8; i<=21; i++){
        for(var j=1; j<=7; j++){
            color_id = document.getElementById(i + '_' + j);
            if(color_id.classList.contains('celda_activa')){
                cantidadCeldasPintadas++;
            }   
        }
    }
    
    return cantidadCeldasPintadas;  
                            
}

function UnaHoraPorDia(){
                
    var cantCeldasPintadasPorDia = 0;
    var color_id, color_id2, color_id3;
    
    // recorrido por columnas
    for(var j=1; j<=7; j++){
        for(var i=8; i<=21; i++){
            color_id = document.getElementById(i + '_' + j);
            
            // en la hora 8 no se verifica que la hora anterior este seleccionada
            if(i === 8){ 
                if(color_id.classList.contains('celda_activa')){
                    cantCeldasPintadasPorDia++;
                    color_id2 = document.getElementById((i+1) + '_' + j);
                    if(!color_id2.classList.contains('celda_activa')){
                        return true;
                    }
                }  
            }
            // en la hora 21 no se verifica que la hora siguiente este seleccionada
            else if(i === 21){
                if(color_id.classList.contains('celda_activa')){
                    cantCeldasPintadasPorDia++;
                    color_id2 = document.getElementById((i-1) + '_' + j);
                    if(!color_id2.classList.contains('celda_activa')){
                        return true;
                    }
                }  
            }
            /* en horas diferente a los extremos (8 y 21) se debe verificar que
             * una hora antes o después esten seleccionados, al menos uno de
             * esos debe estar seleccionado para verificar que no haya una sola
             * hora suelta seleccionada.
             */
            else{
                if(color_id.classList.contains('celda_activa')){
                    cantCeldasPintadasPorDia++;
                    color_id2 = document.getElementById((i-1) + '_' + j);
                    color_id3 = document.getElementById((i+1) + '_' + j);
                    if(!color_id2.classList.contains('celda_activa') &&
                            !color_id3.classList.contains('celda_activa')){
                        return true;
                    }
                }  
            }
        }
        if(cantCeldasPintadasPorDia === 1){
            return true;
        }else{
           cantCeldasPintadasPorDia = 0; 
        }
    }
    
    return false;
                            
}


function validarCursosRepetidos(){
    // BUSCAR CURSOS REPETIDOS DE LA MISMA ESCUELA 
        var n = 4, i, j, it, cursosRepetidos = false;
        for(i=1; i<=n-1; i++){
            it = i;
            for(j=it+1; j<=n; j++){
                if($("#idSelectEscuela" + it).val() === $("#idSelectEscuela" + j).val()){
                    if($("#idSelectCurso" + it).val() === $("#idSelectCurso" + j).val()){
                        cursosRepetidos = true;
                        return cursosRepetidos;
                    }
                }
            }
        }
        
        return cursosRepetidos;
}



 /**********************  SELECT  **************************/
    
    // SELECT 1
    $(document).ready(function(){
        // select 1
        recargarLista1();
                
        $('#idSelectEscuela1').change(function(){
            recargarLista1();
        });
    });
        
    function recargarLista1(){
        $.ajax({
            type:"POST",
            url: "vistas/ajax/ajax_select1.jsp",
            data: "idEscuela=" + $('#idSelectEscuela1').val(),
            success:function(r){
                $('#divSelectCurso1').html(r); 
            }
        });
    }
    
    // SELECT 2
    $(document).ready(function(){
        // select 1
        recargarLista2();
                
        $('#idSelectEscuela2').change(function(){
            recargarLista2();
        });
    });
        
    function recargarLista2(){
        $.ajax({
            type:"POST",
            url: "vistas/ajax/ajax_select2.jsp",
            data: "idEscuela=" + $('#idSelectEscuela2').val(),
            success:function(r){
                $('#divSelectCurso2').html(r); 
            }
        });
    }
    
    // SELECT 3
    $(document).ready(function(){
        // select 1
        recargarLista3();
                
        $('#idSelectEscuela3').change(function(){
            recargarLista3();
        });
    });
        
    function recargarLista3(){
        $.ajax({
            type:"POST",
            url: "vistas/ajax/ajax_select3.jsp",
            data: "idEscuela=" + $('#idSelectEscuela3').val(),
            success:function(r){
                $('#divSelectCurso3').html(r); 
            }
        });
    }
    
    // SELECT 4
    $(document).ready(function(){
        // select 4
        recargarLista4();
                
        $('#idSelectEscuela4').change(function(){
            recargarLista4();
        });
    });
        
    function recargarLista4(){
        $.ajax({
            type:"POST",
            url: "vistas/ajax/ajax_select4.jsp",
            data: "idEscuela=" + $('#idSelectEscuela4').val(),
            success:function(r){
                $('#divSelectCurso4').html(r); 
            }
        });
    }
    
    
 /**********************  FIN DE SELECT  **************************/


