package fr.adriencaubel.springapifirstapproach;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootApplication
public class SpringApifirstApproachApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApifirstApproachApplication.class, args);

        final OpenAPIParser openApiParser = new OpenAPIParser();
        final ParseOptions options = new ParseOptions();
        options.setResolve(true);
        options.setFlatten(true);
        final OpenAPI openAPI = openApiParser.readLocation("src/main/resources/openapi/main.yml", null, options).getOpenAPI();

        System.out.println(openAPI);

        String rawData = Json.pretty(openAPI);
        try {
            FileUtils.writeStringToFile(new File("src/main/resources/openapi/swagger.json"), rawData, Charset.defaultCharset() );
        } catch (IOException e) {
            throw new RuntimeException("Error writing file", e);
        }
    }

}
