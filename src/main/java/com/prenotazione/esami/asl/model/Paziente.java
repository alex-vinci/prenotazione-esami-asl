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
    @Pattern(regexp = "^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$\n")
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
