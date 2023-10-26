package dgtic.core.modelo;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String email;
    private String telefono;
    private String direccion;

    private Cuenta cuenta;

    public Usuario(Cuenta cuentaNueva) {
        this.cuenta = cuentaNueva;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getApellidoPaterno(), usuario.getApellidoPaterno()) && Objects.equals(getApellidoMaterno(), usuario.getApellidoMaterno()) && Objects.equals(getPassword(), usuario.getPassword()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getTelefono(), usuario.getTelefono()) && Objects.equals(getDireccion(), usuario.getDireccion()) && Objects.equals(getCuenta(), usuario.getCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellidoPaterno(), getApellidoMaterno(), getPassword(), getEmail(), getTelefono(), getDireccion(), getCuenta());
    }
}
