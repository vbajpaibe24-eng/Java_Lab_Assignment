package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;

public class Main {

    public static void main(String[] args) {

        LibraryResource[] resources =
                new LibraryResource[5];

        resources[0] = new Book(
                101,
                "Java Programming",
                "James Gosling"
        );

        resources[1] = new DigitalResource(
                102,
                "Data Structures E-Book",
                "Robert Lafore"
        );

        resources[2] = new Book(
                103,
                "Operating Systems",
                "Abraham Silberschatz"
        );

        resources[3] = new DigitalResource(
                104,
                "Computer Networks",
                "Andrew Tanenbaum"
        );

        resources[4] = new Book(
                105,
                "Database Management",
                "Raghu Ramakrishnan"
        );

        int[] overdueDays = {
                4,
                10,
                2,
                5,
                7
        };

        System.out.println(
                "===================================="
        );

        System.out.println(
                "    SMART LIBRARY RESOURCE SYSTEM"
        );

        System.out.println(
                "===================================="
        );

        double totalFine =
                LibraryService.calculateTotalFine(
                        resources,
                        overdueDays
                );

        System.out.println("------------------------------------");

        System.out.println(
                "TOTAL FINE : Rs. " + totalFine
        );

        System.out.println("------------------------------------");

        LibraryResource.displayTotalResources();
    }
}