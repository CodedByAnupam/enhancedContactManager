
import java.util.Scanner;

public class Main {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Welcome to the Enhanced Contact Manager!");

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContactMenu();
                    break;
                case "2":
                    removeContactMenu();
                    break;
                case "3":
                    contactManager.displayContacts();
                    break;
                case "4":
                    sortContactsMenu();
                    break;
                case "5":
                    exportContactsMenu();
                    break;
                case "6":
                    exit = true;
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Display All Contacts");
        System.out.println("4. Sort Contacts");
        System.out.println("5. Export Contacts");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }

    private static void addContactMenu() {
        System.out.println("\nChoose Contact Type to Add:");
        System.out.println("1. Personal Contact");
        System.out.println("2. Business Contact");
        System.out.print("Your choice: ");
        String type = scanner.nextLine().trim();

        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();

            if (type.equals("1")) {
                System.out.print("Enter Birthday (YYYY-MM-DD): ");
                String birthday = scanner.nextLine().trim();
                PersonalContact pc = new PersonalContact(name, phone, email, birthday);
                contactManager.addContact(pc);
            } else if (type.equals("2")) {
                System.out.print("Enter Company: ");
                String company = scanner.nextLine().trim();

                System.out.print("Enter Job Title: ");
                String jobTitle = scanner.nextLine().trim();

                BusinessContact bc = new BusinessContact(name, phone, email, company, jobTitle);
                contactManager.addContact(bc);
            } else {
                System.out.println("Invalid contact type selected.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding contact: " + e.getMessage());
        }
    }

    private static void removeContactMenu() {
        System.out.print("\nEnter the name of the contact to remove: ");
        String nameToRemove = scanner.nextLine().trim();

        Contact contactToRemove = null;
        for (Contact contact : contactManager.getContacts()) {
            if (contact.getName().equalsIgnoreCase(nameToRemove)) {
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null) {
            contactManager.removeContact(contactToRemove);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void sortContactsMenu() {
        System.out.println("\nChoose Sorting Option:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Email (Anonymous Class)");
        System.out.println("3. Sort by Email (Lambda)");
        System.out.println("4. Sort by Phone Number");
        System.out.print("Your choice: ");
        String sortChoice = scanner.nextLine().trim();

        switch (sortChoice) {
            case "1":
                contactManager.sortContactsByName();
                break;
            case "2":
                contactManager.sortContactsByEmail();
                break;
            case "3":
                contactManager.sortContactsByEmailLambda();
                break;
            case "4":
                contactManager.sortContactsByPhoneNumber();
                break;
            default:
                System.out.println("Invalid sorting option.");
        }
    }

    private static void exportContactsMenu() {
        System.out.println("\nChoose Export Format:");
        System.out.println("1. Export to CSV");
        System.out.println("2. Export to JSON");
        System.out.print("Your choice: ");
        String exportChoice = scanner.nextLine().trim();

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine().trim();

        switch (exportChoice) {
            case "1":
                contactManager.exportContactsToCSV(filename);
                break;
            case "2":
                contactManager.exportContactsToJSON(filename);
                break;
            default:
                System.out.println("Invalid export option.");
        }
    }
}
