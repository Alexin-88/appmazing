package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto queryContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        return ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contact.getId()));
    }

    @Override
    public List<ContactDto> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    @Override
    public int insertContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDto contactDto) {
        return insertContact(contactDto);
    }

    @Override
    public int deleteContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.delete(contact);
        return contact.getId();
    }

    @Override
    public int updateSecureContact(ContactDto contactDto){
        ContactDto contactBBDD = ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contactDto.getId()));
        if(contactBBDD != null){
            if(contactDto.getName() != null){
                contactBBDD.setName(contactDto.getName());
            }
            if (contactDto.getSurname() != null ){
                contactBBDD.setSurname(contactDto.getSurname());
            }

            if (contactDto.getSurname2() != null){
                contactBBDD.setSurname2(contactDto.getSurname2());
            }

            if(contactDto.getPhone() != null){
                contactBBDD.setPhone(contactDto.getPhone());
            }
            if(contactDto.getEmail() != null){
                contactBBDD.setEmail((contactDto.getEmail()));
            }
            return updateContact(contactBBDD);
        }else{
            return -1;
        }

    }
}
