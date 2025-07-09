package com.udea.virtualvuelo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_flight")
    private long idFlight;

    @Column(name = "nombre_avion", nullable = false, length = 80)
    private @NonNull String nombreAvion;

    @Column(name = "numero_vuelo", nullable = false, length = 80)
    private @NonNull String numeroVuelo;

    @Column(name = "origen", nullable = false, length = 80)
    private @NonNull String origen;

    @Column(name = "destino", nullable = false, length = 80)
    private @NonNull String destino;

    @Column(name = "capacidad", nullable = false)
    private @NonNull int capacidad;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "Debe ser mayor o igual a 1")
    @Max(value = 5, message = "Debe ser menor o igual a 5")
    private @NonNull int rating;

    @Column(name = "plan_vuelo", nullable = false)
    private @NonNull Long planVuelo;

    private Boolean cumplido;

}
