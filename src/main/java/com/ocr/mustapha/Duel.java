package com.ocr.mustapha;
import configuration.Configuration;
import java.util.Scanner;
import static com.ocr.mustapha.Main.LOGGER;



public class Duel extends Methode {

    public static void runDuel() {

        Configuration c = new Configuration();
        LOGGER.info("\n*****Bienvenue dans le mode Duel !*****");
        int chance = c.getChance();
        boolean gagner = false;

        // ORDINATEUR VS UTILISATEUSystem.out.println(" la longeur de la combinaison doit etre de " + c.getlgCombinaison() + " Chiffres ! Veuillez recommencer");R VARIABLES ET INIT
        String solution = null, proposition = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer une combinaison de "+c.getlgCombinaison()+" chiffres que l'ordinateur doit trouver!");



        solution = sc.nextLine();



        while (solution.length() != c.getlgCombinaison()) {
            System.out.println(" la longeur de la combinaison doit etre de " + c.getlgCombinaison() + " Chiffres ! Veuillez recommencer");
            solution = sc.nextLine();
        }

        if (c.getDevelopper()) {

            System.out.println("la combinaison secrete que l'odinateur doit trouver est:  " + solution);//optionel permet de verifié les proposition de l'ordinateur
        } else {
        }


        System.out.println("Ordinateur Vous avez  " + chance + " chances pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");
        proposition = getAlphaNumericString(solution.length());  // proposition est défini par l'ordinateur
        // UTILISATEUR VS ORDINATEUR VARIABLES
        String solution2 = null, proposition2 = null;

        System.out.println("Ordinateur entrez une combinaison de chiffres que l'utilisateur doit trouver !");

        solution2 = getAlphaNumericString(solution.length());

        if (c.getDevelopper()) {
            System.out.println("la combinaison secrete de l'ordinateur est : " + solution2);//optionel permet de verifié les proposition de l'ordinateur
        } else {
        }

        System.out.println("Vous avez " + chance + " chances  pour trouver la combinaison de " + solution2.length() + " chiffres que l'ordinateur a généré c'est à vous !");


        while (chance >= 0 && gagner == false) {


            if (proposition.length() != solution.length()) {

                System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommancer");
                // Si Longueur  de la solution n'est pas respecter
            }
            String prochaineProposition = "";// optionel permet de verifié les proposition de l'ordinateur
            System.out.println(proposition);
            for (int i = 0; i < solution.length(); i++) {
                // recupère la valeur charAt(i)
                // string en in correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                if (Character.getNumericValue(solution.charAt(i)) == Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("=");
                    prochaineProposition = prochaineProposition + Character.getNumericValue(proposition.charAt(i));
                }
                if (Character.getNumericValue(solution.charAt(i)) > Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("+");
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(j + 1, 9);
                    // generation d'un nombre aléatoire pour la prochaine position qui est superieur non egale a la valeur presedente

                }
                if (Character.getNumericValue(solution.charAt(i)) < Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("-");
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(0, j - 1); // generation d'un nombre aléatoire pour la prochaine position qui est inferieur non egale a la valeur presedente
                }
            }
            System.out.println( " *****résultat de l'ordinateur*****");

            Scanner sc2 = new Scanner(System.in);
            proposition2 = sc2.nextLine();  // proposition est défini par l'utilisateur .

            System.out.println("Faites une proposition il vous reste " + chance + " chances");

            for (int j = 0; j < solution2.length(); j++) {

                if (Character.getNumericValue(solution2.charAt(j)) == Character.getNumericValue(proposition2.charAt(j))) {// recupère la valeur charAt(i) string en int correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                    System.out.print("=");
                }
                if (Character.getNumericValue(solution2.charAt(j)) > Character.getNumericValue(proposition2.charAt(j))) {
                    System.out.print("+");
                }
                if (Character.getNumericValue(solution2.charAt(j)) < Character.getNumericValue(proposition2.charAt(j))) {
                    System.out.print("-");
                }
            }


            System.out.println(" *****Votre résultat***** ");

            if (proposition.equals(solution)) {
                gagner = true;
                System.out.println(" Gagnant : l'ordinateur  ( la solution trouvée en  " + (10 - chance) + " essais ) ");


            } else {
                proposition = prochaineProposition;
            } // si ma proposition est bonne ne variable gagner change de valeur et arrete la boucle + affichage de fin

            if (chance == 0) {
                System.out.println("Vous n'avez plus de chance");
            }



            if (proposition2.equals(solution2)) {
                gagner = true;
                System.out.println(" Gagnant :Bravo! Vous avez trouvé la solution en " + (10 - chance) + " essais ");


            }
            /*if (chance == 0) {
                System.out.println("GAME OVER!");
            }
            */
            chance--;  // a chaque tour de boucle la valeur chance est décrementé
        }
    }

}