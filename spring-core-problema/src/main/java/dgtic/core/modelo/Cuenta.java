package dgtic.core.modelo;

import java.util.Date;
import java.util.Objects;

public class Cuenta {
    private Integer id;
    private Integer saldo;
    private Date fechaApertura;
    private EstatusCuenta estatusCuenta;


    public Cuenta(EstatusCuenta cuentaNueva) {
        this.estatusCuenta = cuentaNueva;
        this.fechaApertura = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuenta cuenta)) return false;
        return Objects.equals(getId(), cuenta.getId()) && Objects.equals(getSaldo(), cuenta.getSaldo()) && Objects.equals(getFechaApertura(), cuenta.getFechaApertura()) && Objects.equals(getEstatusCuenta(), cuenta.getEstatusCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSaldo(), getFechaApertura(), getEstatusCuenta());
    }
}
