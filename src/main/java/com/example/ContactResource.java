package com.example;

import com.example.entity.Contact;
import com.example.model.CreateContactRequest;
import com.example.service.ContactService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/api/contacts")
public class ContactResource {

  private final ContactService contactService;

  @Inject
  public ContactResource(ContactService contactService) {
    this.contactService = contactService;
  }

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public Contact create(CreateContactRequest request) {
    return contactService.save(request);
  }

  @GET
  @Produces("application/json")
  public List<Contact> list() {
    return contactService.list();
  }

  @Path("{name}")
  @GET
  @Produces("application/json")
  public List<Contact> listByName(@PathParam("name") String name) {
    return contactService.listByName(name);
  }

  @Path("{id}")
  @DELETE
  public void delete(@PathParam("id") Long id) {
    contactService.delete(id);
  }

}
