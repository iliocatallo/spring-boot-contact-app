FROM openjdk:12-jdk-alpine as builder

RUN jlink \
    --no-header-files \
    --no-man-pages \
    --compress=2 \
    --strip-debug \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --output /opt/jre

RUN mkdir /contact-app
COPY ./ /contact-app
WORKDIR /contact-app
RUN ./gradlew build

FROM alpine:3.8

COPY --from=builder /opt/jre /opt/jre
COPY --from=builder /contact-app/build/libs/contact-app.jar /opt

ENV JAVA_HOME=/opt/jre
ENV PATH="$PATH:$JAVA_HOME/bin"

EXPOSE 8080
CMD java -jar /opt/contact-app.jar



