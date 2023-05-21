package com.prenotazione.esami.asl.service.impl;

import com.prenotazione.esami.asl.model.Paziente;
import com.prenotazione.esami.asl.repository.PazienteRepository;
import com.prenotazione.esami.asl.service.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class PazienteServiceImpl implements PazienteService {
    @Autowired
    private PazienteRepository repository;

    @Override
    public Paziente inserisciPaziente(Paziente paziente) throws ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy"); //Format for input
        Date parseDataNascita = dateParser.parse(paziente.getDataNascita()); //Parsing the date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd"); //Format for output
        paziente.setDataNascita(dateFormatter.format(parseDataNascita)); //Printing the date
        return repository.save(paziente);
    }

    @Override
    public Optional<Paziente> cercaPaziente(String codiceFiscale) {
        return repository.findById(codiceFiscale);
    }

    @Override
    public Paziente cancellaPaziente(String codiceFiscale) {
        Optional<Paziente> optionalPaziente = repository.findById(codiceFiscale);
        if (optionalPaziente.isPresent()) {
            repository.delete(optionalPaziente.get());
            return optionalPaziente.get();
        }
        return null;
    }

    @Override
    public Paziente aggiornaPaziente(String codiceFiscale, Paziente p) {
        Optional<Paziente> optionalPaziente = repository.findById(codiceFiscale);
        if (optionalPaziente.isPresent()) {
            return repository.save(p);
        }
        return null;
    }
}
