package com.bookApi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookApi.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{

}
