package be.jdevit.activiti.neo4j.utils;

import java.util.Date;

public class DateUtils {

    public static Date toDate(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return new Date(((Number) value).longValue());
        } else if (value instanceof Date) {
            return new Date(((Date) value).getTime());
        } else if (value instanceof String) {
            // TODO
            return null;
        } else {
            return null;
        }
    }

}
