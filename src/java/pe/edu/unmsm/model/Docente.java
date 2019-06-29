
package pe.edu.unmsm.model;

public class Docente extends Usuario{
    
    // Datos del Docente
    private int idDocente;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;
    private int restriccion;
    
    // Categoría del Docente
    private int idCategoria;
    private String nombreCategoria;
    private int horasMin;
    private int horasMax;
    
    // Celdas elegidas por el Docente
    private String celdasElegidas;

    public Docente() {
        
    }

    public Docente(String codigo, String password, int nivelUsuario) {
        super(codigo, password, nivelUsuario);
    }

    public Docente(String codigo, String password) {
        super(codigo, password);
    }
    
     public Docente(int idDocente, String codigo, String nombres, String apPaterno, String apeMaterno) {
        super(codigo);
        this.idDocente = idDocente;
        this.nombres = nombres;
        this.apePaterno = apPaterno;
        this.apeMaterno = apeMaterno;
    }

    public Docente(String codigo, String password, int idDocente
            , String apePaterno, String apeMaterno, String nombres
            , int restriccion, int idCategoria) {
        super(codigo, password);
        this.idDocente = idDocente;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.restriccion = restriccion;
        this.idCategoria = idCategoria;
    }
    
    public Docente(String codigo, String password, int idDocente
            , String apePaterno, String apeMaterno, String nombres
            , int restriccion, int idCategoria, String nombreCategoria
            , int horasMin, int horasMax) {
        
        super(codigo, password);
        this.idDocente = idDocente;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.restriccion = restriccion;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.horasMin = horasMin;
        this.horasMax = horasMax;
        
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(int restriccion) {
        this.restriccion = restriccion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getHorasMin() {
        return horasMin;
    }

    public void setHorasMin(int horasMin) {
        this.horasMin = horasMin;
    }

    public int getHorasMax() {
        return horasMax;
    }

    public void setHorasMax(int horasMax) {
        this.horasMax = horasMax;
    }

    public String getCeldasElegidas() {
        return celdasElegidas;
    }

    public void setCeldasElegidas(String celdasElegidas) {
        this.celdasElegidas = celdasElegidas;
    }
 

}
