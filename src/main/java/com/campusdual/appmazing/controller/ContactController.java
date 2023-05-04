package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacts controller works, " + name + "!";
    }

    @PostMapping(value = "/get")
    public ContactDto queryContact(@RequestBody ContactDto contactDto){
        return contactService.queryContact(contactDto);
    }

    @GetMapping(value = "/getAll")
    public List<ContactDto> queryAllContacts(){
        return contactService.queryAllContacts();
    }

    @PostMapping(value = "/add")
    public int addContact(@RequestBody ContactDto contactDto){
        return contactService.insertContact(contactDto);
    }

    @PutMapping(value = "/update")
    public int updateContact(@RequestBody ContactDto contactDto){
        return contactService.updateContact(contactDto);
    }

    @DeleteMapping(value = "/delete")
    public int deleteContact(@RequestBody ContactDto contactDto){
        return contactService.deleteContact(contactDto);
    }

}
