import java.util.ArrayList;
import java.util.List;

public class Expediente {

    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private Expediente expedientePadre;
    private ArrayList<Control> controles;
    private ArrayList<Expediente> expedientesHijos;

    public Expediente() {
    }

    public Expediente(int id, String letra, int numero, String descripcion, String tipo, String ambito) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ambito = ambito;
        this.controles = new ArrayList<>();
        this.expedientesHijos = new ArrayList<>();
        this.expedientePadre = null;
    }

    public String getCaratulaExpediente(){
        return numero + "-" + letra + "-" + descripcion;
    }

    public String getControlesObligatorios (){
        String respuesta="";
        for (Control c : controles){
            if (c.getEsObligatorio()){
                respuesta +=  c.getDenominacion() + ", ";
            }
        }
        return respuesta;
    }

    public boolean getEstadoControles() {
        for (Control c : controles) {
            if (c.getEsObligatorio()) {
                EstadoControl estado = c.getEstadoControl();
                if (estado == null || !Boolean.TRUE.equals(estado.getAprobado())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Expediente> listaExpedientes() {
        List<Expediente> resultado = new ArrayList<>();
        agregarExpedientesRecursivos(this, resultado);
        return resultado;
    }

    private void agregarExpedientesRecursivos(Expediente expediente, List<Expediente> acumulador) {
        for (Expediente hijo : expediente.getExpedientesHijos()) {
            acumulador.add(hijo); // agrega el hijo actual
            agregarExpedientesRecursivos(hijo, acumulador); // recursión con los hijos del hijo
        }
    }

    public ArrayList<Expediente> getExpedientesHijos() {
        return expedientesHijos;
    }

    public void setExpedientesHijos(ArrayList<Expediente> expedientesHijos) {
        this.expedientesHijos = expedientesHijos;
    }
}
