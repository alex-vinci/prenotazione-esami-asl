package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Esame.COLLECTION_NAME)
public class Esame {
    public static final String COLLECTION_NAME = "coll_esami";

    @Id
    @NonNull
    private String codEsame;

    @NonNull
    private String descrizioneEsame;
}
