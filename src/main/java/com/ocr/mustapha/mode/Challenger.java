package com.ocr.mustapha.mode;
import com.ocr.mustapha.configuration.Configuration;
import java.util.Scanner;
import static com.ocr.mustapha.Main.LOGGER;


public class Challenger extends Methode {


    public void runChallenger() {
        LOGGER.info("\n*****Bienvenue dans le mode Challenger !*****");

        Configuration c = new Configuration();

        int chance = c.getChance();
        String solution = "", proposition = "";
        boolean gagner = false;



        solution = getAlphaNumericString(c.getlgCombinaison());
        if (c.getDevelopper()) {

            System.out.println("la combinaison secrete : " + solution);//optionel permet de verifié les proposition de l'ordianateur
        } else {
        }

        System.out.println("Défenseur: Vous avez  " + chance + " chances  pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");

        Scanner sc = new Scanner(System.in);

        while (chance != 0 && gagner == false) {

            chance--;

            System.out.println("Faites une proposition il vous reste " + chance + " chances");  //

            try {
                boolean contientChiffre = true;
                do {
                    proposition = sc.nextLine();
                    if (proposition.length() != c.getlgCombinaison()) {
                        System.out.println(" Votre solution doit comporter "+c.getlgCombinaison()+" Chiffres");
                        proposition= sc.nextLine();
                    }else { }

                }while (!verificationCombinaison(contientChiffre,proposition));

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
                    }System.out.println();



            } catch (Exception a) {
                sc.nextLine();
            }

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