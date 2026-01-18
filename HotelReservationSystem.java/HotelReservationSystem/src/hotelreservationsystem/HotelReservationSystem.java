import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }
}

class Booking {
    String customerName;
    Room room;

    Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Add rooms
        rooms.add(new Room(101, "Standard", 1000));
        rooms.add(new Room(102, "Deluxe", 2000));
        rooms.add(new Room(103, "Suite", 3000));
        rooms.add(new Room(104, "Luxury", 4000));

        while (true) {
            System.out.println("\n--- HOTEL RESERVATION SYSTEM ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            System.out.println("Room No: " + r.roomNumber +
                    " | Type: " + r.type +
                    " | Price: ₹" + r.price +
                    " | Available: " + r.isAvailable);
        }
    }

    static void bookRoom() {
        System.out.print("Enter your name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter room number: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == roomNo && r.isAvailable) {

                System.out.println("Room Price: ₹" + r.price);
                System.out.print("Confirm payment? (yes/no): ");
                sc.nextLine();
                String pay = sc.nextLine();

                if (pay.equalsIgnoreCase("yes")) {
                    r.isAvailable = false;
                    bookings.add(new Booking(name, r));
                    System.out.println("Booking confirmed!");
                } else {
                    System.out.println("Payment cancelled!");
                }
                return;
            }
        }
        System.out.println("Room not available!");
    }

    static void cancelBooking() {
        System.out.print("Enter room number to cancel: ");
        int roomNo = sc.nextInt();

        for (Booking b : bookings) {
            if (b.room.roomNumber == roomNo) {
                b.room.isAvailable = true;
                bookings.remove(b);
                System.out.println("Booking cancelled!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    static void viewBookings() {
        System.out.println("\nCurrent Bookings:");
        for (Booking b : bookings) {
            System.out.println("Customer: " + b.customerName +
                    " | Room No: " + b.room.roomNumber +
                    " | Type: " + b.room.type);
        }
    }
}
