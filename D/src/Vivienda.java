import java.util.ArrayList;

public class Vivienda {
    private long id;
    private String calle;
    private int numeroCalle;
    private Double superficieTerreno;
    private ArrayList<Habitacion> habitaciones;

    public Vivienda() {
    }

    public Vivienda(long id, String calle, int numeroCalle, Double superficieTerreno) {
        this.id = id;
        this.calle = calle;
        this.numeroCalle = numeroCalle;
        this.superficieTerreno = superficieTerreno;
        this.habitaciones = new ArrayList<>();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public Double getSuperficieTerreno() {
        return superficieTerreno;
    }
    public void setSuperficieTerreno(Double superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void addHabitacion(Habitacion habitacion) {
        if (habitaciones == null) {
            habitaciones = new ArrayList<>();
            habitaciones.add(habitacion);
        }
        habitaciones.add(habitacion);
    }

    public double getMetrosCuadradosCubiertos(){
        double totalMCuadrados =0;
        for (Habitacion h : habitaciones) {
            totalMCuadrados += h.getMetrosCuadrados();
        }
        if (totalMCuadrados > superficieTerreno){
            System.out.println("La superficie cubierta no puede ser mayor a la superficie del terreno!");
        }
        return totalMCuadrados;
    }
}
