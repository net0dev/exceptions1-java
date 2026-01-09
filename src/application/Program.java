package application;


import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        try (Scanner sc = new Scanner(System.in)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("check-in date(dd/MM/yyyy): ");
            Date checkiIn = sdf.parse(sc.next());
            System.out.print("check-out date(dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            if (!checkOut.after(checkiIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Reservation reservation = new Reservation(number, checkiIn, checkOut);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.print("check-in date(dd/MM/yyyy): ");
                checkiIn = sdf.parse(sc.next());
                System.out.print("check-out date(dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());


                Date now = new Date();
                if (checkiIn.before(now) || checkOut.before(now)) {
                    System.out.println("Error in reservation: Reservation dates for update must be future dates: ");
                } else if (!checkOut.after(checkiIn)) {
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                } else {
                    reservation.updateDates(checkiIn, checkOut);
                    System.out.println("Reservation: " + reservation);

                }


            }


        }


    }
}