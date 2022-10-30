FROM adoptopenjdk:11-jre-hotspot
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir -p /logs
ENV JAR_FILE=/home/runner/work/happiness-savings-server/happiness-savings-server/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT exec java ${JAVA_OPTS} -jar /app.jar
EXPOSE 8080
