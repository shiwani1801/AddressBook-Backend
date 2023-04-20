package com.example.addressbooks.service;

import com.example.addressbooks.dto.AddressbookDto;
import com.example.addressbooks.model.Addressbook;

import java.util.List;
import java.util.Optional;

public interface IAddressbookService {

    Addressbook insert(AddressbookDto addressbookDto);

    List<Addressbook> getAll();

    String delete(long id);

    List<Addressbook> address(String address);

    List<Addressbook> city(String city);

    List<Addressbook> zipcode(String zipcode);

    List<Addressbook> state(String state);

    Addressbook update(AddressbookDto addressbookDto, long id);

    Optional<Addressbook> getById(long id);


    List<Addressbook> sortByCity();
}
