package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public static double calculateTotalFine(
            LibraryResource[] resources,
            int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            LibraryResource resource = resources[i];

            if (!InputValidator.validateResourceId(
                    resource.getResourceId())) {

                System.out.println("Invalid Resource ID");
                continue;
            }

            if (!InputValidator.validateFineDays(
                    overdueDays[i])) {

                System.out.println("Invalid Fine Days");
                continue;
            }

            Printable printable = (Printable) resource;

            printable.printDetails();

            double fine =
                    resource.calculateFine(overdueDays[i]);

            System.out.println(
                    "Overdue Days : " + overdueDays[i]
            );

            System.out.println(
                    "Fine         : Rs. " + fine
            );

            totalFine += fine;
        }

        return totalFine;
    }
}