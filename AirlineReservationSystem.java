/*
Project: Airline Reservation System
Technologies: Java (Backend), HTML, CSS, JavaScript (Frontend)
*/

// Java Backend - AirlineReservationSystem.java

import java.util.*;

class Reservation {
    private int flightNumber;
    private String passengerName;

    public Reservation(int flightNumber, String passengerName) {
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " - Passenger: " + passengerName;
    }
}

public class AirlineReservationSystem {

    private Map<Integer, String> flights = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public AirlineReservationSystem() {
        initializeFlights();
    }

    private void initializeFlights() {
        flights.put(101, "New York to Los Angeles");
        flights.put(102, "India to Saudi Arabia");
        flights.put(103, "San Francisco to Seattle");
        flights.put(104, "Dallas to Denver");
        flights.put(105, "Charlotte to New Orleans");
        flights.put(106, "Hyderbad to Qatar");
        flights.put(107, "Bengaluru to Kolkata");
        flights.put(108, "Delhi to Mumbai");
        flights.put(109, "India to Pakistan");
    }

    public String viewFlights() {
        StringBuilder flightList = new StringBuilder("Available Flights:\n");
        for (Map.Entry<Integer, String> flight : flights.entrySet()) {
            flightList.append(flight.getKey()).append(": ").append(flight.getValue()).append("\n");
        }
        return flightList.toString();
    }

    public String makeReservation(int flightNumber, String passengerName) {
        if (flights.containsKey(flightNumber)) {
            reservations.add(new Reservation(flightNumber, passengerName));
            return "Reservation confirmed for " + passengerName + " on flight " + flights.get(flightNumber);
        } else {
            return "Flight number " + flightNumber + " not found.";
        }
    }

    public String viewReservations() {
        if (reservations.isEmpty()) {
            return "No reservations found.";
        }

        StringBuilder reservationList = new StringBuilder("Current Reservations:\n");
        for (Reservation reservation : reservations) {
            reservationList.append(reservation).append("\n");
        }
        return reservationList.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirlineReservationSystem system = new AirlineReservationSystem();

        System.out.println("Welcome to Airline Reservation System");
        while (true) {
            System.out.println("1. View Flights\n2. Make Reservation\n3. View Reservations\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(system.viewFlights());
                    break;
                case 2:
                    System.out.print("Enter flight number: ");
                    int flightNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.println(system.makeReservation(flightNumber, passengerName));
                    break;
                case 3:
                    System.out.println(system.viewReservations());
                    break;
                case 4:
                    System.out.println("Thank you for using our Airline Reservation System. have a good day :) ");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

