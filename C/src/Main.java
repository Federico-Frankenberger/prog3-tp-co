import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        TipoActividad tipo1 = new TipoActividad();
        tipo1.setCodigo(1);
        tipo1.setDenominacion("Java");
        tipo1.setPuntosAsignados(50.0);

        TipoActividad tipo2 = new TipoActividad();
        tipo2.setCodigo(2);
        tipo2.setDenominacion("SQL");
        tipo2.setPuntosAsignados(30.0);

        Actividad act1 = new Actividad();
        act1.setFechaInicio(new Date());
        act1.setFechaFin(new Date());
        act1.setNombre("Java Básico");
        act1.setDescripcion("Curso introductorio de Java");
        act1.setTipoActividad(tipo1);

        Actividad act2 = new Actividad();
        act2.setFechaInicio(new Date());
        act2.setFechaFin(new Date());
        act2.setNombre("SQL Avanzado");
        act2.setDescripcion("Taller práctico de SQL");
        act2.setTipoActividad(tipo2);

        Actividad act3 = new Actividad();
        act3.setFechaInicio(new Date());
        act3.setFechaFin(new Date());
        act3.setNombre("Java Avanzado");
        act3.setDescripcion("Curso avanzado de Java");
        act3.setTipoActividad(tipo1);

        Persona persona = new Persona();
        persona.setNombre("Miguel");
        persona.setTipoDocumento("DNI");
        persona.setNroDocumento(12345678);
        persona.setTelefono(123456);
        persona.setEmail("miguel@gmail.com");
        persona.setCelular("123456789");

        persona.addActividad(act1);
        persona.addActividad(act2);
        persona.addActividad(act3);

        double totalPuntos = persona.totalPuntosAsignados();
        System.out.println("Total de puntos asignados: " + totalPuntos);

        double totalPuntosCodigo1 = persona.totalPuntosAsignados(1);
        System.out.println("Total de puntos asignados: " + totalPuntosCodigo1);

        double totalPuntosCodigo1xanio = persona.totalPuntosAsignados(1, 2024);
        System.out.println("Total de puntos asignados: " + totalPuntosCodigo1xanio);

        //Prueba del metodo obtenerTotalSubsectores()

        Sector sectorPrincipal = new Sector(1, "Dirección General", "Administrativo");
        Sector sectorHijo1 = new Sector(2, "Departamento de Finanzas", "Financiero");
        Sector sectorHijo2 = new Sector(3, "Departamento de Recursos Humanos", "Administrativo");
        Sector sectorNieto1 = new Sector(4, "Contabilidad", "Financiero");
        Sector sectorNieto2 = new Sector(5, "Recursos Humanos Junior", "Administrativo");
        Sector sectorBisnieto = new Sector(6, "Nóminas", "Administrativo");


        List<Sector> hijosPrincipal = new ArrayList<>();
        hijosPrincipal.add(sectorHijo1);
        hijosPrincipal.add(sectorHijo2);
        sectorPrincipal.setSectoresHijos(hijosPrincipal);

        sectorHijo1.setSectorPadre(sectorPrincipal);
        sectorHijo2.setSectorPadre(sectorPrincipal);

        List<Sector> hijosFinanzas = new ArrayList<>();
        hijosFinanzas.add(sectorNieto1);
        sectorHijo1.setSectoresHijos(hijosFinanzas);

        sectorNieto1.setSectorPadre(sectorHijo1);

        List<Sector> hijosRRHH = new ArrayList<>();
        hijosRRHH.add(sectorNieto2);
        sectorHijo2.setSectoresHijos(hijosRRHH);

        sectorNieto2.setSectorPadre(sectorHijo2);

        List<Sector> hijosRRHHJunior = new ArrayList<>();
        hijosRRHHJunior.add(sectorBisnieto);
        sectorNieto2.setSectoresHijos(hijosRRHHJunior);

        sectorBisnieto.setSectorPadre(sectorNieto2);


        System.out.println("Prueba del método obtenerTotalSubsectores() del sector principal:");
        List<Sector> totalSubsectores = sectorPrincipal.obtenerTotalSubsectores();

        System.out.println("Total de subsectores encontrados: " + totalSubsectores.size());
        for (Sector subsector : totalSubsectores) {
//            System.out.println(subsector);
            System.out.println("- " + subsector.getDenominacion() + " (Sector padre: " + subsector.getSectorPadre().getDenominacion() + ")");
        }
    }
}
