package com.ocr.mustapha;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    /** Appel de la class Logger
     * Fonction qui permet la gestion de log. LogManager
     */

    public static final Logger LOGGER = LogManager.getLogger();

    /**
     *
     * Methode permet de lancer le jeu pour acceder au menu principal
     */
    public static void main(String[] args) {

        LOGGER.info(" Hello !");
        Mode startMode = new Mode();  // lancement du menu principal avec tout les modes revoi vers class Mode
        startMode.runMode();

    }
}
