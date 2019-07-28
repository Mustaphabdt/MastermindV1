package com.ocr.mustapha.configuration;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
/**
 *Cette classe premet d'appeler les variables Chance et Combinaison dans le config.properties
 */
public class Configuration {

    private  PropertyResourceBundle bundle;
    // Appel de la class PropertyResourceBundle
    public Configuration() {
        //forcer l'acces au fichier config.properties dans Resources
        InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");

        try {
            bundle = new PropertyResourceBundle(is);
        } catch (Exception e) {

        }
    }
    //Methodes permettant de retourner les deux valeurs configurées dans le fichier config.properties
    public int getChance() {
        String chance = bundle.getString("chance");
        return Integer.parseInt(chance);
    }
    public int getlgCombinaison(){
        String lgCombinaison = bundle.getString("lgCombinaison");
        return Integer.parseInt(lgCombinaison);
    }
    public boolean getDevelopper(){
        String Developper = bundle.getString("Developper");
        return Boolean.parseBoolean(Developper);
    }
}