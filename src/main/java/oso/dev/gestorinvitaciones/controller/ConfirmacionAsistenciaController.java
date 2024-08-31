package oso.dev.gestorinvitaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.service.AsistenciaService;

@RestController
@RequestMapping(value = "/api/asistencia", method = RequestMethod.POST)
public class ConfirmacionAsistenciaController {

    private AsistenciaService asistenciaService;

    @PostMapping
    public void saveAsistencia(@RequestBody Asistencia asistencia) {
        asistenciaService.save(asistencia);
    }

    @Autowired
    public void setAsistenciaService(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
}
