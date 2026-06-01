package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    // -----------------------------------------
    // CONSTRUCTOR
    // -----------------------------------------
    

    public ConfigReader() {

        prop = new Properties();

        try {

            FileInputStream fis =
            new FileInputStream(
            "src/test/resources/config.properties");

            prop.load(fis);

        }

        
        
        catch(IOException e) {

            e.printStackTrace();
        }
    }

    // -----------------------------------------
    // GET URL
    // -----------------------------------------

    public String getApplicationURL() {

        return prop.getProperty("url");
    }

    // -----------------------------------------
    // GET BROWSER
    // -----------------------------------------

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    // -----------------------------------------
    // GET EMAIL
    // -----------------------------------------

    public String getEmail() {

        return prop.getProperty("email");
    }

    // -----------------------------------------
    // GET PASSWORD
    // -----------------------------------------

    public String getPassword() {

        return prop.getProperty("password");
    }
}