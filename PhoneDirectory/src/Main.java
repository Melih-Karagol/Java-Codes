public class Main {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Add new contacts to the directory
        phoneDirectory.addContact("Ali", "053540555665");
        phoneDirectory.addContact("Selim", "05477992251");
        System.out.println("***********************");

        // Display all contacts
        System.out.println("All Contacts:");
        phoneDirectory.seeAllContacts();
        System.out.println("***********************");

        // Delete a contact from the directory
        phoneDirectory.deleteContact("Ali");  // Deletes contact "Ali"
        phoneDirectory.deleteContact("Cenk"); // Attempt to delete contact "Cenk" which does not exist
        System.out.println("***********************");

        // Display all contacts again
        System.out.println("All Contacts after deletion:");
        phoneDirectory.seeAllContacts();
        System.out.println("***********************");

        // Search for a contact
        phoneDirectory.searchContact("Ali");   // Search for contact "Ali", should not be found
        phoneDirectory.searchContact("Selim"); // Search for contact "Selim"
        System.out.println("***********************");

        // Update a contact (number)
        phoneDirectory.updateContact(); // Prompts user to enter details for updating a contact

        // Display all contacts again
        System.out.println("All Contacts after update:");
        phoneDirectory.seeAllContacts();
        System.out.println("***********************");

        // Add a contact to favorites
        phoneDirectory.addFavoriteContact("Mehmet", "053877744110"); // Add contact "Mehmet" to favorites
        System.out.println("***********************");

        // Display all favorite contacts
        System.out.println("Favorite Contacts:");
        phoneDirectory.seeFavoriteContacts();
    }
}
