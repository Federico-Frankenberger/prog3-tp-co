import java.util.ArrayList;

public class Control {
    private int id;
    private String denominacion;
    private Boolean esObligatorio;
    private ArrayList<Expediente> expedientes;
    private EstadoControl estadoControl;

    public Control() {
    }

    public Control(int id, String denominacion, Boolean esObligatorio, EstadoControl estadoControl) {
        this.id = id;
        this.denominacion = denominacion;
        this.esObligatorio = esObligatorio;
        this.estadoControl = estadoControl;
        this.expedientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Boolean getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(Boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public EstadoControl getEstadoControl() {

        return estadoControl;
    }

    public void setEstadoControl(EstadoControl estadoControl) {
        this.estadoControl = estadoControl;
    }
}
