package mikulic.asc.azure;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import graphql.ExecutionResult;
import mikulic.asc.helpers.ObjectMapperHelper;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.io.IOException;

public class GraphQlHandler extends FunctionInvoker<String, ExecutionResult> {

    @FunctionName("graphql")
    public ExecutionResult execute(
            @HttpTrigger(name = "request", methods = HttpMethod.POST, authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<String> request, ExecutionContext context) throws IOException {

        String query = ObjectMapperHelper.GetGraphQlBodyFromHttpRequest(request);

        return handleRequest(query, context);
    }
}
