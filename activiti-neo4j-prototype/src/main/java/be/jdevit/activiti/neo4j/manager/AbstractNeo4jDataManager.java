package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.db.Entity;
import org.activiti.engine.impl.persistence.entity.data.DataManager;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractNeo4jDataManager<EntityImpl extends Entity> implements DataManager<EntityImpl> {

    @Autowired
    protected GraphDatabaseService graphDatabaseService;

    @Autowired
    protected IdGenerator idGenerator;

}
