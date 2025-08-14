import java.util.ArrayList;

public class EstadoControl {

    private long id;
    private Boolean aprobado;
    private ArrayList<Control> controles;

    public EstadoControl() {
    }

    public EstadoControl(long id, Boolean aprobado) {
        this.id = id;
        this.aprobado = aprobado;
        this.controles = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }
}
