#!/usr/bin/env bash
set -e
command -v mvn >/dev/null || { echo "Maven no esta instalado. Instala Apache Maven y vuelve a ejecutar este archivo."; exit 1; }
mvn clean package
java -jar target/waividol-universe-1.0.0.jar
