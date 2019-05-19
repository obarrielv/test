FROM java:8
EXPOSE 8080
ADD /test/test/1/test-1.jar test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]