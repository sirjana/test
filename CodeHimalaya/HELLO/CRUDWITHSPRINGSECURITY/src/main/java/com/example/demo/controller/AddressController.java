package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.Course;
import com.example.demo.service.AddressService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("address/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> saveAddress(@RequestBody Address address) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        addressService.Save(address);
        map.put("status", 1);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAddress() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<Address> addresslist = addressService.getAllAddress();
        if (!addresslist.isEmpty()) {
            map.put("status", 1);
            map.put("data", addresslist);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody Address address) {
        addressService.update(id, address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
