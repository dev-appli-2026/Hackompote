@ECHO OFF
CHCP 1252 >NUL
PROMPT $G
CD /D "%~dp0"
ECHO. & ECHO.

IF EXIST  1-tables.txt DEL 1-tables.txt
C:\DEV26\utils\bin\elevate.exe -c MKLINK  1-tables.txt sql\1-tables.sql ^& ECHO. ^& PAUSE

::ECHO. & PAUSE