package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> contactBook = new HashMap<>();
        int choice;

        do{
            System.out.println("#### Contact Book ####");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Show Contact Book");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: System.out.println("Enter Contact Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter phone number: ");
                    String number = sc.nextLine();
                    contactBook.put(name, number);
                    System.out.println("Contact Added Successfully");
                    break;
                case 2:
                    System.out.println("Enter name to delete : ");
                    String deltedName = sc.nextLine();
                    if(contactBook.containsKey(deltedName)) {
                        contactBook.remove(deltedName);
                        System.out.println("Contact Deleted Successfully");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter name to search: ");
                    String searchName = sc.nextLine();
                    if(contactBook.containsKey(searchName)) {
                        System.out.println(contactBook.get(searchName));
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 4:
                    System.out.println("All Contacts :");
                    for(Map.Entry<String, String> entry : contactBook.entrySet()){
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 5);
        sc.close();
    }
}
