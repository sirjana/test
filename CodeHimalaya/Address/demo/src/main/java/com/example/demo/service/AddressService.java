package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Course;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void Save(Address address)
    {
        addressRepository.save(address);
    }

    public List<Address> getAllAddress() {
        List<Address> addresses = new ArrayList<Address>();
        addressRepository.findAll().forEach(address1 -> addresses.add(address1));;
        return addresses;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).get();

    }
    public void delete(Long id ) {
        addressRepository.deleteById(id);
    }

    public void update(Long id, Address address) {
        Address address1 = addressRepository.findById(id).get();
        address1.setState(address.getState());
        address1.setStreet(address.getStreet());
        address1.setZip(address.getZip());
        addressRepository.save(address1);
    }
}
