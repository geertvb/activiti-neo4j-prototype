package be.jdevit.activiti.neo4j.logging.formatters;

public abstract class AbstractTypeFormatter<T> implements TypeFormatter<T> {

    public abstract String doFormat(T object, GenericFormatter formatter);

    @Override
    public String format(T object, GenericFormatter formatter) {
        if (object == null) {
            return "NULL";
        } else {
            return doFormat(object, formatter);
        }
    }

}
