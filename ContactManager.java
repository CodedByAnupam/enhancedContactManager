
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContactManager {
    private ArrayList<Contact> contacts;

    
    public ContactManager() {
        contacts = new ArrayList<>();
    }

    
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    
    public void removeContact(Contact contact) {
        if (contacts.remove(contact)) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println("------------------------------");
            System.out.println(contact);
        }
        System.out.println("------------------------------");
    }

    
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    
    public void sortContactsByName() {
        Collections.sort(contacts);
        System.out.println("Contacts sorted by name.");
    }

    
    public void sortContactsByEmail() {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getEmail().compareToIgnoreCase(c2.getEmail());
            }
        });
        System.out.println("Contacts sorted by email.");
    }

    
    public void sortContactsByEmailLambda() {
        contacts.sort((c1, c2) -> c1.getEmail().compareToIgnoreCase(c2.getEmail()));
        System.out.println("Contacts sorted by email using lambda.");
    }

    
    public void sortContactsByPhoneNumber() {
        Collections.sort(contacts, Comparator.comparing(Contact::getPhoneNumber, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Contacts sorted by phone number.");
    }

    
    public void exportContactsToCSV(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts) {
                writer.write(contact.toCSV());
                writer.newLine();
            }
            System.out.println("Contacts exported to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting contacts to CSV: " + e.getMessage());
        }
    }

    
    public void exportContactsToJSON(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("[\n");
            for (int i = 0; i < contacts.size(); i++) {
                writer.write("  " + contacts.get(i).toJSON());
                if (i < contacts.size() - 1) {
                    writer.write(",");
                }
                writer.newLine();
            }
            writer.write("]");
            System.out.println("Contacts exported to JSON successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting contacts to JSON: " + e.getMessage());
        }
    }
}
