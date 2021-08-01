package io.rynartisan.pencil.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class logService {
    private Logger logger;

    public logService() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public void logDebug(String text) {
        logger.debug(text);
    }

    public void logInfo(String text) {
        logger.info(text);
    }

    public void logError(String text) {
        logger.error(text);
    }
}
