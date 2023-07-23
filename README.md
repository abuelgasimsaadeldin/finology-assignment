# Backend Engineer Assignment

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode
1) Run the application in dev mode by using the following command:    
```shell script
mvn compile quarkus:dev
```

## Ready to use swagger UI
You can use the ready-to-use swagger ui at http://localhost:8080/swagger after running the application.

### 1) REST API Endpoint: /api/v1/cars/{carType}

### Example Request
```
carType: electrical
```

### Example Response
```
{
  "type": "Electrical Car",
  "carPart1": "battery",
  "carPart2": "motor",
  "carPart3": "chassis"
}
```

## Unit test
There is a unit test that has been created to test the car type service:
```CarResourceTest.java```: To test that the carType API is working for all the three car types (electrical, 2wheels and sport)

## Running the unit tests
Run the unit tests by right-clicking on the java class and clicking on ```Run carResourceTest()```

Expected Results
![TestsPassed](https://github.com/abuelgasimsaadeldin/finology-assignment/assets/68045710/e93e51b1-c041-47c2-8555-0b21aa2cb041)

## Steps to Dockerize and Deploy the program using Dockerfile

1) Package the application:
```
mvn package
```

2) Build the docker image:
```
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/car-service-jvm .
```

3) Check that the docker image had been created:
```
docker images
```

4) Deploy the image to the docker container:
```
docker run -i --rm -p 8080:8080 quarkus/car-service-jvm
```


