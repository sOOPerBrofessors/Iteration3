package Utilities;

/**
 * Created by aseber on 4/7/16.
 */
public class IOUtilities {

    public static String getFileSystemDependentPath(String string) {

        return string.replaceAll("\\\\|/", "\\" + System.getProperty("file.separator"));
    }

}
