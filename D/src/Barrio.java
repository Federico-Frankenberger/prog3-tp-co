import java.util.ArrayList;

public class Barrio {
    private long id;
    private String nombre;
    private String empresaConstructora;
    private ArrayList<Vivienda> viviendas;

    public Barrio() {
    }

    public Barrio(long id, String nombre, String empresaConstructora) {
        this.id = id;
        this.nombre = nombre;
        this.empresaConstructora = empresaConstructora;
        this.viviendas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmpresaConstructora() {
        return empresaConstructora;
    }
    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }
    public ArrayList<Vivienda> getViviendas() {
        return viviendas;
    }

    public void addVivienda(Vivienda vivienda) {
        if (viviendas == null) {
            viviendas = new ArrayList<>();
            viviendas.add(vivienda);
        }
        viviendas.add(vivienda);
    }


    public double getSuperficieTotalTerreno(){
        double total = 0;
        for (Vivienda vivienda : viviendas) {
            total += vivienda.getSuperficieTerreno();
        }
        return total;
    }

    public double getSuperficieTotalCubierta(){
        double totalSuperficie = 0;
        for (Vivienda vivienda : viviendas) {
            totalSuperficie += vivienda.getMetrosCuadradosCubiertos();
        }
        return totalSuperficie;
    }
}
