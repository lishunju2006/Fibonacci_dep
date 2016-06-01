#!/bin/sh
#
# watchdog
#
# Add it into crontab to monitor Apache process.
#

NAME=org.apache.catalina.startup.Bootstrap
# MAIL=/bin/mail
TOLIST=xxxx@gmail.com

ps -ef|grep -v grep|grep $NAME >/dev/null 2>&1
case "$?" in
  0)
  # Service is Running OK.
  echo "$NAME is RUNNING OK. Relax."
  ;;
  1)
  echo "$NAME is NOT RUNNING. Starting $NAME and sending notices."
  
  NOTICE=/tmp/watchdog.txt
  echo "$NAME was not running and was started on `$DATE`" > $NOTICE
  # $MAIL -n -s "watchdog notice" $TOLIST < $NOTICE
  rm -f $NOTICE
  #
  source ${ABSOLUTE_PATH}/setenv.sh
  ${CATALINA_HOME}/bin/startup.sh >/dev/null 2>&1 &
  ;;
esac
