#!/bin/bash
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

echo "Compilando..."
javac -encoding UTF-8 -d bin $(find src -name "*.java")

echo "Executando..."
java -cp bin app.fluxoapp.Main
