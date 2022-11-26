package configs;

import org.aeonbits.owner.Config;

public interface PWConfig extends Config {
    @Key("browserHeight")
    int browserHeight();
    int browserWidth();
    //@DefaultValue("false")
    boolean isHeadless();
    //@DefaultValue("15")
}
