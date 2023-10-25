package dgtic.core.modelo;

import java.util.Date;

public class Transaccion {
    private Integer monto;
    private Date fecha;
    private Cuenta cuenta;

    public Transaccion() {
        this.fecha = new Date();
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "monto=" + monto +
                ", fecha=" + fecha +
                ", cuenta=" + cuenta +
                '}';
    }
}
