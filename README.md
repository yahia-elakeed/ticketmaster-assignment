# Ticketmaster assignment

Ticketmaster assignment is a RESTful API for data regarding events, venues and artists.

## Features

- Get artist information for a specific artist, this will contain all fields of the given artist and all the events the artist will perform at.

## Tech

assignment uses a number of open source projects to work properly:

- [Java17]
- [SpringBoot-2.7.4]
- [playtika.reactivefeign] - **Why used:** Implementation of Feign on Spring WebClient, Brings you the best of two worlds together : concise syntax of Feign to write client side API on fast, asynchronous and non-blocking HTTP client of Spring WebClient.
- [Maven]

## Installation (Run locally)
    prerequisites: java17 and maven installed
    - to run the app from terminal: mvn spring-boot:run
**After app is up and running endpoints will be available through this swagger link http://localhost:8080/ticketmaster/api/swagger-ui/**

## Codes

| Code | Constant                        | Reason Phrase      |
|------| ------------------------------- |--------------------|
| 200  | OK                              | OK                 |
| 404  | NOT_FOUND                       | Not Found          |
| 503  | SERVICE_UNAVAILABLE             | Service Unavailable |

## Possible future enhancements to implement
- authentication and authorization
- cache most common requested artists to avoid too many calls to external resources which improve performance and stability
- Dockerizing the application and running using Docker containers to ship the application with all the necessary functionalities as one package.
