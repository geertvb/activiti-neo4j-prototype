package be.jdevit.activiti.neo4j.logging.formatters;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.springframework.stereotype.Component;

@Component
public class DeploymentEntityFormatter extends AbstractTypeFormatter<DeploymentEntity> {

    @Override
    public String doFormat(DeploymentEntity object, GenericFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("DeploymentEntity");
        sb.append("[");
        sb.append("id=" + formatter.format(object.getId()));
        sb.append(", ");
        sb.append("deploymentTime=" + formatter.format(object.getDeploymentTime()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Class getType() {
        return DeploymentEntity.class;
    }

}
