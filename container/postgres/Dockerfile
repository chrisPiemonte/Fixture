FROM postgres:10.2-alpine


ADD ./database/schema.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_PASSWORD qwe
ENV POSTGRES_DB fixture

ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 5432
CMD ["postgres"]