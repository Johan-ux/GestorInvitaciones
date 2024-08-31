package oso.dev.gestorinvitaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import oso.dev.gestorinvitaciones.documents.Asistencia;


@Repository
public interface AsistenciaRepository extends MongoRepository<Asistencia, String> {
}
