/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

/**
 *
 * @author Antonio
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            
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

            res.updateDates(checkin, checkout);
        } catch(ParseException e) {
            System.out.println("Invalid date format");
        } catch(DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch(RuntimeException e) {
            System.out.println("Unexpected error");
        }
        
    }
    
}
