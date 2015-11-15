package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.db.Entity;
import org.activiti.engine.impl.persistence.entity.data.DataManager;

public class AbstractNeo4jDataManager<EntityImpl extends Entity> implements DataManager<EntityImpl> {

    protected ProcessEngineConfiguration processEngineConfiguration;

    public AbstractNeo4jDataManager() {
    }

    public AbstractNeo4jDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration;
    }

    public EntityImpl create() {
        return null;
    }

    public EntityImpl findById(String entityId) {
        return null;
    }

    public void insert(EntityImpl entity) {

    }

    public EntityImpl update(EntityImpl entity) {
        return null;
    }

    public void delete(String id) {

    }

    public void delete(EntityImpl entity) {

    }

}
