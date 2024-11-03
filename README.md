# Explication
Minimal Spring API First project

Lorsqu'on souhaite définir une approche API nous devons respecter l'ordre suivant
1. Créer des openapi `.yml` file qui décrivent notre API. Dans notre cas ils sont dans `src/main/resources/openapi`. On notera l'utilisation de `$ref` pour découper notre fichier.
2. Cependant le plugin qui génèrera le code `openapi-generator-maven-plugin` ne résoud pas les `$ref`. En effet, nous devons lui fournir un fichier complet
3. C'est pour cette raison que nous avons la classe `OpenAPIJsonGenerator` qui se charger de parser (`io.swagger.parser.v3`) notre `main.yml`
4. Pour que le parsing soit automatique lorsqu'on `mvn compile`, nous utilisons le plugin `exec-maven-plugin`
5. Et pour que la classe soit compiler avant son execution nous devons utiliser le plugin `maven-compiler-plugin`

Ainsi l'exécution est la suivante
1. A partir du `main.yml`
2. Générer un fichier avec `$ref` résolues nommé `swagger.json` (via classe `OpenAPIJsonGenerator`)
3. Puis générer l'ensemble des interfaces et DTO (via plugin `openapi-generator-maven-plugin`)