package com.example.addressbooks.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class AddressbookDto {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{1,}\\s{1}[A-Z]{1}[a-z]{1,}$",message = "First and last name should start with capital letter")
    private String name;
    @Pattern(regexp = "^[0-9]{10}$",message = "number should be 10")

    private String phoneNumber;
    private List<String> city;
    private List<String> state;
    private List<String> zipcode;
    @NotEmpty(message = "not empty")

    private String email;
    private List<String> address;
}
