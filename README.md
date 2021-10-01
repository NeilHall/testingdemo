docker pull sonarqube:7.9.1-community

docker run -d --name sonarqube7 -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:7.9.1-community
