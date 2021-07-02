package com.example.service;

import com.example.entity.Contact;
import com.example.model.CreateContactRequest;

import java.util.List;

public interface ContactService {

  Contact save(CreateContactRequest request);

  List<Contact> list();

  List<Contact> listByName(String name);

  void delete(Long id);

}
