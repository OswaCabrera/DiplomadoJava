package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private Integer usuario_id;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String email;
    private String contrasena;
    private String rol_id;
    @Column(name = "numero_telefonico")
    private String numeroTelefonico;
    private String calle;
    private String estado;
    private Integer zip;
}
