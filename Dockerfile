FROM java:8
EXPOSE 8080
ADD /target/*.jar test-1.jar
ENTRYPOINT ["java", "-jar", "test-1.jar"]