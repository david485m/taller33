
import java.util.ArrayList;
import java.util.Scanner;
 
abstract class Ciclista {

    private int identificador;

    private String nombre;

    private int tiempoAcumulado;
 
    public Ciclista(int identificador, String nombre) {

        this.identificador = identificador;

        this.nombre = nombre;

        this.tiempoAcumulado = 15;

    }
 
    public int getIdentificador() {

        return identificador;

    }
 
    public void setIdentificador(int identificador) {

        this.identificador = identificador;

    }
 
    public String getNombre() {

        return nombre;

    }
 
    public void setNombre(String nombre) {

        this.nombre = nombre;

    }
 
    public int getTiempoAcumulado() {

        return tiempoAcumulado;

    }
 
    public void setTiempoAcumulado(int tiempoAcumulado) {

        this.tiempoAcumulado = tiempoAcumulado;

    }
 
    protected abstract String imprimirTipo();

}
 
class Velocista extends Ciclista {

    private double potenciaPromedio;

    private double velocidadSprintPromedio;
 
    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadSprintPromedio) {

        super(identificador, nombre);

        this.potenciaPromedio = potenciaPromedio;

        this.velocidadSprintPromedio = velocidadSprintPromedio;

    }
 
    public double getPotenciaPromedio() {

        return potenciaPromedio;

    }
 
    public void setPotenciaPromedio(double potenciaPromedio) {

        this.potenciaPromedio = potenciaPromedio;

    }
 
    public double getVelocidadSprintPromedio() {

        return velocidadSprintPromedio;

    }
 
    public void setVelocidadSprintPromedio(double velocidadSprintPromedio) {

        this.velocidadSprintPromedio = velocidadSprintPromedio;

    }
 
    @Override

    protected String imprimirTipo() {

        return "Es un Velocista";

    }

}
 
class Escalador extends Ciclista {

    private float aceleracionPromedio;

    private float gradoRampaSoportada;
 
    public Escalador(int identificador, String nombre, float aceleracionPromedio, float gradoRampaSoportada) {

        super(identificador, nombre);

        this.aceleracionPromedio = aceleracionPromedio;

        this.gradoRampaSoportada = gradoRampaSoportada;

    }
 
    public float getAceleracionPromedio() {

        return aceleracionPromedio;

    }
 
    public void setAceleracionPromedio(float aceleracionPromedio) {

        this.aceleracionPromedio = aceleracionPromedio;

    }
 
    public float getGradoRampaSoportada() {

        return gradoRampaSoportada;

    }
 
    public void setGradoRampaSoportada(float gradoRampaSoportada) {

        this.gradoRampaSoportada = gradoRampaSoportada;

    }
 
    @Override

    protected String imprimirTipo() {

        return "Es un Escalador";

    }

}
 
class Contrarrelojista extends Ciclista {

    private double velocidadMaxima;
 
    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {

        super(identificador, nombre);

        this.velocidadMaxima = velocidadMaxima;

    }
 
    public double getVelocidadMaxima() {

        return velocidadMaxima;

    }
 
    public void setVelocidadMaxima(double velocidadMaxima) {

        this.velocidadMaxima = velocidadMaxima;

    }
 
    @Override

    protected String imprimirTipo() {

        return "Es un Contrarrelojista";

    }

}
 
class Equipo {

    private String nombreEquipo;

    private String paisEquipo;

    private static int sumaTiemposCarrera = 0;

    private ArrayList<Ciclista> ciclistas = new ArrayList<>();
 
    public Equipo(String nombreEquipo, String paisEquipo) {

        this.nombreEquipo = nombreEquipo;

        this.paisEquipo = paisEquipo;

    }
 
    public String getNombreEquipo() {

        return nombreEquipo;

    }
 
    public void setNombreEquipo(String nombreEquipo) {

        this.nombreEquipo = nombreEquipo;

    }
 
    public String getPaisEquipo() {

        return paisEquipo;

    }
 
    public void setPaisEquipo(String paisEquipo) {

        this.paisEquipo = paisEquipo;

    }
 
    public static int getSumaTiemposCarrera() {

        return sumaTiemposCarrera;

    }
 
    public static void setSumaTiemposCarrera(int sumaTiemposCarrera) {

        Equipo.sumaTiemposCarrera = sumaTiemposCarrera;

    }
 
    public void añadirCiclista(Ciclista ciclista) {

        ciclistas.add(ciclista);

        sumaTiemposCarrera += ciclista.getTiempoAcumulado();

    }
 
    public void imprimirDatosEquipo() {

        System.out.println("Nombre del Equipo: " + nombreEquipo);

        System.out.println("País del Equipo: " + paisEquipo);

        System.out.println("Suma de Tiempos de Carrera: " + sumaTiemposCarrera + " minutos");

    }
 
    public void listarCiclistas() {

        System.out.println("Ciclistas del Equipo " + nombreEquipo + ":");

        for (Ciclista ciclista : ciclistas) {

            System.out.println("- " + ciclista.getNombre());

        }

    }
 
    public void imprimirDatosCiclista(int identificador) {

        boolean encontrado = false;

        for (Ciclista ciclista : ciclistas) {

            if (ciclista.getIdentificador() == identificador) {

                encontrado = true;

                System.out.println("Datos del Ciclista:");

                System.out.println("Identificador: " + ciclista.getIdentificador());

                System.out.println("Nombre: " + ciclista.getNombre());

                System.out.println("Tiempo Acumulado: " + ciclista.getTiempoAcumulado() + " minutos");

                System.out.println(ciclista.imprimirTipo());

                break;

            }

        }

        if (!encontrado) {

            System.out.println("No se encontró ningún ciclista con el identificador proporcionado.");

        }

    }

}
 
public class Main {

    public static void main(String[] args) {

        Equipo equipo = new Equipo("Equipo A", "España");
 
        Velocista velocista = new Velocista(1, "Juan", 250, 60);

        Escalador escalador = new Escalador(2, "Pedro", 9.8f, 10.5f);

        Contrarrelojista contrarrelojista = new Contrarrelojista(3, "Luis", 45.5);
 
        equipo.añadirCiclista(velocista);

        equipo.añadirCiclista(escalador);


        equipo.añadirCiclista(contrarrelojista);
 
        equipo.imprimirDatosEquipo();

        equipo.listarCiclistas();
 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el identificador del ciclista que desea buscar:");

        int idBuscado = scanner.nextInt();

        equipo.imprimirDatosCiclista(idBuscado);

    }
}
    