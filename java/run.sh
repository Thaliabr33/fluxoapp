#!/bin/bash
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

echo "Compilando..."

# Cria a pasta bin se não existir
mkdir -p bin

# Compila todos os arquivos .java encontrados em src e subpastas
javac -encoding UTF-8 -d bin $(find src -name "*.java")

echo "Executando..."
java -cp bin app.fluxoapp.Main
