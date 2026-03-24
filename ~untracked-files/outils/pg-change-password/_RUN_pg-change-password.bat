@ECHO OFF
::CHCP 1252 >NUL
::CHCP 850 >NUL
CHCP 65001 >NUL
PROMPT $G
CD /D "%~dp0"

SET    FULLPATH_ROOT=C:\DEV26
SET     PATH_DIR_JDK=jdk-21
SET PATH_GROUP_UTILS=utils

SET   JAVA_HOME=%FULLPATH_ROOT%\%PATH_DIR_JDK%
SET    ANT_HOME=%FULLPATH_ROOT%\%PATH_GROUP_UTILS%\ant

SET ANT_OPTS=-Dpolyglot.engine.WarnInterpreterOnly=false -Djava.security.manager=allow

CALL "%ANT_HOME%\bin\ant.bat" -f "%~dp0pg-change-password.xml"

EcHO. & PAUSE
