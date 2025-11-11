package com.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {

    private int idRoom;

    @NotNull(message = "El número de habitación no puede ser nulo")
    @Positive(message = "El número de habitación debe ser mayor que cero")
    private Integer numRoom;

    @NotNull(message = "El tipo de habitación no puede ser nulo")
    @NotBlank(message = "El tipo de habitación no puede estar vacío")
    @Size(min = 3, max = 30, message = "El tipo de habitación debe tener entre 3 y 30 caracteres")
    @Pattern(
            regexp = "^(individual|doble|suite|familiar)$",
            message = "El tipo de habitación debe ser: individual, doble, suite o familiar"
    )
    private String type;

    @NotNull(message = "La capacidad no puede ser nula")
    @NotBlank(message = "La capacidad no puede estar vacía")
    @Pattern(
            regexp = "^(1|2|3|4|5|6|7|8|9|10)$",
            message = "La capacidad debe ser un número entre 1 y 10 personas"
    )
    private String ability; // número de personas

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser mayor que cero")
    private Double price;

    @NotNull(message = "El estado de la habitación no puede ser nulo")
    private Boolean state; // true = disponible, false = ocupada
}
