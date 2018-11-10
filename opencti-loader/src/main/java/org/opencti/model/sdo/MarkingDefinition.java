package org.opencti.model.sdo;

import org.opencti.model.database.BaseQuery;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.opencti.model.database.BaseQuery.from;

public class MarkingDefinition extends Domain {
    @Override
    public List<BaseQuery> neo4j() {
        String query = "MERGE (markingDefinition:MarkingDefinition {id: $id}) " +
                "ON CREATE SET markingDefinition = {" +
                /**/"id: $id, " +
                /**/"name: $name, " +
                /**/"description: $description, " +
                /**/"created: $created, " +
                /**/"tlp: $tlp, " +
                /**/"statement: $statement " +
                "} " +
                "ON MATCH SET " +
                /**/"markingDefinition.name = $name, " +
                /**/"markingDefinition.description = $description, " +
                /**/"markingDefinition.created = $created, " +
                /**/"markingDefinition.tlp = $tlp, " +
                /**/"markingDefinition.statement = $statement";
        return singletonList(from(query).withParams("id", getId(),
                "name", getName(),
                "description", getDescription(),
                "created", getCreated(),
                "modified", getModified(),
                "tlp", getDefinition().getTlp(),
                "statement", getDefinition().getStatement()
        ));
    }

    private StixDefinition definition;

    public StixDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(StixDefinition definition) {
        this.definition = definition;
    }
}