FROM chrispiemo/java-maven

ADD ./src /code/server/src
ADD ./pom.xml /code/server/pom.xml

WORKDIR /code/server
RUN mvn package -Dmaven.test.skip=true

ENTRYPOINT ["java", "-jar"]
CMD ["target/fixture-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080