package mikulic.asc.azure;

import graphql.ExecutionResult;
import mikulic.asc.graphql.GraphQLProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GraphQlFunction implements Function<String, ExecutionResult> {
    @Autowired
    GraphQLProvider graphQLProvider;

    @Override
    public ExecutionResult apply(String query) {
        ExecutionResult result = graphQLProvider.graphQL().execute(query);
        return result;
    }
}
