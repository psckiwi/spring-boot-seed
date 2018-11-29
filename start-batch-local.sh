#!/bin/sh

export SPRING_PROFILES_ACTIVE=dev,batch
./gradlew bootRun

