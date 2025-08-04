@echo off
chcp 65001 >nul
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

echo Criando pasta bin...
if not exist bin (
    mkdir bin
)

echo Criando lista de arquivos...
dir /b /s src\*.java > sources.txt

echo Compilando...
javac -encoding UTF-8 -d bin @sources.txt

del sources.txt

echo Executando...
java -cp bin app.fluxoapp.Main

pause
