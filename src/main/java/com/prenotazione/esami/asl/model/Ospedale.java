package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Ospedale.COLLECTION_NAME)
public class Ospedale {
    public static final String COLLECTION_NAME = "coll_ospedali";
    @Id
    @NonNull
    private String codiceOspedale;
    @NonNull
    private String nomeOspedale;
    @NonNull
    private String indirizzoOspedale;
}
