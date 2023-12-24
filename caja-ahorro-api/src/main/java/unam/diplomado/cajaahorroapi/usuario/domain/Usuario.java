package unam.diplomado.cajaahorroapi.usuario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private Integer id;
    private String nombre;
    @Column(name="apellido_paterno")
    private String apellidoPaterno;
    @Column(name="apellido_materno")
    private String apellidoMaterno;
    private String email;
    @Column(name="contrasena")
    private String password;
    @Column(name="numero_telefonico")
    private String numeroTelefonico;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String password, String numeroTelefonico, Integer rol) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.password = password;
        this.numeroTelefonico = numeroTelefonico;
        this.rol = new Rol();
        this.rol.setId(rol);
    }
}
