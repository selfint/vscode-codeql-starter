#!/bin/sh
cd "$(dirname "$0")"
mvn package
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
