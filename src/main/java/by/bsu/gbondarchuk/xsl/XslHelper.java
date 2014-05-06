package by.bsu.gbondarchuk.xsl;

import by.bsu.gbondarchuk.model.enums.XslScript;
import com.thoughtworks.xstream.XStream;
import org.xml.sax.InputSource;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XslHelper {
    public static void transform (XslScript script, Object toTransform, OutputStream outStream) {
        final InputStream xsltFile = XslHelper.class.getClassLoader().getResourceAsStream(script.getPath());

        XStream xStream = new XStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        xStream.toXML(toTransform, outputStream);
        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        SAXSource saxSource = new SAXSource(new InputSource(new InputStreamReader(inputStream)));
        final Source xsltSource = new StreamSource(xsltFile);

        final TransformerFactory transFact = TransformerFactory.newInstance();
        try {
            Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(saxSource, new StreamResult(outStream));
        } catch (TransformerConfigurationException e) {
            System.out.println("Could not initialize transform object");
            e.printStackTrace();
        } catch (TransformerException e) {
            System.out.println("Could not transform object");
            e.printStackTrace();
        }
    }
}
