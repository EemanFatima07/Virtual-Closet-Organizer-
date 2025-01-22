import java.util.ArrayList;
import java.util.Scanner;

class ClosetItem {
    private String type;
    private String color;
    private String size;
    private String season;

    public ClosetItem(String type, String color, String size, String season) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.season = season;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Color: " + color + ", Size: " + size + ", Season: " + season;
    }
}

public class VirtualClosetApp {
    private static ArrayList<ClosetItem> closet = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Closet Organizer!");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewCloset();
                case 3 -> searchItem();
                case 4 -> deleteItem();
                case 5 -> {
                    System.out.println("Exiting... Thank you for using the Virtual Closet Organizer!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add New Item");
        System.out.println("2. View Closet");
        System.out.println("3. Search for an Item");
        System.out.println("4. Delete an Item");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return choice;
    }

    private static void addItem() {
        System.out.print("Enter item type (e.g., Shirt, Pants, Shoes): ");
        String type = scanner.nextLine();
        System.out.print("Enter item color: ");
        String color = scanner.nextLine();
        System.out.print("Enter item size: ");
        String size = scanner.nextLine();
        System.out.print("Enter season (e.g., Summer, Winter): ");
        String season = scanner.nextLine();

        ClosetItem item = new ClosetItem(type, color, size, season);
        closet.add(item);

        System.out.println("Item added successfully!");
    }

    private static void viewCloset() {
        if (closet.isEmpty()) {
            System.out.println("Your closet is empty.");
            return;
        }

        System.out.println("\nYour Closet:");
        for (int i = 0; i < closet.size(); i++) {
            System.out.println((i + 1) + ". " + closet.get(i));
        }
    }

    private static void searchItem() {
        System.out.print("Enter type or color to search: ");
        String searchQuery = scanner.nextLine().toLowerCase();

        System.out.println("\nSearch Results:");
        boolean found = false;
        for (ClosetItem item : closet) {
            if (item.getType().toLowerCase().contains(searchQuery) || item.getColor().toLowerCase().contains(searchQuery)) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching items found.");
        }
    }

    private static void deleteItem() {
        viewCloset();

        if (closet.isEmpty()) {
            return;
        }

        System.out.print("Enter the number of the item to delete: ");
        int itemNumber;

        try {
            itemNumber = Integer.parseInt(scanner.nextLine());
            if (itemNumber < 1 || itemNumber > closet.size()) {
                System.out.println("Invalid item number. Please try again.");
            } else {
                closet.remove(itemNumber - 1);
                System.out.println("Item deleted successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
