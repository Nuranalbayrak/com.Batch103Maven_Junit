package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.TestBase;

public class C02_log4j {

//3. Logger object olustur:
//    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//                 logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");
    private static Logger logger=LogManager.getLogger(C02_log4j.class.getName());

    @Test
    public void log4Jtest() {
    logger.fatal("Fatal log!");
    logger.error("Error log!");
    logger.warn("Warning log!");
    logger.debug("Debug log!");
    logger.info("Info log!");
    }
}
