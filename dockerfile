FROM openjdk:8-jdk
VOLUME /tmp
EXPOSE 8081
ADD target/quotation-management-0.0.1-SNAPSHOT.jar quotation-management.jar
ENTRYPOINT [ "java", "-jar", "quotation-management.jar" ]