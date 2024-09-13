package oso.dev.gestorinvitaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.service.AsistenciaService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class HomeController {

    private AsistenciaService asistenciaService;

    @GetMapping
    public String init(Model model) {

        return home(model);
    }

    @GetMapping("/Home")
    public String home(Model model) {

        List<Asistencia> asistencia = asistenciaService.getAsistenciaList();

        Integer adults = asistencia.stream()
                .mapToInt(x -> Integer.parseInt(x.getAdult()))
                .sum();

        Integer kids = asistencia.stream()
                .mapToInt(x -> Integer.parseInt(x.getKids()))
                .sum();

        model.addAttribute("adults", adults);
        model.addAttribute("children", kids);
        model.addAttribute("asistencia", asistencia);

        return "home";
    }


    @ResponseBody
    @PostMapping("/delete")
    public String delete(@RequestBody Map<String, String> payload) {

        String asistenteId = payload.get("id");

        asistenciaService.delete(asistenteId);
        return "Ok";
    }

    @Autowired
    public void setAsistenciaService(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
}
