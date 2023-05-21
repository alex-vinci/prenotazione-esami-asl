package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Laboratorio.COLLECTION_NAME)
public class Laboratorio {
    public static final String COLLECTION_NAME = "coll_laboratori";
    @Id
    @NonNull
    private String codiceLaboratorio;
    @NonNull
    private String codiceOspedale;
    @NonNull
    private String nomeLaboratorio;
    @NonNull
    private String piano;
    @NonNull
    private String stanza;
}
