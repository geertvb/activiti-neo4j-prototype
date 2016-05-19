package be.jdevit.activiti.neo4j.logging.formatters;

import org.activiti.engine.impl.persistence.entity.HistoricProcessInstanceEntity;
import org.springframework.stereotype.Component;

@Component
public class HistoricProcessInstanceEntityFormatter extends AbstractTypeFormatter<HistoricProcessInstanceEntity> {
    @Override
    public String doFormat(HistoricProcessInstanceEntity object, GenericFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("HistoricProcessInstanceEntity");
        sb.append("[");
        sb.append("id=" + formatter.format(object.getId()));
        sb.append(", ");
        sb.append("processInstanceId=" + formatter.format(object.getProcessInstanceId()));
        sb.append(", ");
        sb.append("processDefinitionId=" + formatter.format(object.getProcessDefinitionId()));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Class getType() {
        return HistoricProcessInstanceEntity.class;
    }
}
