package env_factory;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:cloud_testing.properties"})
public interface CloudProperties extends Config {

    @Key("cloudUsername")
    String cloudUsername();

    @Key("cloudAutomateKey")
    String cloudAutomateKey();

    @Key("ipAddress")
    String ipAddress();

    @Key("port")
    String port();

    @Key("os")
    String os();

    @Key("browserVersion")
    String browserVersion();

    @Key("buildVersion")
    String buildVersion();

    @Key("projectName")
    String projectName();

    @Key("osVersion")
    String osVersion();
}
