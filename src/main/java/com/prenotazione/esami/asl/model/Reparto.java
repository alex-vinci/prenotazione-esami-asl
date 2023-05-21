package com.prenotazione.esami.asl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Reparto.COLLECTION_NAME)
public class Reparto {
    public static final String COLLECTION_NAME = "coll_reparti";
    @Id
    @NonNull
    private String codiceReparto;
    @NonNull
    private String codiceOspedale;
    @NonNull
    private String nomeReparto;
    @Size(min = 10, max = 10)
    private String telefonoReparto;
}
