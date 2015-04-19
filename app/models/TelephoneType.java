package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * The Telephone Type class holds various Telephone Types such as Mobile, Home, etc.
 */
@Entity
public class TelephoneType {
  @Id
  private long id;
  private String telephoneType;
  @OneToMany(mappedBy = "contact", cascade = CascadeType.PERSIST)
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Finder method for database queries.
   *
   * @return The found item.
   */
  public static Model.Finder<Long, TelephoneType> find() {
    return new Model.Finder<Long, TelephoneType>(Long.class, TelephoneType.class);
  }

  /**
   * Get the ID.
   *
   * @return The ID.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID for the TelephoneType.
   *
   * @param id The ID to set.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the Telephone Type.
   *
   * @return the telephoneType String.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Set the telephone Type String.
   *
   * @param telephoneType The Telephone Type to set.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Get the list of Contacts associated with this Telephone Type.
   *
   * @return A list of Contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Set the list of contacts associated with this Telephone Type.
   *
   * @param contacts A list of Contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Add a new Contact to the list of Contacts associated with this Telephone Type.
   *
   * @param contact The Contact to add.
   */
  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  /**
   * Create a new TelephoneType.
   *
   * @param telephoneType The name String of the TelephoneType.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
}