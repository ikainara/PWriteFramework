package core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public abstract class BaseObject {
    @Getter
    private static int DEFAULT_TIMEOUT = 15;
    private static Logger LOGGER = LoggerFactory.getLogger("PWF_Logger");

    public static Logger getLogger() {
        return LOGGER;
    }
}
