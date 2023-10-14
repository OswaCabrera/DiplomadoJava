package dgtic.core.modelo;

import java.util.Date;

public class Cuenta {
    private Integer saldo;
    private Date fechaApertura;
    private EstatusCuenta estatusCuenta;

    public Cuenta(EstatusCuenta cuentaNueva) {
        this.estatusCuenta = cuentaNueva;
        this.fechaApertura = new Date();
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public EstatusCuenta getEstatusCuenta() {
        return estatusCuenta;
    }

    public void setEstatusCuenta(EstatusCuenta estatusCuenta) {
        this.estatusCuenta = estatusCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                ", estatusCuenta=" + estatusCuenta +
                '}';
    }
}
