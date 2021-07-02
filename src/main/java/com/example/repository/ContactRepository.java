package com.example.repository;

import com.example.entity.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ContactRepository implements PanacheRepository<Contact> {

  public List<Contact> findAllByName(String name) {
    return list("name", name);
  }

}