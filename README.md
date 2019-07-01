# ConfigService
This is ConfigService

## Usage Guild
- Directly Run
gradle build
gradle bootRun
gradle bootRun --debug-jvm

- Run by Docker
https://spring.io/guides/gs/spring-boot-docker/#initial

gradle build docker
docker run -p 8888:8888 -t pangu/configservice

- Debug for Docker
docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"

- stop Docker service
docker ps
docker stop "container id"
docker rm "container id"

## Config Service
- Fetch config Information
- Client can refresh the config change by send POST http://localhost:8082/actuator/refresh
- It will only refresh custom defined property, the spring native property like datasource are not able to refresh
- It need refresh all client instance: 1) write code to get all instance from register service, then refresh one by one 2) directly re-start instance one by one
