package com.resources.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger log = LogManager.getLogger(Log.class);

    public static void startScenario(String scenarioDescription) {
        log.info("=================================================================================================================================");
        log.info("DEBUT DU SCENARIO: " + scenarioDescription);
        log.info("=================================================================================================================================" + "\n");
    }

    public static void endScenario(String scenarioDescription) {
        log.info("=================================================================================================================================");
        log.info("FIN DU SCENARIO: " + scenarioDescription);
        log.info("=================================================================================================================================" + "\n");
    }

    public static void addStep(String stepDescription) {
        log.info("---------------------------------------------------------------------------------------------------------------------------------");
        log.info("Etape : " + stepDescription);
    }
}