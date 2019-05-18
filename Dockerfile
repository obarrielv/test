FROM java:8
EXPOSE 8080
RUN rename 's/ /target/.jar/test.jar/ *'
ADD /target/test.jar test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]