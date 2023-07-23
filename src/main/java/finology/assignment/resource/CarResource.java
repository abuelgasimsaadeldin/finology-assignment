package finology.assignment.resource;

import com.google.gson.Gson;
import finology.dto.CarParts;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/v1/cars")
public class CarResource {

    @GET
    @Path("/{carType}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getCarType",
            summary = "Get car parts",
            description = "Returns car parts based on the car type. " +
                    "Car type can be electrical, 2wheels or sport."
    )
    public Response getCarByType(@PathParam("carType") String carType) {
        CarParts carParts;

        switch (carType) {
            case "electrical" -> {
                carParts = new CarParts("Electrical Car", "battery", "motor", "chassis");
            }
            case "2wheels" -> {
                carParts = new CarParts("2-wheeled Car", "brakes", "wheels", "frame");
            }
            case "sport" -> {
                carParts = new CarParts("Sport car", "engine", "tire", "transmission");
            }

            default -> {
                return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Invalid car type\"}").build();
            }
        }

        String jsonCar = convertObjectToJson(carParts);
        return Response.status(Response.Status.OK).entity(jsonCar).build();
    }

    private String convertObjectToJson(CarParts carParts) {
        Gson gson = new Gson();
        return gson.toJson(carParts);
    }
}
