package com.prenotazione.esami.asl.service;

import com.prenotazione.esami.asl.model.Paziente;

import java.text.ParseException;
import java.util.Optional;

public interface PazienteService {
    Paziente inserisciPaziente(Paziente p) throws ParseException;
    Optional<Paziente> cercaPaziente(String codiceFiscale);
    Paziente cancellaPaziente(String codiceFiscale);
    Paziente aggiornaPaziente(String codiceFiscale, Paziente p);
}
