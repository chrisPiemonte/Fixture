# https://github.com/elastic/logstash-docker
FROM docker.elastic.co/logstash/logstash-oss:6.2.1

# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json

ADD https://jdbc.postgresql.org/download/postgresql-42.2.1.jar /usr/share/logstash/jdbc/postgresql-42.2.1.jar

# RUN logstash-plugin install logstash-input-jdbc
RUN logstash-plugin install logstash-input-http
