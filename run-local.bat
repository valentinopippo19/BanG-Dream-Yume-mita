@echo off
setlocal EnableExtensions
cd /d "%~dp0"

echo ==========================================
echo       WaiVIdol Universe - Local
echo ==========================================
echo.

where java >nul 2>&1
if errorlevel 1 (
  echo ERROR: Java no esta instalado o no esta en PATH. Se requiere Java 21+.
  pause
  exit /b 1
)
java -version
echo.

set "TOOLS=%~dp0.tools"
set "MAVEN_VERSION=3.10.0"
set "MAVEN_DIR=%TOOLS%\apache-maven-%MAVEN_VERSION%"
set "MAVEN_ZIP=%TOOLS%\apache-maven-%MAVEN_VERSION%-bin.zip"
set "MVN_CMD=%MAVEN_DIR%\bin\mvn.cmd"
where mvn >nul 2>&1
if not errorlevel 1 (set "MVN_CMD=mvn" & goto BUILD)
if exist "%MVN_CMD%" goto BUILD
if not exist "%TOOLS%" mkdir "%TOOLS%"
echo Descargando Apache Maven %MAVEN_VERSION%...
powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.10.0/binaries/apache-maven-3.10.0-bin.zip' -OutFile '%MAVEN_ZIP%'"
if errorlevel 1 (echo ERROR: No se pudo descargar Maven.& pause & exit /b 1)
powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Expand-Archive -LiteralPath '%MAVEN_ZIP%' -DestinationPath '%TOOLS%' -Force"
if errorlevel 1 (echo ERROR: No se pudo extraer Maven.& pause & exit /b 1)
if not exist "%MVN_CMD%" (echo ERROR: No se encontro mvn.cmd.& pause & exit /b 1)

:BUILD
echo.
echo Compilando WaiVIdol Universe...
echo.
call "%MVN_CMD%" clean package
if errorlevel 1 (echo ERROR: La compilacion fallo.& pause & exit /b 1)
if not exist "target\waividol-universe-1.0.0.jar" (echo ERROR: No se encontro el JAR ejecutable.& pause & exit /b 1)
echo.
echo Compilacion correcta. Iniciando servidor...
echo El navegador se abrira automaticamente.
echo Para cerrar, cierre esta ventana.
echo.
java -jar "target\waividol-universe-1.0.0.jar"
echo.
echo WaiVIdol Universe se ha cerrado.
pause
