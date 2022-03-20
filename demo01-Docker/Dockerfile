FROM openjdk:oraclelinux8
MAINTAINER gruzam0615 <gruzam0615@gmail.com>
COPY ./java/ /usr/src/myapp
WORKDIR /usr/src/myapp
EXPOSE 8080
RUN cd /usr/src/myapp
CMD ["sh", "./test.sh"]