package Ptoperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties prop;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/application.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
