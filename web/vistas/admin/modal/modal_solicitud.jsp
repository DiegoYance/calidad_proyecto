<%-- 
    Document   : modal_solicitud
    Created on : 26/05/2019, 02:37:24 AM
    Author     : Diego Yance
--%>

 <!-- Modal -->
<div class="modal fade" id="modal_solicitud" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Solicitud de modificacion de disponibilidad</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Desea poder habilitar la modificación de la disponibilidad del docente?
            </div>
            <div class="modal-footer">
                <form method="POST" action="Controlador">
                 
                <button type="submit" class="btn btn-primary" name="accion" value="aceptar_edit">Aceptar</button>
                <button type="submit" class="btn btn-primary" name="accion" value="negar_edit" data-dismiss="modal">Negar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>      
                </form>
            </div>
        </div>
     </div>
</div>
