#!/usr/bin/env bash

mvn clean install package  -Dmaven.test.skip=true


cd web

mvn clean package  -Dmaven.test.skip=true


scp target/web-0.0.1-SNAPSHOT.jar root@localhost:/data

ssh -t root@localhost /data/kill_and_run_web.sh