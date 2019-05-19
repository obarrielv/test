FROM java:8
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "test-1.jar"]