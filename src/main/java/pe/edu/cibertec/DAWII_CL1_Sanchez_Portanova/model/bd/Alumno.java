package pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumno;

    @Column(name = "apealumno")
    private String apealumno;

    @Column(name = "nomalumno")
    private String nomalumno;

    @Column(name = "proce")
    private Integer proce;

    @JsonManagedReference
    @OneToMany(mappedBy = "alumno",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidad> listaesp = new ArrayList<>();
}
