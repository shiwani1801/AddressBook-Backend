package com.example.addressbooks.service;

import com.example.addressbooks.dto.AddressbookDto;
import com.example.addressbooks.exception.AddressbookException;
import com.example.addressbooks.model.Addressbook;
import com.example.addressbooks.model.address.Address;
import com.example.addressbooks.repository.AddressbookRepository;
import com.example.addressbooks.utility.EmailSenderService;
import com.example.addressbooks.utility.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressbookService implements IAddressbookService {
    @Autowired
    AddressbookRepository repo;
    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    EmailSenderService senderService;

    public Addressbook insert(AddressbookDto addressbookDto) {
        Addressbook addressbook1 = new Addressbook(addressbookDto);
        repo.save(addressbook1);
        senderService.sendMail(addressbook1.getEmail(), "You are registerd in addressbook app successfully....", "name: " + addressbook1.getName() + "phoneNumber: " + addressbook1.getPhoneNumber() + "city: " + addressbook1.getCity() + "state: " + addressbook1.getState() + "zipcode: " + addressbook1.getZipcode() + "email: " + addressbook1.getEmail() + "address: " + addressbook1.getAddress());
        return addressbook1;
    }

    public List<Addressbook> getAll() {

        List<Addressbook> addressbooks = repo.findAll();
        return addressbooks;
    }

    public String delete(long id) {
        repo.deleteById(id);
        return "data found";
    }

    public List<Addressbook> address(String address) {
        List<Addressbook> addressbooks = repo.getAddress(address);
        if (addressbooks.isEmpty()) {
            throw new AddressbookException("address is not present");

        } else {
            return addressbooks;
        }
    }

    @Override
    public List<Addressbook> city(String city) {
        List<Addressbook> addressbooks = repo.getCity(city);
        if (addressbooks.isEmpty()) {
            throw new AddressbookException("city is not present");

        } else {
            return addressbooks;
        }
    }

    @Override
    public List<Addressbook> zipcode(String zipcode) {
        List<Addressbook> addressbooks = repo.getZipcode(zipcode);
        if (addressbooks.isEmpty()) {
            throw new AddressbookException("zipcode is not present");
        } else {
            return addressbooks;

        }
    }

    @Override
    public List<Addressbook> state(String state) {
        List<Addressbook> addressbooks = repo.getState(state);
        if (addressbooks.isEmpty()) {
            throw new AddressbookException("state is not present");

        } else {
            return addressbooks;
        }
    }

    @Override
    public Addressbook update(AddressbookDto addressbookDto, long id) {
        Addressbook addressbook = repo.findById(id).get();
        if (repo.findById(id).isPresent()) {
            addressbook.setName(addressbookDto.getName());
            addressbook.setPhoneNumber(addressbookDto.getPhoneNumber());
            addressbook.setCity(addressbookDto.getCity());
            addressbook.setState(addressbookDto.getState());
            addressbook.setZipcode(addressbookDto.getZipcode());
            addressbook.setEmail(addressbookDto.getEmail());
            addressbook.setAddress(addressbookDto.getAddress());
            repo.save(addressbook);
            return addressbook;
        } else {
            throw new AddressbookException("id is not present");
        }
    }

    @Override
    public Optional<Addressbook> getById(long id) {
        Optional<Addressbook> addressbook = repo.findById(id);
        if (addressbook.isPresent()) {
            return addressbook;
        } else {
            throw new AddressbookException("id is not present");

        }
    }

    @Override
    public List<Addressbook> sortByCity() {
        List<Addressbook> addressbooks = repo.sortByCity();
        return addressbooks;
    }


}