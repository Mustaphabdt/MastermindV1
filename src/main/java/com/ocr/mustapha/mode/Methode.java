package com.ocr.mustapha.mode;
import com.ocr.mustapha.configuration.Configuration;
import java.util.Random;

public class Methode {
    /**
     *this method generate integer ramdom
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
     * @param n is the length parameter
     * @return String builder gernerate
     */// la méthode ci dessous permet de générer un string aléatoire de la longeur que l'on veut variable a generer avec config.properties
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
            int index = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }



}
