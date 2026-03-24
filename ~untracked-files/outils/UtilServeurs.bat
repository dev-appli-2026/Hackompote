@ECHO OFF
SETLOCAL
CHCP 65001 >NUL
CD /D "%~dp0"

SET      ROOT_DEV=C:\DEV26
SET  PATH_DIR_JDK=jdk-21

SET  LOCAL_CONFIG=utilserveurs
SET  DBEAVER_HOME=%ROOT_DEV%\dbeaver
SET  UTILSVR_HOME=%ROOT_DEV%\UtilServeurs26
SET  ELEVATE_HOME=%UTILSVR_HOME%\lib

SET JAVA_HOME=%ROOT_DEV%\%PATH_DIR_JDK%
IF NOT EXIST "%JAVA_HOME%" (
  SET   JAVA_HOME=%UTILSVR_HOME%\lib\jre
)

SET MODULEPATH=^
%UTILSVR_HOME%\lib\appli;^
%UTILSVR_HOME%\lib\modulepath

SET CLASSPATH=^
%LOCAL_CONFIG%;^
%UTILSVR_HOME%\config;^
%UTILSVR_HOME%\lib\drivers\*;^
%UTILSVR_HOME%\lib\classpath\*

SET ARGS_VM=^
 --module-path "%MODULEPATH%"^
 --class-path "%CLASSPATH%"

SET ARGS_APPLI=^
 -Dpath.root.appdata="%ROOT_DEV%\UserData"^
 -Dpath.root.softs="%UTILSVR_HOME%\srv"^
 -Dpath.dir.jdk="%JAVA_HOME%"^
 -Dpath.exe.dbeaver="%DBEAVER_HOME%\dbeaver"^
 -Dpath.exe.elevate="%ELEVATE_HOME%\elevate"

START "" "%UTILSVR_HOME%\lib\jre\bin\javaw.exe" %ARGS_VM% -m utilserveurs %ARGS_APPLI%

ENDLOCAL
