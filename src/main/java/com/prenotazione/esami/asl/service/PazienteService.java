package com.prenotazione.esami.asl.service;

import com.prenotazione.esami.asl.model.Paziente;

import java.text.ParseException;
import java.util.Optional;

public interface PazienteService {
    Paziente inserisciPaziente(Paziente p) throws Exception;
    Optional<Paziente> cercaPaziente(String codiceFiscale) throws Exception;
    Paziente cancellaPaziente(String codiceFiscale) throws Exception;
    Paziente aggiornaPaziente(String codiceFiscale, Paziente p) throws Exception;
}
