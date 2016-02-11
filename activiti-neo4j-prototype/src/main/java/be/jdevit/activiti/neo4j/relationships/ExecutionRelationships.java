package be.jdevit.activiti.neo4j.relationships;

import org.neo4j.graphdb.RelationshipType;

public enum ExecutionRelationships implements RelationshipType {

    TASK, PARENT_OF

}
