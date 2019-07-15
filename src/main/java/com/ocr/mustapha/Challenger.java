package com.ocr.mustapha;


import configuration.Configuration;
import java.util.Scanner;
import static com.ocr.mustapha.Main.LOGGER;



public class Challenger {
    /**
     *
     * @param n
     * @return
     */
    public static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        Configuration c = new Configuration();

        for (int i = 0; i < c.getlgCombinaison(); i++) {

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
    }// la méthode ci dessus permet de générer un string aléatoire de la longeur que l'on veut variable a generer avec config.properties


    /**
     *
     */
    public void runChallenger(){
        Configuration nb = new Configuration();

        LOGGER.info("\n*****Bienvenue dans le mode Challenger !*****");


        String solution = "", proposition = "";
        System.out.println("Attaquant : Veuillez entrer une combinaison de chiffres !");
        solution = getAlphaNumericString(nb.getlgCombinaison());
        System.out.println("la combinaison secrete : " + solution);

        Configuration c = new Configuration();
        int chance = c.getChance();

        boolean gagner = false;

        System.out.println("Défenseur: Vous avez  " + chance + " chances  pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");


        while (chance != 0 && gagner == false) {
            chance--;

            Scanner sc2 = new Scanner(System.in);


            System.out.println("Faites une proposition il vous reste " + chance + " chances");  //
            try{
                proposition = sc2.nextLine();  // proposition est défini par l'utilisateur .
                if (proposition.length() != solution.length()) {
                    System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommancer");
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
                sc2.nextInt();
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