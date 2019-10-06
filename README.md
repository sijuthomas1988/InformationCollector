# Information Collector API

Information Collector API is a REST API which collects data from different sources/API's

## Installation

Use Maven to build the application

```bash
mvn clean install
```
Upon successfully packaging the app, Use the command to start the application

```bash
mvn spring-boot:run
```
## Configuration

The RestAPI variables are mostly configurable. They will be needed to be configured in the application.yml file and/or use in Container management systems.Example Config Maps in Kubernetes.

* **External API configuration**: This has parameters like external api url, max limit of results that needs to be obtained.
```yml
apiconn:
  googleApiUrl: "https://www.googleapis.com/books/v1/volumes"
  appleApiUrl:  "http://itunes.apple.com/search"
  googleApilimit: "5"
  appleApilimit: "5"
```
* **JsonConfiguration**: Json configuration defines the rootnode, nodes and parameters from which the values needs to be fetched. 
```yml
jsonapiconf:
  googleapiroot: items
  googleapipath:
    - volumeInfo
  googleapiattributes:
    - title
    - printType
    - authors
```
## Usage

* **Health** :
Endpint used to determine whether the service is Up or Not
[http://localhost:8080/infoApp/actuator/health](http://localhost:8080/infoApp/actuator/health)

* **Swagger**:
Endpoint used to determine the API endpoint and the response and error models
You can execute the application from within the swagger endpoint by clicking on "Try It Out".
[http://localhost:8080/infoApp/swagger-ui.html](http://localhost:8080/infoApp/swagger-ui.html)

* **Metrics**:
Endpoint used to determine the metrics of the application and the environment statistics assosiated with it.

  http://localhost:8080/infoApp/actuator/metrics

* For Specific metrics, like http.server.requests, append the same to the url above.

* API EndPoint:
The API endpoint can be found in Swagger documentation. 
There is only one endpoint as it is still in development phase. But feel free to try it out.
http://localhost:8080/infoApp/v1/getInfo/{input}

  Where you can use any word or character to fetch the results by appending to the word {input} in the url.
## Dependencies

## Support & Ownership

Feel free to ask [Sijumon Karyil Raju](sijumon.skr@gmail.com) if you need some support when there are any questions left or if you need some support.