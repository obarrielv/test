FROM java:8
EXPOSE 8085
ADD /target/test-1.jar test-1.jar
ENTRYPOINT ["java", "-jar", "test-1.jar"]