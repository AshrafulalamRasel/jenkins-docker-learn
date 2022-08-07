FROM openjdk:17
WORKDIR '/app'
EXPOSE 9090
ADD target/docker-jenkins.jar docker-jenkins.jar
COPY . .
ENTRYPOINT ["java","-jar","docker-jenkins.jar"]
CMD ["mvn"]
