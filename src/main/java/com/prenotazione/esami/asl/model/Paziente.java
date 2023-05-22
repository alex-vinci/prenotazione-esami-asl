package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Paziente.COLLECTION_NAME)
public class Paziente {
    public static final String COLLECTION_NAME = "coll_pazienti";
    @Id
    @NonNull
    @Size(min = 16, max = 16)
    private String codiceFiscale;

    @NonNull
    private String nome;

    @NonNull
    private String cognome;

    @NonNull
    private String indirizzo;

    @NonNull
    private String dataNascita;

    @NonNull
    private String luogoNascita;
}
