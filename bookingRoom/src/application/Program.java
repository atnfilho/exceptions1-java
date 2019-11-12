/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author Antonio
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number:");
        int room = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy):");
        Date checkin = sdf.parse(sc.nextLine());
        System.out.print("Check-out date (dd/MM/yyyy):");
        Date checkout = sdf.parse(sc.nextLine());
        Reservation res = new Reservation(room, checkin, checkout);
        
        System.out.println(res);
        
        System.out.println("");
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date: ");
        checkin = sdf.parse(sc.nextLine());
        System.out.print("Check-out date: ");
        checkout = sdf.parse(sc.nextLine());
        
        if(checkout.before(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        } else if(checkin.before(new Date()) || checkout.before(new Date())) {
            System.out.println("Error in reservation: Reservation dates for update must be future dates!");
        } else {
            res.updateDates(checkin, checkout);
            System.out.println(res);
        }
        
    }
    
}
