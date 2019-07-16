package com.ocr.mustapha;
import configuration.Configuration;
import java.util.Scanner;
import static com.ocr.mustapha.Main.LOGGER;
import static com.ocr.mustapha.Methode.getAlphaNumericString;


public class Challenger {





    public void runChallenger(){
        LOGGER.info("\n*****Bienvenue dans le mode Challenger !*****");

        Configuration c = new Configuration();

        int chance = c.getChance();
        String solution = "", proposition = "";
        boolean gagner = false;

        System.out.println("Attaquant : Veuillez entrer une combinaison de chiffres !");

        solution = getAlphaNumericString(c.getlgCombinaison());

        System.out.println("la combinaison secrete : " + solution);
        System.out.println("Défenseur: Vous avez  " + chance + " chances  pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");


        while (chance != 0 && gagner == false) {

            chance--;
            Scanner sc = new Scanner(System.in);
            System.out.println("Faites une proposition il vous reste " + chance + " chances");  //

            try{
                proposition = sc.nextLine();  // proposition est défini par l'utilisateur .
                    if (proposition.length() != solution.length()) {
                    System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommencer");
                    // Si Longueur  de la solution n'est pas respecter
                        for (int i = 0; i < solution.length(); i++) {
                            if (Character.getNumericValue(solution.charAt(i)) == Character.getNumericValue(proposition.charAt(i))) {// recupère la valeur charAt(i) string en int correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                                System.out.print("=");
                                }
                                if (Character.getNumericValue(solution.charAt(i)) > Character.getNumericValue(proposition.charAt(i))) {
                                    System.out.print("+");
                                    }
                                    if (Character.getNumericValue(solution.charAt(i)) < Character.getNumericValue(proposition.charAt(i))) {
                                        System.out.print("-");
                                        }
                                }
                        }
                }catch (Exception a){
                            System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommancer");
                                sc.nextLine();
                        }
            System.out.println();

            if (proposition.equals(solution)) {

                    gagner = true;

                        System.out.println(" Vous avez trouvé la solution en " + (10 - chance) + " essais ");
            }
            if (chance == 0) {
                    System.out.println(" Vous n'avez plus de chance! ");
            }
        }
    }
}