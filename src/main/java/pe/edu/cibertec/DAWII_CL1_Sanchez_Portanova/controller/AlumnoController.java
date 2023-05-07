package pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.request.AlumnoRequest;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Sanchez_Portanova.service.AlumnoService;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/frmMantAlumno")
    public String frmMantAlumno(Model model) {
        model.addAttribute("listaAlumnos", alumnoService.listarAlumnos());
        return "Alumno/frmMantAlumno";
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody
                                             AlumnoRequest alumnoRequest){
        String mensaje = "Alumno registrada correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();
            if(AlumnoRequest.getIdalumno() > 0){
                objAlumno.setIdalumno(AlumnoRequest.getIdalumno());
            }
            objAlumno.setApealumno(AlumnoRequest.getApealumno());
            objAlumno.setNomalumno(AlumnoRequest.getNomalumno());
            objAlumno.setProce(AlumnoRequest.getProce());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdesp(AlumnoRequest.getIdesp());
            objAlumno.setListaesp((List<Especialidad>) objEspecialidad);
            alumnoService.registrarAlumnos(objAlumno);
        }catch (Exception ex){
            mensaje = "Alumno no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody
                                              AlumnoRequest alumnoRequest{
        String mensaje = "Sala eliminada correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumnos(AlumnoRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "Alumnono eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }



}
