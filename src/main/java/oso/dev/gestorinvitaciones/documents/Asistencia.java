package oso.dev.gestorinvitaciones.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Asistencia")
public class Asistencia implements Serializable {

    @Id
    private String id;

    private String name;

    private boolean asistencia;

    private String adult;

    private String kids;

    private String mensajeOp;
}
