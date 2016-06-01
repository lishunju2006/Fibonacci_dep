#!/bin/sh 
source setenv.sh
rm -rf ${CATALINA_HOME}/webapps/Fibonacci
mkdir ${CATALINA_HOME}/webapps/Fibonacci
mkdir /tmp
cp -rf WebContent/* ${CATALINA_HOME}/webapps/Fibonacci/
