package Utilities.GameLoaderSaver.Save;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

/**
 * Created by dyeung on 4/17/16.
 */
public class SaverUtility {


    //gets attributes with a space in the string
    public static Attr getAttrWithSS(Document doc, String attrName, String value){
        String newValue = value.replace(' ', '-');
        Attr attr = doc.createAttribute(attrName);
        attr.setValue(newValue);
        return attr;
    }
}
