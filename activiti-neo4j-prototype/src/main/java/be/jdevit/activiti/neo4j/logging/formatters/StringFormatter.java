package be.jdevit.activiti.neo4j.logging.formatters;

import org.springframework.stereotype.Component;

@Component
public class StringFormatter extends AbstractTypeFormatter<String> {

    @Override
    public Class getType() {
        return String.class;
    }

    @Override
    public String doFormat(String object, GenericFormatter formatter) {
        return "\"" + object + "\"";
    }

}
