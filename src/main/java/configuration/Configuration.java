package configuration;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
/**
 *
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
        //Methodes permettant de retouner les deux valeurs configurer dans le fichier config.properties
    public int getChance() {
        String chance = bundle.getString("chance");
        return Integer.parseInt(chance);
    }
    public int getlgCombinaison(){
        String lgCombinaison = bundle.getString("lgCombinaison");
        return Integer.parseInt(lgCombinaison);
    }
}