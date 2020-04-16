FROM openjdk:8
ENV PORT 4444

WORKDIR /usr/app/
COPY /build/libs/* ./app.jar

EXPOSE $PORT
ENTRYPOINT ["java"]
CMD  ["-jar", "app.jar"]