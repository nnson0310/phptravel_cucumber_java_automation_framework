package commons;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Define all constant variables which will be used in project context
 * through getters methods (Singleton Pattern applying)
 *
 * @author Son
 */
@Getter
@Setter
public class GlobalConstants {

    private static GlobalConstants globalConstants;
    private GlobalConstants() {
    }

    public synchronized static GlobalConstants getGlobalConstants() {
        if (globalConstants == null) {
            return new GlobalConstants();
        }
        return globalConstants;
    }

    // domain url
    private final String userSiteUrl = "https://www.phptravels.net";
    private final String adminSiteUrl = "https://www.phptravels.net/admin";

    // timeout for implicit wait and explicit wait
    private final int shortTimeout = 10;
    private final int longTimeout = 20;

    private final String projectPath = System.getProperty("user.dir");
    private final String extentReportConfigFilePath = projectPath + File.separator + "extent-config.xml";
    private final String osName = System.getProperty("os.name");
    private final String pathToMainResources = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    private final String reportScreenshot = pathToMainResources + "reportScreenshot" + File.separator;

    // Only valid when running on local machine. When running on cloud device
    // please specify valid url to file
    private final String downloadFilePath = pathToMainResources + "downloadedFiles" + File.separator;
    private final String uploadFilePath = pathToMainResources + "uploadFiles" + File.separator;

    private final String testDataPath = pathToMainResources + "test_data" + File.separator;
    private final String browserLogFilePath = projectPath + File.separator + "browserLogs" + File.separator;
    private final String browserExtensionPath = projectPath + File.separator + "browserExtensions" + File.separator;
    private final String javaVersion = System.getProperty("java.version");
}
