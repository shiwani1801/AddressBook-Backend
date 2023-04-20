package com.example.addressbooks.repository;

import com.example.addressbooks.model.Addressbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressbookRepository extends JpaRepository<Addressbook,Long> {
    @Query(value = "SELECT * FROM addressbook.addressbook,addressbook.address_table where addressbook.address_book_id=address_table.id and address_table.address=:address ",nativeQuery = true)
    List<Addressbook> getAddress(String address);
    @Query(value = "SELECT * FROM addressbook.addressbook,addressbook.city_table where addressbook.address_book_id=city_table.id and city_table.city=:city ",nativeQuery = true)
    List<Addressbook> getCity(String city);
    @Query(value = "SELECT * FROM addressbook.addressbook,addressbook.zipcode_table where addressbook.address_book_id=zipcode_table.id and zipcode_table.zipcode=:zipcode ",nativeQuery = true)
    List<Addressbook> getZipcode(String zipcode);
    @Query(value = "SELECT * FROM addressbook.addressbook,addressbook.state_table where addressbook.address_book_id=state_table.id and state_table.state=:state ",nativeQuery = true)
    List<Addressbook> getState(String state);
    @Query(value = "SELECT * FROM addressbook.addressbook,addressbook.city_table ORDER BY city_table.city ",nativeQuery = true)
    List<Addressbook> sortByCity();
}
