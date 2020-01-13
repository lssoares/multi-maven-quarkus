
FROM fabric8/java-jboss-openjdk8-jdk:1.5.4
USER jboss
ENV JAVA_APP_DIR=/deployments
EXPOSE 8080
COPY quarkus-root/target/lib/* /deployments/lib/
COPY quarkus-root/target/*-runner.jar /deployments/
ENTRYPOINT [ "/deployments/run-java.sh" ]
