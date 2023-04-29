
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Chaldal {


    @DataProvider(name = "data_provider")
    public Object[][] dpMethod() throws IOException {
        FileReader file = new FileReader();
        Object data[][]=  file.excelReader();
        return data;

    }

    @Test(dataProvider = "data_provider")
    public void searchProduct(String item, String price,String ID ){
//        String productName = (String) data[1][0];


        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://chaldal.com");
        driver.manage().window().maximize();
        System.out.println(item);
        System.out.println(price);
        System.out.println(ID);
        driver.findElement(By.xpath("//*[@name='search_term_string']")).sendKeys(item);

        driver.findElement(By.xpath("//*[@name='search_term_string']")).sendKeys(Keys.ENTER);




    }

}


