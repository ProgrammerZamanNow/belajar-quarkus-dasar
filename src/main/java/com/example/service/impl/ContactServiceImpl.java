package com.example.service.impl;

import com.example.entity.Contact;
import com.example.model.CreateContactRequest;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;

  @Inject
  public ContactServiceImpl(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  @Transactional
  public Contact save(CreateContactRequest request) {
    Contact contact = new Contact();
    contact.setName(request.getName());

    contactRepository.persist(contact);

    return contact;
  }

  @Override
  @Transactional
  public List<Contact> list() {
    return contactRepository.listAll();
  }

  @Override
  @Transactional
  public List<Contact> listByName(String name) {
    return contactRepository.findAllByName(name);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Contact contact = contactRepository.findById(id);
    if (contact != null) {
      contactRepository.delete(contact);
    }
  }
}
