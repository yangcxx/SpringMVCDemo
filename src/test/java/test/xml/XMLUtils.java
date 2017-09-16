package test.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Function: 分别使用 DOM & SAX 对 XML 文件进行解析
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/16 11:24 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class XMLUtils {

    /**
     * 将整个XML文档作为类似树的结构读入内存中进行解析
     *
     * @param path
     */
    public static void domParser(String path) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            NodeList nodeList = document.getElementsByTagName("book");//不是根节点
            if (null != nodeList && nodeList.getLength() > 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node item = nodeList.item(i);
                    NodeList childNodes = item.getChildNodes();
                    if (null != nodeList && childNodes.getLength() > 0) {
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node child = childNodes.item(j);
                            //TODO 中间有空格 - 也算是一个 node
                            if (child.hasChildNodes()) {
                                System.out.println(child.getNodeName() + " : " + child.getFirstChild().getNodeValue());
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
