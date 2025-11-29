# Use a valid base image
FROM eclipse-temurin:8-jre

ENV MODE="DEVE"

# Copy the fat jar produced by mvn package (no leading slash)
COPY target/calculator-1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar

# Copy other files from the repo
COPY input.txt /input.txt
COPY app.sh /app.sh
RUN chmod +x /app.sh

ENTRYPOINT ["/app.sh"]
