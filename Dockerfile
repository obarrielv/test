FROM java:8
EXPOSE 8080
RUN find test-1.jar
ADD /target/test-1.jar test-1.jar
ENTRYPOINT ["java", "-jar", "test-1.jar"]