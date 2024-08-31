package oso.dev.gestorinvitaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.service.AsistenciaService;

import java.util.List;

@Controller
@RequestMapping(value = "/Home", method = {RequestMethod.GET, RequestMethod.POST})
public class HomeController {

    private AsistenciaService asistenciaService;

    @GetMapping
    public String home(Model model) {

        List<Asistencia> asistencia = asistenciaService.getAsistenciaList();
        model.addAttribute("asistencia", asistencia);

        return "home";
    }

    @Autowired
    public void setAsistenciaService(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
}
