package be.jdevit.activiti.neo4j.logging.formatters;

import org.springframework.stereotype.Component;

@Component
public class DefaultTypeFormatter extends AbstractTypeFormatter<Object> {

    @Override
    public String doFormat(Object object, GenericFormatter formatter) {
        return "" + object;
    }

    @Override
    public Class getType() {
        return null;
    }

}
