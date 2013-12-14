package sk.tomsik68.mclauncher.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ResourcesXMLParser {
    private final String url;
    private IResourceFilter filter;

    public ResourcesXMLParser(String url) {
        this.url = url;
    }

    public List<String> parse() throws SAXException, IOException, ParserConfigurationException {
        List<String> result = new ArrayList<String>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url);
        for (int i = 0; i < doc.getElementsByTagName("ListBucketResult").item(0).getChildNodes().getLength(); i++) {
            Node node = doc.getElementsByTagName("ListBucketResult").item(0).getChildNodes().item(i);
            if ((node != null) && ("Contents".equalsIgnoreCase(node.getNodeName())) && (node.getChildNodes().getLength() > 0))
                if (("Key".equals(node.getFirstChild().getNodeName()))) {
                    Map<String, String> values = translateNode(node);
                    if (filter == null || filter.approves(values)) {
                        String entry = node.getFirstChild().getTextContent();
                        result.add(entry);
                    }
                }
        }
        return result;
    }

    public void setFilter(IResourceFilter f) {
        filter = f;
    }

    private Map<String, String> translateNode(Node node) {
        NodeList nl = node.getChildNodes();
        HashMap<String, String> result = new HashMap<String, String>();
        for (int i = 0; i < nl.getLength(); ++i) {
            Node n = nl.item(i);
            result.put(n.getNodeName(), n.getTextContent());
        }
        return result;
    }
}
