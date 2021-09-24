package phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    Scanner input = new Scanner(System.in);
    //we create an array list "contacts" where we store the list of contacts from the Contact class.
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    //add Contacts
    public String addContact(Contact contact) {
        this.contacts.add(contact);//method adds contact to the "contacts" arraylist
        return contact.name + "\n Added successfully";
    }
// view all contacts
public ArrayList<Contact> getAllContacts() {//creating a method that returns an array of all cars
    return contacts;
}
//find Contact by Name
public Contact findByName(String name) {
    for (Contact contact : contacts) {
        if (contact.name.equals(name)) {
            return contact;
        }
    }
    return null;
}
// find Contact by Phone Number
    public Contact findByPhoneNumber(String phoneNumber){
        for(Contact contact:contacts){
            if(contact.phoneNumber.equals(phoneNumber)){
                return contact;
            }
        }
        return null;
}
//find Contact by part of the Name
public ArrayList<Contact>findByPartName(String partName) {
    ArrayList<Contact> searchByPart = new ArrayList<Contact>();//made a new array list
    for (Contact contact : contacts) {
        if (contact.name.contains(partName)) {
            searchByPart.add(contact);
        }

    }
    return searchByPart;
}

//    remove by Name
        public String removeContact (int contactIndex){
            try {
                this.contacts.remove(contactIndex);
            } catch (Exception exc) {
                return "Unable to remove specified contact";
            }
            {
                return "Contact removed";
            }
        }
//    public void removeContact(Contact contact) {
//        int contactID;
//        contactID = contacts.indexOf(contact);
//        contacts.remove(contactID);
//        System.out.println("Contact" + contact.name);
//    }
        //removeByPartName

        public ArrayList<Contact>removeByPartName(String partName) {

            for (Contact contact :contacts ) {
                if (contact.name.contains(partName)) {
                    contacts.indexOf(contact);
                    this.contacts.remove(contacts.indexOf(contact));
                }
            }
            return contacts;
        }
        //Update contact by name
        public Contact updateContact ( int contactIndex, Contact contact){
            return contacts.set(contactIndex, contact);
        }
    }











