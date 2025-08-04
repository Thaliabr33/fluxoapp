@echo off
chcp 65001 >nul
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

echo Compilando...
javac -encoding UTF-8 -d bin src\app\fluxoapp\Main.java

echo Executando...
java -cp bin app.fluxoapp.Main

pause
