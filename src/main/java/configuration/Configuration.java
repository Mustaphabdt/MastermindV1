package configuration;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

/**
 *
 */
public class Configuration {

    private  PropertyResourceBundle bundle;

    public Configuration() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");// forcer l'acces au fichier dans resources
        try {
            bundle = new PropertyResourceBundle(is);
        } catch (Exception e) {

        }
    }

    public int getChance() {
        String chance = bundle.getString("chance");
        return Integer.parseInt(chance);
    }
    public  int getlgCombinaison(){
        String lgCombinaison = bundle.getString("lgCombinaison");
        return Integer.parseInt(lgCombinaison);
    }
}