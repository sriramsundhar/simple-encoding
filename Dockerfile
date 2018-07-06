FROM java:8-jdk-alpine

WORKDIR /opt/app
# Copy contents of dist to /opt/app
ADD build/libs/ /opt/app
# Give ownership to daemon user
RUN ["chown", "-R", "daemon:daemon", "."]
USER daemon

CMD ["java","-jar","/opt/app/text-1.0-SNAPSHOT-all.jar"]
