package com.travelgo.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "packages")
@Data
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;          // Nombre del paquete

    @NotBlank
    private String destination;   // Destino principal

    @Min(1)
    private Integer durationDays; // Duración en días

    private String category;      // Categoría del paquete

    @Min(0)
    private Integer stock;        // Cupos disponibles

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price;     // Precio

    private String imageUrl;      // URL de la imagen
}
