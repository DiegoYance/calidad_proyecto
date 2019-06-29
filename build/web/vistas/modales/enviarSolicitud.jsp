<div class="modal fade" id="modal_enviar_solicitud" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
      <div class="modal-content" style="color: #212428">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Enviar Solicitud al Administrador para editar Disponibilidad</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
          <form action="Controlador">
      <div class="modal-body">
        
          <div class="form-group">
            <label for="message-text" class="col-form-label">Motivo de solicitud para la edición:</label>
            <textarea name="motivo" class="form-control" id="message-text" style="height: 140px;"></textarea>
          </div>
      </div>
      <div class="modal-footer"> 
          
        <button type="submit" class="btn btn-secondary" name="accion" value="celdas">Enviar</button>
        <button type="button" class="btn btn btn-primary" data-dismiss="modal">Cancelar</button>
      </div>
      </form>

    </div>
  </div>
</div>