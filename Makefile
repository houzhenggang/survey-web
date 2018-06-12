deploy :
	mvn clean package
	echo "copying to /opt/tomcat/webapps"
	cp target/surveyrest.war /opt/tomcat/webapps/
