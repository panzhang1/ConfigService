# ConfigService
This is ConfigService

Rule As Jar:
build:
./gradlew build
Run:
./gradlew bootRun

## Config Service
- Fetch config Information
- Client can refresh the config change by send POST http://localhost:8082/actuator/refresh
- It will only refresh custom defined property, the spring native property like datasource are not able to refresh
- It need refresh all client instance: 1) write code to get all instance from register service, then refresh one by one 2) directly re-start instance one by one
