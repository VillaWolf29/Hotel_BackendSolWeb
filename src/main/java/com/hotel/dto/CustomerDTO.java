package com.hotel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private int idCustomer;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 70, message = "El nombre debe tener entre 3 y 70 caracteres")
    private String firstName;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 70, message = "El apellido debe tener entre 3 y 70 caracteres")
    private String lastName;

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    private String email;

    @NotNull(message = "El número de teléfono no puede ser nulo")
    @Pattern(regexp = "^[0-9]{9}$", message = "El número de teléfono debe contener exactamente 9 dígitos")
    private String phone;

    @NotNull(message = "El número de documento no puede ser nulo")
    @Pattern(regexp = "^[0-9]{8}$", message = "El número de documento debe contener exactamente 8 dígitos")
    private String idCard;

    @Size(max = 100, message = "La dirección no debe superar los 100 caracteres")
    private String address;
}
