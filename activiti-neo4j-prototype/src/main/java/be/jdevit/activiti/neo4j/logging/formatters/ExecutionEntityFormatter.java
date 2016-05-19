package be.jdevit.activiti.neo4j.logging.formatters;

import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.stereotype.Component;

@Component
public class ExecutionEntityFormatter extends AbstractTypeFormatter<ExecutionEntity> {

    @Override
    public String doFormat(ExecutionEntity object, GenericFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("ExecutionEntity");
        sb.append("[");
        sb.append("id=" + formatter.format(object.getId()));
        sb.append(", ");
        sb.append("processInstanceId=" + formatter.format(object.getProcessInstanceId()));
        sb.append(", ");
        sb.append("parentId=" + formatter.format(object.getParentId()));
        sb.append(", ");
        sb.append("processDefinitionId=" + formatter.format(object.getProcessDefinitionId()));
        sb.append(", ");
        sb.append("activityId=" + formatter.format(object.getCurrentActivityId()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Class getType() {
        return ExecutionEntity.class;
    }

}
