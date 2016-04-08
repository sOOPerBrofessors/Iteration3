package LoadSave;

import Visitors.LoadVisitor;
import org.w3c.dom.Document;

/**
 * Created by aseber on 4/7/16.
 */
public class LoadDocument {

    Document document;

    public LoadDocument(Document document) {

        this.document = document;

    }

    public void accept(LoadVisitor visitor) {

        visitor.visit(this);

    }

}
