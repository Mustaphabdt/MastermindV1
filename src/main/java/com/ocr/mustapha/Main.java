package com.ocr.mustapha;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 */
public class Main {
    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Mode startMode = new Mode();  // lancement du menu principal avec tout les modes revoi vers class Mode
        startMode.runMode();
    }
}
