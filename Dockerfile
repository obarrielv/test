FROM java:8
EXPOSE 8080
ADD /target/test-1.jar test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]