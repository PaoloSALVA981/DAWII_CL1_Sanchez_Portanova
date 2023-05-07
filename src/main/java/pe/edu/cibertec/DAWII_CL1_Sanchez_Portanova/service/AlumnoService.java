package pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    public void registrarAlumnos(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public void eliminarAlumnos(Alumno alumno) {
        alumnoRepository.deleteById(alumno.getIdalumno());
    }

}
