package pres.seanan.runner;

import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.status.StatusLogger;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZReportGenTest {

    @Test
    public void genReport() {
        String path = null;
        Class clazz = RunCukesTest.class;
        CucumberOptions cucumberOptions = (CucumberOptions) clazz.getDeclaredAnnotation(CucumberOptions.class);
        for (String plugin : cucumberOptions.plugin()) {
            if (plugin.contains("json")) {
                path = new File("").getAbsolutePath() + "\\" + plugin.replace("json:", "").replace("/", "\\");
                break;
            }
        }
        StatusLogger.getLogger().setLevel(Level.TRACE);
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(path);

        String buildNumber = "1";
        String projectName = "cucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setParallelTesting(false);
        configuration.setRunWithJenkins(false);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

        new ReportBuilder(jsonFiles, configuration).generateReports();

    }
}
