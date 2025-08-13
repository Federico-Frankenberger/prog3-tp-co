//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Barrio barrio1 = new Barrio(1,"Barrio N°1", "Empresa Rocky");
        Barrio barrio2 = new Barrio(2, "Barrio 2", "Empresa Piedritas");

        Vivienda vivienda1  = new Vivienda(11, "Terrada", 3501, 300.0);
        Vivienda vivienda2 = new Vivienda(12, "San Martin", 2508, 800.0);

        Habitacion habitacion1 = new Habitacion(111, "Comedor", 40);
        Habitacion habitacion2 = new Habitacion(222, "Cocina", 30);
        Habitacion habitacion3 = new Habitacion(333, "Baño", 10);

        vivienda1.addHabitacion(habitacion1);
        vivienda1.addHabitacion(habitacion2);
        vivienda1.addHabitacion(habitacion3);

        Habitacion habitacion4 = new Habitacion(444, "Comedor", 100);
        Habitacion habitacion5 = new Habitacion(555, "Cocina", 30);
        Habitacion habitacion6 = new Habitacion(666, "Baño", 15);

        vivienda2.addHabitacion(habitacion4);
        vivienda2.addHabitacion(habitacion5);
        vivienda2.addHabitacion(habitacion6);

        barrio1.addVivienda(vivienda1);
        barrio1.addVivienda(vivienda2);

        System.out.println("La superficie total del terreno del barrio es de: " + barrio1.getSuperficieTotalTerreno());
        System.out.println("La superficie total cubierta de la vivienda n° 1 es de: " + vivienda1.getSuperficieTerreno());
        System.out.println("La superficie total cubierta de la vivienda n| 2 es de: " + vivienda2.getSuperficieTerreno());
        System.out.println("La superficie cubierta total del barrio es de: " + barrio1.getSuperficieTotalCubierta());


    }
}