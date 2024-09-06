package com.example.apuestasPartido.Repository;

import com.example.apuestasPartido.Entity.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidoRepository extends MongoRepository<Partido,Long> {
    //metodos manuales de HQL
}
