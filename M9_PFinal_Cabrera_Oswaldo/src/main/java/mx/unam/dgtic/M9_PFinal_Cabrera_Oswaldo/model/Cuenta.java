package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuenta_id;
    private String saldo;
    private Date fecha_apertura;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;

}
