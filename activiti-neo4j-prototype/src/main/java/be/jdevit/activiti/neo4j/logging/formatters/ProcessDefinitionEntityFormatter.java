package be.jdevit.activiti.neo4j.logging.formatters;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class ProcessDefinitionEntityFormatter extends AbstractTypeFormatter<ProcessDefinitionEntity> {

    @Override
    public String doFormat(ProcessDefinitionEntity object, GenericFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessDefinitionEntity");
        sb.append("[");
        sb.append("id=" + formatter.format(object.getId()));
        sb.append(", ");
        sb.append("name=" + formatter.format(object.getName()));
        sb.append(", ");
        sb.append("key=" + formatter.format(object.getKey()));
        sb.append(", ");
        sb.append("version=" + formatter.format(object.getVersion()));
        sb.append(", ");
        sb.append("resourceName=" + formatter.format(object.getResourceName()));
        sb.append(", ");
        sb.append("deploymentId=" + formatter.format(object.getDeploymentId()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Class getType() {
        return ProcessDefinitionEntity.class;
    }

}
