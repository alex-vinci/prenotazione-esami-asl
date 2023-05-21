package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Prenotazione.COLLECTION_NAME)
public class Prenotazione {
    public static final String COLLECTION_NAME = "coll_prenotazioni";
    @Id
    @NonNull
    private String codicePrenotazione;
    @NonNull
    private String codiceOspedale;
    @NonNull
    private String codiceLaboratorio;
    @NonNull
    private String codiceEsame;
    @NonNull
    private String codiceFiscalePaziente;
    @NonNull
    private String dataPrenotazione;
    @NonNull
    private String oraPrenotazione;
    @NonNull
    private Double costoPrenotazione;
    private boolean urgenzaPrenotazione;
}
