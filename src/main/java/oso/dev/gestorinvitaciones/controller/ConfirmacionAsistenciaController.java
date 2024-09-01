package oso.dev.gestorinvitaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.service.AsistenciaService;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/asistencia", method = RequestMethod.POST)
public class ConfirmacionAsistenciaController {

    private AsistenciaService asistenciaService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void saveAsistencia(@RequestParam(required = false) Map<String, String> params) {

        if (!params.isEmpty()) {

            Asistencia asistencia = new Asistencia();

            asistencia.setName(params.get("name"));
            asistencia.setAsistencia("si".equals(params.get("asistencia")));
            asistencia.setMensajeOp(params.get("mensajeOp"));

            asistenciaService.save(asistencia);
        }
    }

    @Autowired
    public void setAsistenciaService(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
}
