package API_Testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.containsString;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestDemo {

    public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        System.out.println("============== GET REQUEST ==============");

        // GET Request
        Response getResponse =

                given()

                .when()

                .get("/posts/1");

        // Print Response
        System.out.println("Status Code : "
                + getResponse.getStatusCode());

        System.out.println("Response Body : ");
        System.out.println(getResponse.getBody().asString());

        System.out.println("Response Time : "
                + getResponse.getTime());

        System.out.println("Content Type : "
                + getResponse.getContentType());


        System.out.println("\n============== VALIDATIONS ==============");

        // Validations
        given()

                .when()

                .get("/posts/1")

                .then()

                .statusCode(200)

                .body("id", equalTo(1))

                .body("userId", equalTo(1))

                .time(lessThan(5000L))

                .header("Content-Type",
                        containsString("application/json"))

                .log().all();


        System.out.println("\n============== JSON EXTRACTION ==============");

        // JSON Extraction
        JsonPath jsonPath =
                getResponse.jsonPath();

        int id =
                jsonPath.getInt("id");

        int userId =
                jsonPath.getInt("userId");

        String title =
                jsonPath.getString("title");

        System.out.println("ID : " + id);

        System.out.println("User ID : " + userId);

        System.out.println("Title : "
                + title);


        System.out.println("\n============== POST REQUEST ==============");

        // Request Body
        String postRequestBody =
                "{ \"title\":\"API Testing\", \"body\":\"Learning RestAssured\", \"userId\":1 }";

        // POST Request
        Response postResponse =

                given()

                        .contentType(ContentType.JSON)

                        .body(postRequestBody)

                        .when()

                        .post("/posts");

        // POST Validation
        postResponse.then()

                .statusCode(201)

                .log().all();

        // Extract Generated ID
        int generatedId =
                postResponse.jsonPath().getInt("id");

        System.out.println("Generated ID : "
                + generatedId);


        System.out.println("\n============== PUT REQUEST ==============");

        // PUT Request Body
        String putRequestBody =
                "{ \"id\":1, \"title\":\"Updated Title\", \"body\":\"Updated Body\", \"userId\":1 }";

        // PUT Request
        given()

                .contentType(ContentType.JSON)

                .body(putRequestBody)

                .when()

                .put("/posts/1")

                .then()

                .statusCode(200)

                .log().all();


        System.out.println("\n============== PATCH REQUEST ==============");

        // PATCH Request Body
        String patchRequestBody =
                "{ \"title\":\"Patched Title\" }";

        // PATCH Request
        given()

                .contentType(ContentType.JSON)

                .body(patchRequestBody)

                .when()

                .patch("/posts/1")

                .then()

                .statusCode(200)

                .log().all();


        System.out.println("\n============== DELETE REQUEST ==============");

        // DELETE Request
        given()

                .when()

                .delete("/posts/1")

                .then()

                .statusCode(200)

                .log().all();


        System.out.println("\n============== PATH PARAMETER ==============");

        // Path Parameter
        given()

                .pathParam("id", 2)

                .when()

                .get("/posts/{id}")

                .then()

                .statusCode(200)

                .log().all();


        System.out.println("\n============== QUERY PARAMETER ==============");

        // Query Parameter
        given()

                .queryParam("userId", 1)

                .when()

                .get("/posts")

                .then()

                .statusCode(200)

                .log().all();


        System.out.println("\n============== HEADERS ==============");

        // Headers Example
        given()

                .header("Content-Type",
                        "application/json")

                .when()

                .get("/posts/1")

                .then()

                .statusCode(200)

                .log().headers();


        System.out.println("\n============== REQUEST CHAINING ==============");

        // POST Request
        Response chainResponse =

                given()

                        .contentType(ContentType.JSON)

                        .body(postRequestBody)

                        .when()

                        .post("/posts");

        // Extract ID
        int chainId =
                chainResponse.jsonPath().getInt("id");

        System.out.println("Chain ID : "
                + chainId);

        // GET using same ID
        given()

                .pathParam("id", chainId)

                .when()

                .get("/posts/{id}")

                .then()

                .log().all();


        System.out.println("\n============== PRINT HEADERS ==============");

        // Print Headers
        getResponse.getHeaders().forEach(
                System.out::println);


        System.out.println("\n============== PRINT COOKIES ==============");

        // Print Cookies
        getResponse.getCookies().forEach(
                (k, v) -> System.out.println(
                        k + " : " + v));

        System.out.println("\n============== TEST COMPLETED ==============");
    
    }
}