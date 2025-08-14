import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private String email;
    private String celular;
    private List<Actividad> actividades;
    private Sector sector;

    public Persona() {}

    public Persona(String nombre, String tipoDocumento, long nroDocumento, int telefono, String email, String celular) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void addActividad(Actividad actividad) {
        if (this.actividades == null) {
            this.actividades = new ArrayList<>();
        }
        this.actividades.add(actividad);
    }

    public double totalPuntosAsignados() {
        double totalPuntos = 0.0;
        if (this.actividades != null) {
            for (Actividad actividad : this.actividades) {
                if (actividad.getTipoActividad() != null) {
                    totalPuntos += actividad.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        return totalPuntos;
    }

    public double totalPuntosAsignados(int codigo) {
        double totalPuntos = 0.0;
        if (this.actividades != null) {
            for (Actividad actividad : this.actividades) {
                if (actividad.getTipoActividad() != null && actividad.getTipoActividad().getCodigo() == codigo) {
                        totalPuntos += actividad.getTipoActividad().getPuntosAsignados();
                    }
                }
            }
        return totalPuntos;
    }

    public double totalPuntosAsignados(int codigo, int anio) {
        double totalPuntos = 0.0;
        if (this.actividades != null) {
            for (Actividad actividad : this.actividades) {
                if (actividad.getTipoActividad() != null && actividad.getFechaInicio() != null) {
                    Instant instant = actividad.getFechaInicio().toInstant();
                    LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                    int anioActividad = localDate.getYear();
                    if (actividad.getTipoActividad().getCodigo() == codigo && anioActividad == anio) {
                        totalPuntos += actividad.getTipoActividad().getPuntosAsignados();
                    }
                }
            }
        }
        return totalPuntos;
    }
}