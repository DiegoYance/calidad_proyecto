<%
    
    String categoria = "";
    int horasCategoria = Integer.parseInt(request.getParameter("horasCategoria"));
    if(horasCategoria == 20){
        categoria = "Tiempo Parcial";
    }else if(horasCategoria == 40){
        categoria = "Tiempo Completo";
    }
%> 

<!-- Modal -->
<div id="modal_validarHoras" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Cantidad de Horas Mínimas Inválido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Llene la cantidad de horas según su categoría
                </br>
                ( <%=categoria%> : <%=horasCategoria %> horas)
            </div>
            <div class="modal-footer">
    
                <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
                            
            </div>
        </div>
     </div>
</div>