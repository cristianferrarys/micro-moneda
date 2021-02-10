FROM openjdk:8
VOLUMEN /tmp
ADD ./target/micro-moneda-0.0.1-SNAPSHOT.jar micro-moneda.jar
ENTRYPOINT ["java","-jar","/micro-moneda.jar"]