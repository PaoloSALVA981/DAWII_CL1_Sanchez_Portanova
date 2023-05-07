package pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaRequest {
    private Integer idsala;
    private String descsala;
    private Integer asientos;
    private Integer idestado;
}
