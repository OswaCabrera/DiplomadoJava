package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
@NamedNativeQuery(
        name = "Usuario.buscarTodosUsuariosConCuentas",
        query = "SELECT u.*, c.saldo FROM usuario u JOIN cuenta c ON (u.usuario_id = c.usuario_id)",
        resultClass = Usuario.class
)
@NamedNativeQuery(
        name = "Usuario.buscarUsuarioyCuenta",
        query = "SELECT u.*, c.saldo FROM usuario u JOIN cuenta c ON (u.usuario_id = c.usuario_id) WHERE u.usuario_id = :id",
        resultClass = Usuario.class
)
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String email;
    private String contrasena;
    private Integer rol_id;
    @Column(name = "numero_telefonico")
    private String numeroTelefonico;
    private String calle;
    private String estado;
    private Integer zip;
    @OneToOne(mappedBy = "usuario_id")
    @Transient
    private Cuenta cuenta;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rol_id=" + rol_id +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                ", calle='" + calle + '\'' +
                ", estado='" + estado + '\'' +
                ", zip=" + zip +
                '}';
    }
}
