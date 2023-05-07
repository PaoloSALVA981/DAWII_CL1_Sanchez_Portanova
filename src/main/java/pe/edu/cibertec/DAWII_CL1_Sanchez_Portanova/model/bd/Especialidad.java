package pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "especialidad")
@Getter
@Setter
@NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idesp;

    @Column(name = "nomesp")
    private String nomesp;

    @Column(name = "costo")
    private Double costo;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
}

