import phone.Contact;
import phone.PhoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    PhoneBook phoneBook = new PhoneBook();
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();
        main.showMenu();

    }

    void showMenu() {

        String userInput = "";

        do {
            System.out.println("\"Menu\"");
            System.out.println("1 - Add new contact\n");
            System.out.println("2 - View all contacts\n");
            System.out.println("3 - Search contacts by part of name\n");
            System.out.println("4 - Search contacts by name\n");
            System.out.println("5 -Search contacts by phone number \n");
            System.out.println("6 - Remove contacts by name\n");
            System.out.println("7- Remove contacts by phone number\n");
            System.out.println("8- Remove contacts by part of name\n");
            System.out.println("9 - Update contacts by name\n");
            System.out.println("10 -Update contacts by phone number \n");
            System.out.println("11 -Update contacts by part of name\n");
            System.out.println("\nEnter Quit to end program...");

            System.out.println("Choose a number:");
            userInput = input.nextLine();

            switch (userInput) {
                case "Quit":
                case "QUIT":
                    System.out.println("Exiting Application...");
                    break;
                case "1":
                    addContact();
                    break;
                case "2":
                    viewAllContacts();
                    break;
                case "3":
                    findByPartName();
                    break;
                case "4":
                    findByName();
                    break;
                case "5":
                    findByPhoneNumber();
                    break;
                case "6":
                    removeContactByName();
                    break;
                case "7":
                    removeContactByPhoneNumber();
                    break;
                case "8":
                    removeByPartName();
                    break;
                case "9":
                    updateContact();
                    break;
                case "10":
                    updateContactByPhoneNumber();
                    break;
                case "11":
                    break;
                default:

            }

        } while (!userInput.equalsIgnoreCase("Quit"));
        return;
    }

    void addContact() {
        System.out.println("Add Contact");
        Contact contact = new Contact();

        System.out.println("Name: ");
        contact.name = input.nextLine();

        System.out.println("Phone Number: ");
        contact.phoneNumber = input.nextLine();

        System.out.println("E-mail: ");
        contact.email = input.nextLine();


        String message = phoneBook.addContact(contact);
        System.out.println(message);
    }

    void viewAllContacts() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("View All contacts");
        System.out.println("Name \t PhoneNumber \t E-mail");
        for (Contact contact : allContacts) {
            System.out.println(contact.name + '\t' + contact.phoneNumber + '\t' + contact.email);
        }
    }
//    void findByName() {
//        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
//        System.out.println("Please enter contact name:");
//        for (Contact contact : allContacts) {
//            Pattern contactName = Pattern.compile(contact.name);
//            Matcher userInput = contactName.matcher(input.nextLine());
//            if (userInput.find()) {
//                System.out.println("You found:" + "\nName: " + contact.name + "\nPhone: " + contact.phoneNumber + "\nEmail: " + contact.email);
//            } else {
//                System.out.println("cannot find this contact, try again");
//            }
//        }


 void findByName() {
System.out.println("Find contact by name: ");
System.out.println("Enter name: ");
String contactName = input.nextLine();
Contact contact = phoneBook.findByName(contactName);
System.out.println("phone number: " + contact.phoneNumber);
System.out.println("e-mail: " + contact.email);

}

void findByPhoneNumber() {
System.out.println("Find contact by number: ");
System.out.println("Enter phone number: ");
String contactPhoneNumber = input.nextLine();
Contact contact = phoneBook.findByPhoneNumber(contactPhoneNumber);
System.out.println("contact name: " + contact.name);
System.out.println("e-mail: " + contact.email);
}
void  findByPartName(){
System.out.println("Find contact by part of the name: ");
System.out.println("Enter part of the name: ");

String contactName = input.nextLine();
ArrayList<Contact> searchByPart= phoneBook.findByPartName(contactName);
for(Contact contact : searchByPart) {
    System.out.println("Contact name:"+ contact.name);
    System.out.println("Contact e-mail: " + contact.email);
    System.out.println("Contact phone number: " + contact.phoneNumber);
}
}
    void  removeByPartName(){
        System.out.println("Remove contact by part of the name: ");
        System.out.println("Enter part of the name: ");

        String contactName = input.nextLine();


        int contactIndex = phoneBook.getAllContacts().contacts.indexOf(contact);
        System.out.println(phoneBook.removeByPartName(contactIndex);

         {
            System.out.println("Contact name :"+ contact.name);
            System.out.println("Contact e-mail: " + contact.email);
            System.out.println("Contact phone number: " + contact.phoneNumber);
            System.out.println("Deleted successfully");
        }
    }

    void removeContactByName() {

        System.out.println("Remove Contact By Name..");
        System.out.println("Enter  Contact Name:");

        String contactName = input.nextLine();

        Contact contact = phoneBook.findByName(contactName);
        int contactIndex = phoneBook.getAllContacts().indexOf(contact);
        System.out.println(phoneBook.removeContact(contactIndex));

    }
    void removeContactByPhoneNumber() {

        System.out.println("Remove Contact By Phone Number..");
        System.out.println("Enter  Contact Phone Number:");

        String contactPhoneNumber = input.nextLine();

        Contact contact = phoneBook.findByPhoneNumber(contactPhoneNumber);
        int contactIndex = phoneBook.getAllContacts().indexOf(contact);
        System.out.println(phoneBook.removeContact(contactIndex));

    }
    void updateContact() {
        System.out.println("Update Contact...");
        System.out.println("Enter Contact name:");
        String contactName = input.nextLine();

        Contact contact = phoneBook.findByName(contactName);
        int contactIndex = phoneBook.getAllContacts().indexOf(contact);
        System.out.println("Enter the option you would like to change:");
        String option = input.nextLine();

        System.out.println("Enter the new value of:"+option);
        String value = input.nextLine();

        switch (option){
            case"name":
                contact.name =value;
                break;
            case"phoneNumber":
                contact.phoneNumber = value;
                break;
            case"email":
                contact.email = value;
                break;
            default:
                System.out.println("Please provide a valid person");
                break;
        }
        phoneBook.updateContact(contactIndex,contact);
        System.out.println(contact.name + "\nupdated successfully");
    }
    void updateContactByPhoneNumber() {
        System.out.println("Update Contact...");
        System.out.println("Enter Contact Phone Number:");
        String contactPhoneNumber = input.nextLine();

        Contact contact = phoneBook.findByPhoneNumber(contactPhoneNumber);

        int contactIndex = phoneBook.getAllContacts().indexOf(contact);
        System.out.println("Enter the option you would like to change:");
        String option = input.nextLine();

        System.out.println("Enter the new value of:"+option);
        String value = input.nextLine();

        switch (option){
            case"name":
                contact.name =value;
                break;
            case"phoneNumber":
                contact.phoneNumber = value;
                break;
            case"email":
                contact.email = value;
                break;
            default:
                System.out.println("Please provide a valid person");
                break;
        }
        phoneBook.updateContact(contactIndex,contact);
        System.out.println(contact.phoneNumber + "\nupdated successfully");
    }
}






