# Fixture <img src="https://raw.githubusercontent.com/chrisPiemonte/Fixture/master/src/main/resources/static/images/logo_mini.d9252743.png?token=AJohXj5CL3cGEQo1QKfLO61AcODy-9kIks5amfafwA%3D%3D" width="64">

[![Docker](https://img.shields.io/badge/Docker-17.05-blue.svg?style=flat-square)](https://www.docker.com/) [![AngularJS version](https://img.shields.io/badge/AngularJS-1.4.0-red.svg?style=flat-square)](https://angular.io/) [![Spring Boot](https://img.shields.io/badge/Spring-1.5.10-green.svg?style=flat-square)](https://spring.io/) [![PostgreSQL](https://img.shields.io/badge/PostgreSQL-10.2-blue.svg?style=flat-square)](https://www.postgresql.org/)

**Ticketing system** service composed of three layers:

 - **Client**: Single Page Application made using **[AngularJS](https://angular.io/)**

 - **Server**: Server Side Application exposed over http made using **[Spring Boot](https://spring.io/)**

 - **Database**: **[PostgreSQL](https://www.postgresql.org/)**

Everything runs inside **[Docker](https://www.docker.com/)** containers, linked together with **[Docker Compose](https://docs.docker.com/compose/overview/)**


## Setup

### Linux:
1. Install [docker](https://docs.docker.com/), [docker-compose](https://docs.docker.com/compose/install/) and [git](https://git-scm.com/book/it/v1/Per-Iniziare-Installare-Git)

2. Clone this repo:<pre>git clone https://github.com/chrisPiemonte/Fixture.git </pre> <pre>cd Fixture/</pre>

3. Run:<pre>docker-compose -p fixture up -d </pre>

## Get start
1. Open a web browser and go to <pre>http://localhost:8080</pre>

2. To populate the Database go to <pre>http://localhost:8080/api/populate</pre> (it takes a while)
