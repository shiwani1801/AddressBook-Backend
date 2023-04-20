package com.example.addressbooks.model;

import com.example.addressbooks.dto.AddressbookDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Addressbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressBookId;
    private String name;
    private String phoneNumber;
    @ElementCollection
    @CollectionTable(name = "city_table",joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> city;
    @ElementCollection
    @CollectionTable(name = "state_table",joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> state;
    @ElementCollection
    @CollectionTable(name = "zipcode_table",joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> zipcode;
    private String email;
    @ElementCollection
    @CollectionTable(name = "address_table",joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> address;


    public Addressbook(AddressbookDto addressbookDto) {
        this.name = addressbookDto.getName();
        this.phoneNumber = addressbookDto.getPhoneNumber();
        this.city = addressbookDto.getCity();
        this.state = addressbookDto.getState();
        this.zipcode = addressbookDto.getZipcode();
        this.email = addressbookDto.getEmail();
        this.address = addressbookDto.getAddress();
    }
}
