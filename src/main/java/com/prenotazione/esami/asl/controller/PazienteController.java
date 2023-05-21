package com.prenotazione.esami.asl.controller;

import com.prenotazione.esami.asl.model.Paziente;
import com.prenotazione.esami.asl.service.PazienteService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/paziente")
@Slf4j
public class PazienteController {
    @Autowired
    private PazienteService service;

    @PostMapping(value = "/inserisciPaziente")
    @ApiOperation("Inserisce un nuovo paziente")
    public Paziente inserisciPaziente(@RequestBody @Validated Paziente paziente) throws ParseException {
        log.info("Inserimento paziente");
        return service.inserisciPaziente(paziente);
    }

    @GetMapping(value = "/cercaPaziente/{codiceFiscale}")
    @ApiOperation("Cerca un paziente tramite il suo codice fiscale")
    Paziente cercaPaziente(@PathVariable String codiceFiscale) {
        log.info("Cerca paziente tramite codice fiscale: {}", codiceFiscale);
        Optional<Paziente> pazienteTrovato = service.cercaPaziente(codiceFiscale);
        return pazienteTrovato.orElseGet(() -> (Paziente) ResponseEntity.notFound());
    }

    @DeleteMapping(value = "/cancellaPaziente/{codiceFiscale}")
    @ApiOperation("Cancella un paziente")
    Paziente cancellaPaziente(@PathVariable String codiceFiscale) {
        log.info("Cancella paziente tramite codice fiscale: {}", codiceFiscale);
        Paziente p = service.cancellaPaziente(codiceFiscale);
        if (p != null) {
            return p;
        }
        return (Paziente) ResponseEntity.notFound();
    }

    @PutMapping(value = "/aggiornaPaziente/{codiceFiscale}")
    @ApiOperation("Aggiorna un paziente")
    Paziente aggiornaPaziente(@PathVariable String codiceFiscale, @RequestBody Paziente paziente) {
        log.info("Aggiorna paziente tramite codice fiscale: {}", codiceFiscale);
        Paziente updatedPaziente = service.aggiornaPaziente(codiceFiscale, paziente);
        if (updatedPaziente != null) {
            return updatedPaziente;
        }
        return (Paziente) ResponseEntity.notFound();
    }
}
