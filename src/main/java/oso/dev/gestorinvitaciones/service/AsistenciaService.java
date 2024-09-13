package oso.dev.gestorinvitaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.dev.gestorinvitaciones.documents.Asistencia;
import oso.dev.gestorinvitaciones.repository.AsistenciaRepository;

import java.util.List;

@Service
public class AsistenciaService {

    private AsistenciaRepository asistenciaRepository;

    public void save(Asistencia asistencia) {
        asistenciaRepository.save(asistencia);
    }

    public List<Asistencia> getAsistenciaList() {
        return asistenciaRepository.findAll();
    }

    public void delete(String asistenciaId) {
        asistenciaRepository.deleteById(asistenciaId);
    }

    @Autowired
    public void setAsistenciaRepository(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }
}
