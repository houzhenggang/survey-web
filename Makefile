i_deploy : | install deploy

deploy :
	echo "copying to /opt/tomcat/webapps"
	cp target/surveyrest.war /opt/tomcat/webapps/
	tail -f /opt/tomcat/catalina.out

install :
	git pull
	mvn clean package

