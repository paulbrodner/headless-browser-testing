#!/usr/bin/env bash
set -e  # exit if commands fails
set -x  # trace what gets exe

WAIT_INTERVAL=1
COUNTER=0
TIMEOUT=2000
t0=`date +%s`

echo "Waiting for Standalone WebDriver HUB to Start..."
docker-compose config
docker-compose up -d
until $(curl --output /dev/null --silent --head --fail http://localhost:4444/wd/hub) || [ "$COUNTER" -eq "$TIMEOUT" ]; do
   printf '.'
   sleep $WAIT_INTERVAL
   COUNTER=$(($COUNTER+$WAIT_INTERVAL))
done

if (("$COUNTER" < "$TIMEOUT")) ; then
   t1=`date +%s`
   delta=$((($t1 - $t0)/60))
   echo "Standalone WebDriver Hub started in $delta minutes"
else
   echo "Waited $COUNTER seconds"
   echo "Standalone WebDriver Hub didn't started in time!"
   exit 1
fi
