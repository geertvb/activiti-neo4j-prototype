package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.db.Entity;
import org.activiti.engine.impl.persistence.entity.data.DataManager;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractNeo4jDataManager<EntityImpl extends Entity> implements DataManager<EntityImpl> {

    @Autowired
    protected GraphDatabaseService graphDatabaseService;

    @Autowired
    protected IdGenerator idGenerator;

    protected Class<? extends EntityImpl> entityClass;

    public AbstractNeo4jDataManager() {
    }

    public AbstractNeo4jDataManager(Class<? extends EntityImpl> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityImpl create() {
        try {
            EntityImpl entity = entityClass.newInstance();
            entity.setId(idGenerator.getNextId());
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create entity " + entityClass, e);
        }
    }

    public EntityImpl findById(String entityId) {
        return null;
    }

    public void insert(EntityImpl entity) {
        System.out.println("insert entity = " + entity + " (" + this.getClass().getSimpleName()+ ")");
    }

    public EntityImpl update(EntityImpl entity) {
        return null;
    }

    public void delete(String id) {

    }

    public void delete(EntityImpl entity) {

    }

}
