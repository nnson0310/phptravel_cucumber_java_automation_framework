# Sekeleton cucumber automation framework for travel domain

## Table of Contents
1. [Important Note](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#important-note)
2. [Features](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#features)
3. [Install](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#install)
4. [Logging](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#logging)
5. [Extent Report](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#extent-report)
6. [Parallel running](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#parallel-running)
7. [Retry when testcases fails](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#retry-when-testcases-fails)
8. [Docker grid](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#docker-grid)
9. [Cloud Testing](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#cloud-testing)
10. [Jenkins Pipeline](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#jenkins-pipeline)
10. [License](https://github.com/nnson0310/phptravel_cucumber_java_automation_framework#license)

### Important Note:
+ Language binding is java. Running stably with java version 11 (jdk 11.0.15 or 11.0.13)
+ This project does not using latest selenium version. Using selenium version is 3.141.59 (7/3/2022: latest stable version is 4.0.3)
+ Public domain using for test: [`https://phptravels.net/`](https://phptravels.net/)
+ Using maven build tools to manage dependencies and third-party libraries
+ Assert lib is Junit4 (not TestNG)

### Features
+  Support running on cloud device, docker grid and stable local.
+  Support cross-browser testing: chrome, firefox, headless browser, opera, edge, safari....
+  Auto retry when testcases fail
+  Console logging, file logging
+  Generate extent report and cucumber report (use which one adapt to your requirements)
+  Share context between cucumber steps (cucumber pico-container)
+  Hooks running
+  Read json files
+  Database connect (postgreSql is default)
   ...and so on

### Install
1. Clone project and run `'mvn install'` to install all dependencies
2. Config `src/test/java/cucumber_runner/TestRunner` to run specific scenarios or features files
3. Run `"mvn clean test -Dbrowser=browser_name -Denv=environment_name verify"` to run test
+ `"-Dbrowser"` and `"-Denv"` is optional: if browser name and environment are not specified, tests will run with default browser is `chrome` and default environment is `local`. Valid browser name is `h_chrome, h_firefox, firefox, chrome, opera, edge, safari`.  Valid environment is `local, cloud, grid`.
+ `"verify"` state is also optional. Use it when you want to generate cucumber reports. Extent report will be generated by default.

### Logging
+ Use `log4j` for console log, file log (auto create log4j.out). Config `log4j.properties` due to your need.

### Extent report
+ Config `extent.properties`. By default, pdf report, html report and spark report will be generated in `test-output` directory.
+ Screenshot will be attached to extent report by `base64` or `png image`. Default is `base64` for lightweight
+ Config each report style in `src/test/resources/report-config`

### Parallel running
+ By default, you can run cucumber tests in parallel by creating two TestRunner class file or run scenarios parralel by config `<parallel>methods</parallel>` or `<parallel>classes</parallel>` in pom.xml.
  **Refer**: [cucumber_parallel_execution](https://cucumber.io/docs/guides/parallel-execution/)

### Retry when testcases fails
+ After testcases fails, a `failed-testcases.txt` will be created in `target` directory. `TestRetry` runner will get its info to run only failed ones.

### Docker grid
+ Run `"docker compose up"` to create docker containers (auto contains selenium node and hub) by default. Config in docker-compose.yml.

### Cloud testing
+ Using [BrowserStack](https://www.browserstack.com/) to run on cloud device. If you want to use another cloud testing platform, config `src\main\java\env_factory\CloudEnvFactory` adapt to your need. Besides that, do not forget to config `DesiredCapability` too.
+ [BrowserStack](https://www.browserstack.com/) uses `username` and `automate_key` to generate URL for RemoteWebDriver. You have two options to easily set these info. One is config `setCloudCrendetials.bat file` , another is config `"src\test\resources\cloud_testing.properties"` file.

### Jenkins pipeline
+ Jenkins pipeline will auto detect `jenkinsFile.groovy` to define pipeline. If you prefer using pipeline scripts, simply copy and paste its content to your jenkins build.

### Plugins to build and run test
| Plugins | Repo |
|---------|--------|
|  maven-compiler-plugin | [maven-compiler][MCP] |
|maven-surefire-plugin | [maven-surefire][MSP] |

### License
**Clone and use it freely by your need. If you find this repo useful, please give it a star.**

[MCP]: <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin/2.22.2>
[MSP]: <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin/3.8.1>
