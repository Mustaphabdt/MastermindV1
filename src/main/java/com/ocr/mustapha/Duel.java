package com.ocr.mustapha;
import java.util.Random;
import java.util.Scanner;

public class Duel {
    /**
     *
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     *
     * @param n
     * @return
     */
    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }                                                         // la méthode ci dessus permet de générer un string aléatoire de la longeur que l'on veut.

    /**
     *
     */
    public static void runDuel() {

        System.out.println("*****Bienvenue dans le mode Duel !*****");
        int chance = 10;
        boolean gagner = false;

        // ORDINATEUR VS UTILISATEUR VARIABLES ET INIT
        String solution = null, proposition = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer une combinaison de chiffres que l'ordinateur doit trouver!");
        solution = sc.nextLine();


        System.out.println("la combinaison secrete que l'odinateur doit trouver est:  " + solution);

        System.out.println("Ordinateur Vous avez  " + chance + " chances pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");
        proposition = getAlphaNumericString(solution.length());  // proposition est défini par l'ordinateur
        // UTILISATEUR VS ORDINATEUR VARIABLES
        String solution2 = null, proposition2 = null;

        System.out.println("Ordianteur entrez une combinaison de chiffres que l'utilisateur doit trouver !");
        solution2 = getAlphaNumericString(solution.length());
        System.out.println("la combinaison secrete de l'ordianteur est : " + solution2);


        System.out.println("Vous avez " + chance + " chances  pour trouver la combinaison de " + solution2.length() + " chiffres que l'ordianteur a générez c'est à vous !");




        while (chance >= 0 && gagner == false) {


            if (proposition.length() != solution.length()) {
                System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommancer");
                // Si Longueur  de la solution n'est pas respecter
            }
            String prochaineProposition = "";// optionel permet de verifié les proposition de l'ordianateur
            System.out.println(proposition);
            for (int i = 0; i < solution.length(); i++) {
                if (Character.getNumericValue(solution.charAt(i)) == Character.getNumericValue(proposition.charAt(i))) {// recupère la valeur charAt(i)
                    // string en in correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                    System.out.print("=");
                    prochaineProposition = prochaineProposition + Character.getNumericValue(proposition.charAt(i));

                }
                if (Character.getNumericValue(solution.charAt(i)) > Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("+");
                    //System.out.print(Character.getNumericValue(proposition.charAt(i)));
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
            System.out.println( " *****résultat de l'ordinateur*****");

            Scanner sc2 = new Scanner(System.in);
            proposition2 = sc2.nextLine();  // proposition est défini par l'utilisateur .

            System.out.println("Faites une proposition il vous reste " + chance + " chances");  //
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
                System.out.println("Vous n'avez plus de chance!GAME OVER :");
            }



            if (proposition2.equals(solution2)) {
                gagner = true;
                System.out.println(" Vous avez trouvé la solution en " + (10 - chance) + " essais ");


            }
            /*if (chance == 0) {
                System.out.println("GAME OVER!");
            }
            */
            chance--;  // a chaque tour de boucle la valeur chance est décrementé
        }
    }

}