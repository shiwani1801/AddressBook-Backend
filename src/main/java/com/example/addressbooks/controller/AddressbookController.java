package com.example.addressbooks.controller;

import com.example.addressbooks.dto.AddressbookDto;
import com.example.addressbooks.dto.ResponseDto;
import com.example.addressbooks.model.Addressbook;
import com.example.addressbooks.service.IAddressbookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressbookController {
    @Autowired
    IAddressbookService service;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> insert(@Valid @RequestBody AddressbookDto addressbookDto){
        Addressbook addressbook=service.insert(addressbookDto);
        ResponseDto responseDto=new ResponseDto("data inserted sucessfully",addressbook);
        return new ResponseEntity<>(responseDto , HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        List<Addressbook> addressbook=service.getAll();
        ResponseDto responseDto=new ResponseDto("data found",addressbook);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto>delete(@PathVariable long id){
        String delete=service.delete(id);
        ResponseDto responseDto=new ResponseDto("data deleted sucessfully",delete);
        return new ResponseEntity<>(responseDto , HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody AddressbookDto addressbookDto,@PathVariable long id){
        Addressbook addressbook=service.update(addressbookDto,id);
        ResponseDto responseDto=new ResponseDto("data updated sucessfully",addressbook);
        return new ResponseEntity<>(responseDto , HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable long id){
        Optional<Addressbook> addressbook=service.getById(id);
        ResponseDto responseDto=new ResponseDto("data inserted sucessfully",addressbook);
        return new ResponseEntity<>(responseDto , HttpStatus.OK);
    }
    @GetMapping("/address/{address}")
    public ResponseEntity<ResponseDto> address(@PathVariable String address){
        List<Addressbook> address1=service.address(address);
        ResponseDto responseDto=new ResponseDto("Address found sucessfully",address1);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDto> city(@PathVariable String city){
        List<Addressbook> address1=service.city(city);
        ResponseDto responseDto=new ResponseDto("city found sucessfully",address1);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);
    }
    @GetMapping("/zipcode/{zipcode}")
    public ResponseEntity<ResponseDto> zipcode(@PathVariable String zipcode){
        List<Addressbook> address1=service.zipcode(zipcode);
        ResponseDto responseDto=new ResponseDto("zipcode found sucessfully",address1);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);
    }
    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDto> state(@PathVariable String state){
        List<Addressbook> address1=service.state(state);
        ResponseDto responseDto=new ResponseDto("State found sucessfully",address1);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);
    }
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDto> sortByCity(){
        List<Addressbook>addressbooks =service.sortByCity();
        ResponseDto responseDto=new ResponseDto("city arrange sucessfully",addressbooks);
        return new ResponseEntity<>(responseDto , HttpStatus.FOUND);

    }

}
