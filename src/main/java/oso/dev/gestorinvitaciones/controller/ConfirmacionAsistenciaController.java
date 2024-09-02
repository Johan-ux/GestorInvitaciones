package oso.dev.gestorinvitaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.service.AsistenciaService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "https://cold-math-1702.bss.design/")
@RequestMapping(value = "/api/asistencia", method = RequestMethod.POST)
public class ConfirmacionAsistenciaController {

    private AsistenciaService asistenciaService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> saveAsistencia(@RequestParam(required = false) Map<String, String> params) {
        if (!params.isEmpty()) {
            Asistencia asistencia = new Asistencia();

            asistencia.setKids(params.get("kids"));
            asistencia.setName(params.get("nameIv"));
            asistencia.setAdult(params.get("adult"));
            asistencia.setMensajeOp(params.get("mensajeOp"));
            asistencia.setAsistencia("si".equals(params.get("asistencia")));

            asistenciaService.save(asistencia);

            return ResponseEntity.ok(asistencia.isAsistencia() ? "Asistencia confirmada" : "Inasistencia confirmada");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos no válidos");
    }

    @Autowired
    public void setAsistenciaService(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
}
