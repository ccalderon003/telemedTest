import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {

    private static final String SELENIUM_BASIC_DRIVER = "selenium.basic.driver";

    public static WebDriver get(){
        String browserToUse = "";

        if(System.getProperties().containsKey(SELENIUM_BASIC_DRIVER)){
            browserToUse = System.getProperty(SELENIUM_BASIC_DRIVER);
        }

        switch(browserToUse){
            case "chrome":
                return new ChromeDriver();
            default:
                String currentDir = System.getProperty("user.dir");
                String driverLocation = currentDir + "//tools/drivers/msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", driverLocation);
                return new EdgeDriver();

        }

    }

}
