import java.util.List;

public class TipoActividad {
    private int codigo;
    private String denominacion;
    private double puntosAsignados;
    private List<Actividad> actividades;

    public TipoActividad() {}

    public TipoActividad(int codigo, String denominacion, double puntosAsignados) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.puntosAsignados = puntosAsignados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPuntosAsignados() {
        return puntosAsignados;
    }

    public void setPuntosAsignados(double puntosAsignados) {
        this.puntosAsignados = puntosAsignados;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
