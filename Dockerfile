FROM java:8
EXPOSE 8080
RUN rename 's/ /target/.jar/test.jar/ *'
RUN ls -l
RUN ls -l /target/
ADD /target/test.jar test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]