package be.jdevit.activiti.neo4j.logging.formatters;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateFormatter extends AbstractTypeFormatter<Date> {

    protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss,SSS");

    @Override
    public Class getType() {
        return Date.class;
    }

    @Override
    public String doFormat(Date object, GenericFormatter formatter) {
        return dateFormat.format(object);
    }

}
