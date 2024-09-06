package com.example.apuestasPartido.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "partidos")
public class Partido {
    @Id()
    private Long id;
    private Estado estado;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

}
