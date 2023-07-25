#!/usr/bin/env bash
set -e
JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom ${JAVA_OPTS}"
exec java ${JAVA_AGENT} ${JAVA_OPTS} -jar ${JAVA_JAR-/app.jar} "$@"
