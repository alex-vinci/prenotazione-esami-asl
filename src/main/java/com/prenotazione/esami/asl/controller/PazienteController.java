package com.prenotazione.esami.asl.controller;

import com.prenotazione.esami.asl.model.Paziente;
import com.prenotazione.esami.asl.service.PazienteService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Paziente inserisciPaziente(@RequestBody Paziente paziente) throws Exception {
        log.info("Inserimento paziente");
        return service.inserisciPaziente(paziente);
    }

    @GetMapping(value = "/cercaPaziente/{codiceFiscale}")
    @ApiOperation("Cerca un paziente tramite il suo codice fiscale")
    Paziente cercaPaziente(@PathVariable String codiceFiscale) throws Exception {
        log.info("Cerca paziente tramite codice fiscale: {}", codiceFiscale);
        Optional<Paziente> pazienteTrovato = service.cercaPaziente(codiceFiscale);
        return pazienteTrovato.orElseGet(() -> (Paziente) ResponseEntity.notFound());
    }

    @DeleteMapping(value = "/cancellaPaziente/{codiceFiscale}")
    @ApiOperation("Cancella un paziente")
    ResponseEntity<String> cancellaPaziente(@PathVariable String codiceFiscale) throws Exception {
        log.info("Cancella paziente tramite codice fiscale: {}", codiceFiscale);
        Paziente p = service.cancellaPaziente(codiceFiscale);
        if (p != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Cancellazione effettuata con successo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Impossibile cancellare: paziente con codice fiscale: " + codiceFiscale + "non trovato");
        }
    }

    @PutMapping(value = "/aggiornaPaziente/{codiceFiscale}")
    @ApiOperation("Aggiorna un paziente")
    ResponseEntity<String> aggiornaPaziente(@PathVariable String codiceFiscale, @RequestBody Paziente paziente) throws Exception {
        log.info("Aggiorna paziente tramite codice fiscale: {}", codiceFiscale);
        Paziente updatedPaziente = service.aggiornaPaziente(codiceFiscale, paziente);
        if (updatedPaziente != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Update effettuato con successo" + updatedPaziente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Impossibile aggiornare: paziente con codice fiscale: " + codiceFiscale + "non trovato");
    }
}
