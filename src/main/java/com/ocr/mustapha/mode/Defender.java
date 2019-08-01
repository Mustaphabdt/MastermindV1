package com.ocr.mustapha.mode;
import com.ocr.mustapha.configuration.Configuration;
import java.util.Scanner;
import static com.ocr.mustapha.Main.LOGGER;

/**
 * classe qui permet  le mode de jeu Defendeur
 */

public class Defender extends Methode {


    /**
     * run defender est une methode de la classe Defendeur qui permet le lancement du jeu.
     */
    public static void runDefender() {

        Configuration c = new Configuration();
        int chance = c.getChance();
        boolean gagner = false;
        String solution = "";
        String proposition = "";

        Scanner sc = new Scanner(System.in);


        LOGGER.info("\n*****Bienvenue dans le mode du défenseur !*****");
        System.out.println("Vous devez entrer une combinaison de " + c.getlgCombinaison() + " chiffres que l'ordinateur doit trouver !");

        boolean contientChiffre = true;
        do {
            solution = sc.nextLine();
            if (solution.length() != c.getlgCombinaison()) {
                System.out.println(" Votre solution doit comporter "+c.getlgCombinaison()+" Chiffres");
                solution= sc.nextLine();
            }else { }

        }while (!verificationCombinaison(contientChiffre,solution));


        // Si Longueur  de la solution n'est pas respecter



        //Afficher solution si mode developpeur actif
        if (c.getDevelopper()) {
            System.out.println("la combinaison secrete : " + solution);
        } else {
        }

        System.out.println(" Défenseur: Vous avez  " + chance + "chances  pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");

        proposition = getAlphaNumericString(solution.length());

        // proposition est défini par l'ordinateur
        //  System.out.println(proposition);


        while (chance != 0 && gagner == false) {


            chance--;  // a chaque tour de boucle la valeur chance est décrementé

            System.out.println("l'ordianteur fait une proposition il lui reste " + chance + " chance");  //
            String prochaineProposition = "";// optionel permet de verifié les proposition de l'ordianateur


            System.out.println(proposition);//optionel permet de verifié les proposition de l'ordianateur


            for (int i = 0; i < solution.length(); i++) {
                //si le char est le meme

                if (Character.getNumericValue(solution.charAt(i)) == Character.getNumericValue(proposition.charAt(i))) {// recupère la valeur charAt(i)
                    // string en in correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                    System.out.print("=");
                    prochaineProposition = prochaineProposition + Character.getNumericValue(proposition.charAt(i));

                }
                //si le char est superieur
                if (Character.getNumericValue(solution.charAt(i)) > Character.getNumericValue(proposition.charAt(i))) {

                    System.out.print("+");
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(j + 1, 9);// generation d'un nombre aléatoire pour la prochaine position qui est superieur non egale a la valeur presedente

                }
                if (Character.getNumericValue(solution.charAt(i)) < Character.getNumericValue(proposition.charAt(i))) {

                    System.out.print("-");
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(0, j - 1); // generation d'un nombre aléatoire pour la prochaine position qui est inferieur non egale a la valeur presedente

                }


            }



            System.out.println();

            // si ma proposition est bonne la variable gagner change de valeur et arrete la boucle + affichage de fin
            if (proposition.equals(solution)) {

                gagner = true;
                System.out.println(" l'ordianteur a trouvé la solution en " + (10 - chance) + " essais ");

            } else {

                proposition = prochaineProposition;

            }

            // si plus de chances affiche le message le "joueur" n'a plus de chances
            if (chance == 0) {
                System.out.println("l'ordianteur a perdu");
            }


        }
    }
}

