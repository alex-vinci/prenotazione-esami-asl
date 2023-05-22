package com.prenotazione.esami.asl.service.impl;

import com.prenotazione.esami.asl.model.Paziente;
import com.prenotazione.esami.asl.repository.PazienteRepository;
import com.prenotazione.esami.asl.service.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class PazienteServiceImpl implements PazienteService {
	@Autowired
	private PazienteRepository repository;

	@Override
	public Paziente inserisciPaziente(Paziente paziente) throws Exception {
		if (this.validaCodiceFiscale(paziente.getCodiceFiscale())) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd"); //Format for output
			paziente.setDataNascita(dateFormatter.format(paziente.getDataNascita())); //Printing the date
			return repository.save(paziente);
		}
		throw new Exception("Codice fiscale non valido");
	}

	@Override
	public Optional<Paziente> cercaPaziente(String codiceFiscale) throws Exception {
		if (this.validaCodiceFiscale(codiceFiscale)) {
			return repository.findById(codiceFiscale);
		}
		throw new Exception("Codice fiscale non valido");
	}

	@Override
	public Paziente cancellaPaziente(String codiceFiscale) throws Exception {
		if (this.validaCodiceFiscale(codiceFiscale)) {
			Optional<Paziente> optionalPaziente = repository.findById(codiceFiscale);
			if (optionalPaziente.isPresent()) {
				repository.delete(optionalPaziente.get());
				return optionalPaziente.get();
			} else {
				return null;
			}
		}
		throw new Exception("Codice fiscale non valido");
	}

	@Override
	public Paziente aggiornaPaziente(String codiceFiscale, Paziente p) throws Exception {
		if (this.validaCodiceFiscale(codiceFiscale) && this.validaCodiceFiscale(p.getCodiceFiscale())) {
			Optional<Paziente> optionalPaziente = repository.findById(codiceFiscale);
			if (optionalPaziente.isPresent()) {
				return repository.save(p);
			} else {
				return null;
			}
		}
		throw new Exception("Codice fiscale non valido");
	}

	private boolean validaCodiceFiscale(String codiceFiscale) {
		String regex = "^[a-zA-Z]{6}\\d{2}[abcdehlmprstABCDEHLMPRST]\\d{2}([a-zA-Z]\\d{3})[a-zA-Z]$\n";
		return codiceFiscale.matches(regex);
	}
}
