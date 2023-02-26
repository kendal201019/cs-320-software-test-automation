package contact;


import java.util.Scanner;
import java.util.ArrayList;

public class ContactService extends contact {
    public ContactService(String contactID, String firstName, String lastName, String phone, String address) {
        super(contactID, firstName, lastName, phone, address);
    }

    static Scanner scnr = new Scanner(System.in);
    String userInput;
    static char inputChar;
    private static ArrayList<contact> contactList = new ArrayList<contact>();
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("Please select an option below");
        System.out.println("[1] Add contact");
        System.out.println("[2] Delete contact");
        System.out.println("[3] Update contact");
        System.out.println("[4] Print all contacts");
        System.out.println("[q] To quit application");
        System.out.println();
        System.out.println("Enter a menu selection:");
        inputChar = scnr.nextLine().charAt(0);

        switch(inputChar) {
            case '1':
                addContact(scnr);
                break;
            case '2':
                System.out.println("\nEnter contact ID");
                Scanner in = new Scanner(System.in);
                String info = in.nextLine();
                contact contact = findPerson(contactList, info);
                if(contact != null) {
                    System.out.println(contact.getFirstName() + contact.getLastName());
                    System.out.println("\nAre you sure you want to delete contact (Y/N)");
                    String delete = in.nextLine();
                    if(delete.equalsIgnoreCase("y")) {
                        contactList.remove(contact);
                        System.out.println("\nContact deleted");
                        displayMenu();
                    }
                    else {
                        System.out.println("contact not found");
                        displayMenu();
                    }
                }
            case '3':
                System.out.println("Enter contact ID");
                Scanner in1 = new Scanner(System.in);
                String info1 = in1.nextLine();
                contact contact1 = findPerson(contactList, info1);
                if(contact1 != null) {
                    System.out.println("Would you like to update info for" + " " + contact1.getFirstName()+ " " + contact1.getLastName() + "? (Y/N)");
                    String update = in1.nextLine();
                    if(update.equalsIgnoreCase("y")) {
                        System.out.println("would you like to update first name? (y/n)");
                        String updatefn = in1.nextLine();
                        if(updatefn.equalsIgnoreCase("y")) {
                            System.out.println("\nEnter First Name");
                            String fn = in1.nextLine();
                            contact1.setFirstName(fn);
                        }
                        else {
                            System.out.println("\nfirst name not updated");
                        }
                        System.out.println("Would you like to update last name? (y/n)");
                        String updateln = in1.nextLine();
                        if(updateln.equalsIgnoreCase("y")) {
                            System.out.println("\nEnter last name");
                            String ln = in1.nextLine();
                            contact1.setLastName(ln);
                        }
                        else {
                            System.out.println("\nLast name not updated");
                        }
                        System.out.println("Would you like to update phone? (y/n)");
                        String updatep = in1.nextLine();
                        if(updatep.equalsIgnoreCase("y")) {
                            System.out.println("\nEnter new phone");
                            String phone = in1.nextLine();
                            contact1.setPhone(phone);
                        }
                        else {
                            System.out.println("\nPhone not updated");
                        }
                        System.out.println("Would you like to update address? (y/n)");
                        String updateA = in1.nextLine();
                        if(updateA.equalsIgnoreCase("y")) {
                            System.out.println("\nEnter new address");
                            String address = in1.nextLine();
                            contact1.setAddress(address);
                        }
                        else {
                            System.out.println("\naddress not updated");
                        }
                    }
                    else {
                        System.out.println("contact not found or updated");
                        displayMenu();
                    }
                }
            case '4':
                for(int i = 0; i < contactList.size(); i++) {
                    contact c = contactList.get(i);
                    System.out.println("Contact ID: " + c.getContactID());
                    System.out.println(c.getFirstName() + " " + c.getLastName());
                    System.out.println("Phone: " + c.getPhone());
                    System.out.println("Address: " + c.getAddress());
                    System.out.println();
                }
                displayMenu();
            case 'q':
                System.exit(0);
            default:
                System.out.println("Select a menu item");
                displayMenu();
        }
    }
    public static void addContact(Scanner scanner) {
        System.out.println("Enter an unique ID for contact");
        final String contactID = scanner.nextLine();

        System.out.println("Enter contact first name");
        String firstName = scanner.nextLine();

        System.out.println("Enter contact last name");
        String lastName = scanner.nextLine();

        System.out.println("Enter contact phone number");
        String phone = scanner.nextLine();

        System.out.println("Enter contact address");
        String address = scanner.nextLine();

        contact newcontact = new contact(contactID, firstName, lastName, phone, address);
        contactList.add(newcontact);
        displayMenu();
    }
    public static contact findPerson(ArrayList<contact> contactlist, String info) {
        contact c = null;
        for(int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getContactID().indexOf(info) != -1)
                c = contactList.get(i);
        }
        return c;
    }
}


