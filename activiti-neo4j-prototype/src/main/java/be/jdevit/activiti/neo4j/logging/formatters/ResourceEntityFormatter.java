package be.jdevit.activiti.neo4j.logging.formatters;

import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.springframework.stereotype.Component;

@Component
public class ResourceEntityFormatter extends AbstractTypeFormatter<ResourceEntity> {

    @Override
    public String doFormat(ResourceEntity object, GenericFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceEntity");
        sb.append("[");
        sb.append("id=" + formatter.format(object.getId()));
        sb.append(", ");
        sb.append("name=" + formatter.format(object.getName()));
        sb.append(", ");
        sb.append("deploymentId=" + formatter.format(object.getDeploymentId()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Class getType() {
        return ResourceEntity.class;
    }


}
