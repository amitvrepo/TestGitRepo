# Use the official Tomcat image with Java 17
FROM tomcat:10.1-jdk17


# Change Tomcat port to 9193
#RUN sed -i 's/port="8080"/port="9193"/g' $CATALINA_HOME/conf/server.xml

# Set working directory inside the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the WAR file to Tomcat's webapps directory
COPY target/sample-web.war /usr/local/tomcat/webapps/sample-web.war

# Expose Tomcat's default port
EXPOSE 8080

# Start Tomcat when the container starts
CMD ["catalina.sh", "run"]
