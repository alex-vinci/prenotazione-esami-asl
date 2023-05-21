package com.prenotazione.esami.asl.repository;

import com.prenotazione.esami.asl.model.Paziente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends MongoRepository<Paziente, String> {
}
