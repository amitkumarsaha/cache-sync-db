/*
 * package com.amit.handler;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.net.URI; import java.net.URISyntaxException;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.context.SpringBootTest.WebEnvironment; import
 * org.springframework.boot.web.server.LocalServerPort; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.context.junit.jupiter.SpringExtension; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.amit.error.RestApiError;
 * 
 * @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 * 
 * @ExtendWith(SpringExtension.class) //@ContextConfiguration(classes = {
 * TestConfig.class }, loader = AnnotationConfigContextLoader.class) public
 * class RestApiExceptionHandlerTest {
 * 
 * @LocalServerPort int randomServerPort;
 * 
 * private RestTemplate restTemplate = new RestTemplate();
 * 
 * private static final String URL_PREFIX = "http://localhost:";
 * 
 * // private FormAuthConfig formConfig = new FormAuthConfig(URL_PREFIX +
 * "/login", // "temporary", "temporary");
 * 
 * // private RequestSpecification givenAuth() { // // return
 * RestAssured.given().auth().form("user", "userPass", formConfig); // // if
 * (cookie == null) { // // cookie = // //
 * RestAssured.given().contentType("application/x-www-form-urlencoded").
 * formParam("password", // // "userPass").formParam("username",
 * "user").post(URL_PREFIX + // // "/login").getCookie("JSESSIONID"); // // } //
 * // return RestAssured.given().cookie("JSESSIONID", cookie); // return
 * RestAssured.given().auth().preemptive().basic("user", "userPass"); // }
 * 
 * @Test public void whenMethodArgumentMismatch_thenBadRequest() throws
 * URISyntaxException { // RestTemplate restTemplate = new RestTemplate(); //
 * final String baseUrl = URL_PREFIX+"/cache-sync"; // URI uri = new
 * URI(baseUrl); String baseUrl = URL_PREFIX + randomServerPort + "/cache-sync";
 * URI uri = new URI(baseUrl); ResponseEntity<RestApiError> response =
 * restTemplate.getForEntity(uri, RestApiError.class);
 * 
 * // Response response = givenAuth().get(URL_PREFIX + "/api/foos/ccc"); //
 * RestApiError error = response.as(RestApiError.class);
 * 
 * RestApiError error = response.getBody();
 * 
 * assertEquals(HttpStatus.BAD_REQUEST, error.getStatus()); assertEquals(1,
 * error.getErrors().size());
 * assertTrue(error.getErrors().get(0).contains("should be of type"));
 * 
 * }
 * 
 * // @Test // public void whenNoHandlerForHttpRequest_thenNotFound() { // //
 * Response response = givenAuth().delete(URL_PREFIX + "/api/xx"); //
 * RestApiError error = response.as(RestApiError.class); // //
 * assertEquals(HttpStatus.NOT_FOUND, error.getStatus()); // assertEquals(1,
 * error.getErrors().size()); //
 * assertTrue(error.getErrors().get(0).contains("No handler found")); // } //
 * // @Test // public void
 * whenHttpRequestMethodNotSupported_thenMethodNotAllowed() { // Response
 * response = givenAuth().delete(URL_PREFIX + "/api/foos/1"); // RestApiError
 * error = response.as(RestApiError.class); // //
 * assertEquals(HttpStatus.METHOD_NOT_ALLOWED, error.getStatus()); //
 * assertEquals(1, error.getErrors().size()); //
 * assertTrue(error.getErrors().get(0).contains("Supported methods are")); // }
 * // // @Test // public void
 * whenSendInvalidHttpMediaType_thenUnsupportedMediaType() { // Response
 * response = givenAuth().body("").post(URL_PREFIX + "/api/foos"); //
 * RestApiError error = response.as(RestApiError.class); // //
 * assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, error.getStatus()); //
 * assertEquals(1, error.getErrors().size()); //
 * assertTrue(error.getErrors().get(0).contains("media type is not supported"));
 * // } }
 */