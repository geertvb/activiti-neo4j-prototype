package be.jdevit.activiti.neo4j.utils;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

import java.util.Date;

public class VertexUtils {

    public static void setProperty(Node node, String propertyName, Object propertyValue) {
        if (propertyValue == null) {
            node.removeProperty(propertyName);
        } else {
            node.setProperty(propertyName, propertyValue);
        }
    }

    public static void setString(Node node, String propertyName, String propertyValue) {
        setProperty(node, propertyName, propertyValue);
    }

    public static void setInteger(Node node, String propertyName, Integer propertyValue) {
        setProperty(node, propertyName, propertyValue);
    }

    public static void setLong(Node node, String propertyName, Long propertyValue) {
        setProperty(node, propertyName, propertyValue);
    }

    public static void setByteArray(Node node, String propertyName, byte[] propertyValue) {
        setProperty(node, propertyName, propertyValue);
    }

    public static void setBoolean(Node node, String propertyName, boolean propertyValue) {
        setProperty(node, propertyName, propertyValue);
    }

    public static void setDate(Node node, String propertyName, Date propertyValue) {
        Long longValue = null;
        if (propertyValue != null) {
            longValue = propertyValue.getTime();
        }
        setProperty(node, propertyName, longValue);
    }

    public static Date getDate(Node node, String propertyName) {
        Object value = node.getProperty(propertyName, null);
        return DateUtils.toDate(value);
    }

    public static void addLabel(Node node, String label) {
        node.addLabel(DynamicLabel.label(label));
    }

    public static void removeLabel(Node node, String label) {
        node.removeLabel(DynamicLabel.label(label));
    }

}
