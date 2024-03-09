package BusinessObjects;

// File started by Jake O'Reilly

import DAOs.InstrumentDaoInterface;
import DAOs.MySqlInstrumentDao;
import DTOs.Instrument;
import Exceptions.DaoException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DaoException {
        App app = new App();
        app.start();
    }

    static int userInput = -1;
    static Scanner keyboard = new Scanner(System.in);

    // Start app
    public void start() throws DaoException {
        InstrumentDaoInterface InstrumentDao = new MySqlInstrumentDao();

        System.out.println("App start, welcome!");

        // Menu printing system, show app commands
        do {

            System.out.println("\nSelect a command:\n" +
                    "[1] Get all instruments\n" +
                    "[2] Get instrument by name (id)\n" +
                    "[3] Delete instrument by name (id)\n" +
                    "[4] Insert an instrument\n" +
                    "[0] Exit\n");
            System.out.printf("Enter: ");

            userInput = keyboard.nextInt();

            System.out.println();

            switch (userInput) {
                case 1:
                    //IInstrumentDao.deleteInstrumentById("hi");
                    //System.out.println(InstrumentDao.getAllInstruments());
                    InstrumentDao.getAllInstruments();
                    break;
                case 2:
                    System.out.printf("Enter id: ");
                    int id = keyboard.nextInt();

                    InstrumentDao.getInstrumentById(id);
                    break;
            }

        } while (userInput != 0);

        System.out.println("Exiting app, goodbye!");

    }

}
