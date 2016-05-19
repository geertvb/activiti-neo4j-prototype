package be.jdevit.activiti.neo4j.logging.formatters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GenericFormatterImpl implements GenericFormatter {

    @Autowired
    protected List<TypeFormatter> typeFormatters;

    @Autowired
    protected TypeFormatter defaultTypeFormatter;

    protected Map<Class, TypeFormatter> formatterMap = new HashMap<>();

    public TypeFormatter getFormatter(Object object) {
        if (object == null) {
            return defaultTypeFormatter;
        }
        TypeFormatter typeFormatter = formatterMap.get(object.getClass());
        if (typeFormatter == null) {
            for (TypeFormatter f : typeFormatters) {
                if (f.getType() != null && f.getType().isInstance(object)) {
                    typeFormatter = f;
                    formatterMap.put(object.getClass(), f);
                    break;
                }
            }
        }
        if (typeFormatter != null) {
            return typeFormatter;
        } else {
            return defaultTypeFormatter;
        }
    }

    public String format(Object o) {
        TypeFormatter typeFormatter = getFormatter(o);
        return typeFormatter.format(o, this);
    }

}
