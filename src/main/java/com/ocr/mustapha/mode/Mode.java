package com.ocr.mustapha.mode;
import java.util.Scanner;

import static com.ocr.mustapha.Main.LOGGER;

/**
 * @Class permettant le lancement des different mode de jeu
 */
public class Mode {

    /**
     * @Method lancé par le Main permettant de acccéder au menu principale de l'application
     */
    public static void runMode() {

        int exit = 0;

        do {

            LOGGER.info("\nMenu principal:");
            System.out.println("1- Mode du défenseur");
            System.out.println("2- Mode du challengeur");
            System.out.println("3- Mode du duel ");
            Scanner sc = new Scanner(System.in);

            int choice = 0;

            do {


                try {

                    choice = sc.nextInt();

                } catch (Exception e) {
                    System.out.println("Vous devez entrez un entier valide");
                    sc.nextLine();
                }

                if (choice < 1 || choice > 3) {

                    System.out.println(" Choix incorrect , veuillez recommencer ! ");
                }
                } while (choice < 1 || choice > 3);
            switch (choice) {
                case 1:
                    Defender startDefender = new Defender();
                    Defender.runDefender();
                    break;
                case 2:
                    Challenger startChallenger = new Challenger();
                    startChallenger.runChallenger();
                    break;
                case 3:
                    Duel startDuel = new Duel();
                    startDuel.runDuel();
                    break;
            }
            System.out.println("envie de rejouer ?");
            System.out.println("0- Oui , 1 - Non  ");
            do {


                try {

                    exit = sc.nextInt();

                } catch (Exception e) {
                    System.out.println("Vous devez entrez un entier valide");
                    sc.nextLine();
                }

                if (exit < 0 || exit > 1) {

                    System.out.println(" Choix incorrect , veuillez recommencer ! ");
                    System.out.println("envie de rejouer ?");
                    System.out.println("0- Oui , 1 - Non  ");
                }
            } while (exit < 0 || exit > 1);

            if (exit == 1) {
                LOGGER.info("Goodbye !");
            }
        } while (exit != 1);

    }
}