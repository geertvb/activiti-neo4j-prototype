package be.jdevit.activiti.neo4j.logging.formatters;

public interface TypeFormatter<T> {

    Class getType();

    String format(T object, GenericFormatter formatter);

}
