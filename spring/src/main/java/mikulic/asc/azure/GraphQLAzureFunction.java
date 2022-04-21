/*
package mikulic.asc.azure;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import graphql.ExecutionResult;
import graphql.GraphQL;
import mikulic.asc.graphql.GraphQLProvider;
import mikulic.asc.helpers.ObjectMapperHelper;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.io.IOException;

public class GraphQLAzureFunction extends FunctionInvoker<String, HttpResponseMessage> {

    @FunctionName("graphql2")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "graphQlRequest", methods = HttpMethod.POST, authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<String> request, ExecutionContext context) throws IOException {

        String query = ObjectMapperHelper.GetGraphQlBodyFromHttpRequest(request);

        GraphQL graphQL = new GraphQLProvider().graphQL();
        ExecutionResult result = graphQL.execute(query);

        return request.createResponseBuilder(HttpStatus.OK).body(result).build();
    }
}
*/