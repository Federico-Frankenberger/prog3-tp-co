import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empleado {

    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private ArrayList <Asistencia> asistencias;
    private ArrayList <Tardanza> tardanzas;
    private RegimenHorario regimenHorario;

    public Empleado() {
        this.asistencias = new ArrayList<>();
        this.tardanzas = new ArrayList<>();
    }

    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio){
        List<Asistencia> retorno = new ArrayList<>();
        for(Asistencia a : asistencias ){
            Date fecha  =  a.getFecha();
            int mesFecha = fecha.getMonth() + 1;
            int anioFecha = fecha.getYear() + 1900;
            if(mesFecha ==  mes && anioFecha == anio){
                retorno.add(a);
            }
        }
        return retorno;
    }

    public List<Tardanza> getDiasConTardanza(int mes, int anio){
            List<Tardanza> retorno = new ArrayList<>();
            for (Asistencia a : getAsistenciaXMesXAnio(mes, anio)){

                Date fecha  = a.getFecha();
                int mesFecha = fecha.getMonth() + 1;
                int anioFecha = fecha.getYear() + 1900;

                int ingresoEmpleadoMin = a.getHora() * 60 + a.getMinuto();
                int ingresoRegimenMin = regimenHorario.getHoraIngreso() * 60 + regimenHorario.getMinutoIngreso();

                if(ingresoEmpleadoMin > ingresoRegimenMin + 15){
                    Tardanza tardanza = new Tardanza(a.getId(),
                            a.getTipo(),a.getFecha(),a.getMinuto(),a.getHora(),this);
                    retorno.add(tardanza);
                }

            }

            return retorno;
    }
}
