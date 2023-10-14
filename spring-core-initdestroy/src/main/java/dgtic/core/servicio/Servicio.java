package dgtic.core.servicio;

import dgtic.core.modelo.Empleado;

public class Servicio {
    private static Servicio servicio = new Servicio();
    private Empleado empleado;

    public static Servicio getInstance() {
        return servicio;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void iniciar(){
        System.out.println("Iniciando el  servicio");
    }

    public void destruir(){
        System.out.println("Destruir el servicio");
    }
}
