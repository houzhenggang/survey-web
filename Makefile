deploy : | install
	cp target/surveyrest.war /var/lib/tomcat/webapps/
install :
	git pull
	mvn clean package