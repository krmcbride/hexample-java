FROM krmcbride/corretto:11-amazonlinux2-base

WORKDIR /usr/src/app

# prevent "unmappable character for encoding ASCII" errors
ENV \
  LANG=en_US.UTF-8 \
  LC_ALL=en_US.UTF-8

# todo: is this required?
RUN yum install -y \
      openssl \
    && yum clean all \
    && rm -rf /var/cache/yum

COPY \
    docker-entrypoint.sh \
    resolve.gradle \
    /

# Resolve gradle itself in its own own layer
COPY gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew -Dorg.gradle.daemon=false

# Resolve project dependencies in their own layer
COPY build.gradle settings.gradle gradle.properties ./
RUN remoteci_env ./gradlew -Dorg.gradle.daemon=false -I /resolve.gradle resolve

# Copy the rest of the project and build
COPY . ./
RUN ./gradlew -Dorg.gradle.daemon=false build -x test
COPY /usr/src/app/hexample-server/build/libs/hexample-server.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["/docker-entrypoint.sh"]
ARG CALVER
ARG GIT_TAG
ENV DD_VERSION ${GIT_TAG:-${CALVER}}
