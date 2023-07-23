package finology.assignment;

import finology.assignment.resource.CarResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarResourceTest {
    private static final Logger log = Logger.getLogger(CarResourceTest.class);

    @BeforeAll
    static void beforeAll() {
        log.info("Running CarServiceTest tests");
    }

    CarResource carResource = new CarResource();

    @Test
    @Order(1)
    public void testGetCarByTypeElectrical() {
        String carType = "electrical";
        Response response = carResource.getCarByType(carType);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String jsonResponse = response.getEntity().toString();

        String expectedJsonResponse = "{\"type\":\"Electrical Car\",\"carPart1\":\"battery\",\"carPart2\":\"motor\",\"carPart3\":\"chassis\"}";
        Assertions.assertEquals(expectedJsonResponse, jsonResponse);
        log.info("electricalCarTypeTest Passed !");
    }

    @Test
    @Order(2)
    public void testGetCarByType2Wheels() {
        String carType = "2wheels";
        Response response = carResource.getCarByType(carType);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String jsonResponse = response.getEntity().toString();

        String expectedJsonResponse = "{\"type\":\"2-wheeled Car\",\"carPart1\":\"brakes\",\"carPart2\":\"wheels\",\"carPart3\":\"frame\"}";
        Assertions.assertEquals(expectedJsonResponse, jsonResponse);
        log.info("2wheelsCarType Passed !");
    }

    @Test
    @Order(3)
    public void testGetCarByTypeSport() {
        String carType = "sport";
        Response response = carResource.getCarByType(carType);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String jsonResponse = response.getEntity().toString();

        String expectedJsonResponse = "{\"type\":\"Sport car\",\"carPart1\":\"engine\",\"carPart2\":\"tire\",\"carPart3\":\"transmission\"}";
        Assertions.assertEquals(expectedJsonResponse, jsonResponse);
        log.info("sportCarTypeTest Passed !");
    }
}