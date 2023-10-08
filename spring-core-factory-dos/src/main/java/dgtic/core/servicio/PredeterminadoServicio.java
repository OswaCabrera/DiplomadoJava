package dgtic.core.servicio;

public class PredeterminadoServicio {
    private static EmpleadoServicio empleadoServicio = new EmpleadoServicioImpl();
    private static ReporteEmpleadoServicio reporteEmpleadoServicio = new ReporteEmpleadoServicioImpl();

    public EmpleadoServicio getEmpleadoServicio() {
        return empleadoServicio;
    }

    public ReporteEmpleadoServicio getReporteEmpleadoServicio() {
        return reporteEmpleadoServicio;
    }
}
