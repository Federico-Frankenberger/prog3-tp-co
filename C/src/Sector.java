import java.util.ArrayList;
import java.util.List;

public class Sector {
    private int numero;
    private String denominacion;
    private String tipo;
    private Sector sectorPadre;
    private List<Sector> sectoresHijos;
    private List<Persona> personas;

    public Sector() {}

    public Sector(int numero, String denominacion, String tipo) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sector getSectorPadre() {
        return sectorPadre;
    }

    public void setSectorPadre(Sector sectorPadre) {
        this.sectorPadre = sectorPadre;
    }

    public List<Sector> getSectoresHijos() {
        return sectoresHijos;
    }

    public void setSectoresHijos(List<Sector> sectoresHijos) {
        this.sectoresHijos = sectoresHijos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Sector> obtenerTotalSubsectores() {

        List<Sector> todosLosSubsectores = new ArrayList<>();

        if (this.sectoresHijos != null) {
            for (Sector sectorHijo : this.sectoresHijos) {
                todosLosSubsectores.add(sectorHijo);
                todosLosSubsectores.addAll(sectorHijo.obtenerTotalSubsectores());
            }
        }

        return todosLosSubsectores;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "numero=" + numero +
                ", denominacion='" + denominacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sectorPadre=" + sectorPadre +
                '}';
    }
}
