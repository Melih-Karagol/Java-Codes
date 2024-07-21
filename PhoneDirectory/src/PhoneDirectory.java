import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneDirectory {

    private ArrayList<String> contacts;
    private ArrayList<String> numbers;
    private HashMap<String, String> favoriteContacts;

    public PhoneDirectory() {
        contacts = new ArrayList<>();
        numbers = new ArrayList<>();
        favoriteContacts = new HashMap<>();
        System.out.println("Phone directory created.");
    }

    public void addContact(String name, String number) {
        contacts.add(name);
        numbers.add(number);
    }

    public void deleteContact(String name) {
        int index = contacts.indexOf(name);
        if (index != -1) {
            System.out.println(name + " successfully deleted!");
            contacts.remove(index);
            numbers.remove(index);
        } else {
            System.out.println("No contact found with this name: " + name + " in the directory!");
        }
    }

    public void updateContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press '1' to update the contact's number, " +
                "Press '2' to update the contact's name");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Please enter the full name of the contact you want to update the number for:");
            String name = scanner.nextLine();
            int index = contacts.indexOf(name);
            if (index != -1) {
                System.out.println("Please enter the new number for " + name + ":");
                String newNumber = scanner.nextLine();
                System.out.println("Number for " + name + " successfully updated: number: " + newNumber);

                numbers.set(index, newNumber);

                // Update the number in the favoriteContacts list if the contact is a favorite
                if (favoriteContacts.containsKey(name)) {
                    favoriteContacts.put(name, newNumber);
                }
            } else {
                System.out.println("No contact found with this name: " + name + " in the directory!");
            }
        } else if (choice == 2) {
            System.out.println("Please enter the name of the contact you want to update:");
            String name = scanner.nextLine();
            int index = contacts.indexOf(name);
            if (index != -1) {
                System.out.println("Please enter the new name for " + name + ":");
                String newName = scanner.nextLine();
                System.out.println("Name of " + name + " changed. New name: " + newName);

                // Update the contact name
                contacts.set(index, newName);

                // Update the number and name in the favoriteContacts list if the contact is a favorite
                if (favoriteContacts.containsKey(name)) {
                    String number = favoriteContacts.remove(name);
                    favoriteContacts.put(newName, number);
                }
            } else {
                System.out.println("No contact found with this name: " + name + " in the directory!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public void searchContact(String name) {
        if (contacts.contains(name)) {
            int index = contacts.indexOf(name);
            System.out.println(name + " found. Number: " + numbers.get(index));
        } else {
            System.out.println("No contact found with this name: " + name + " in the directory!");
        }
    }

    public void seeAllContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i) + " " + numbers.get(i));
        }
    }

    public void addFavoriteContact(String name, String number) {

        favoriteContacts.put(name, number);
    }

    public void seeFavoriteContacts() {
        for (String name : favoriteContacts.keySet()) {
            System.out.println(name + " " + favoriteContacts.get(name));
        }
    }
}
