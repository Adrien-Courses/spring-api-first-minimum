package fr.adriencaubel.springapifirstapproach;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class OpenAPIJsonGenerator {
    public static void main(String[] args) {
        try {
            String inputPath = args[0];
            String outputPath = args[1];

            ParseOptions options = new ParseOptions();
            options.setResolve(true);
            options.setFlatten(true);

            OpenAPI openAPI = new OpenAPIParser()
                    .readLocation(inputPath, null, options)
                    .getOpenAPI();

            String jsonContent = Json.pretty(openAPI);
            FileUtils.writeStringToFile(
                    new File(outputPath),
                    jsonContent,
                    StandardCharsets.UTF_8
            );

        } catch (Exception e) {
            System.err.println("Error generating OpenAPI JSON: " + e.getMessage());
            System.exit(1);
        }
    }
}