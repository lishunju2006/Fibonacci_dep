#!/bin/sh 
export JAVA_HOME=<Installation directory of jdk>
export CATALINA_HOME=<Installation directory of jdk>
export ANT_HOME=<Installation directory of jdk>
export PATH=.:${JAVA_HOME}/bin:${ANT_HOME}/bin:${PATH}:
export CLASSPATH=.:${JAVA_HOME}/lib:${CLASSPATH}:

