package com.example.addressbooks.model.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor
public class Address {
    @Id
    private Integer addressBookId;
    private String addressbookName;
    private long numberOfBooks;




}
