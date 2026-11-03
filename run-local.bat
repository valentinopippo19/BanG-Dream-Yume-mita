
@echo off
setlocal EnableExtensions
cd /d "%~dp0"

title WaiVIdol Universe - Installer

echo ==========================================
echo       WaiVIdol Universe - Local
echo ==========================================
echo.

echo [1/5] Comprobando Java...

where java >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java no esta instalado.
    echo Instala Java 21 o superior.
    pause
    exit /b 1
)

java -version
echo.

set "TOOLS=%~dp0.tools"
set "MAVEN_VERSION=3.9.11"
set "MAVEN_DIR=%TOOLS%\apache-maven-%MAVEN_VERSION%"
set "MAVEN_ZIP=%TOOLS%\apache-maven-%MAVEN_VERSION%-bin.zip"
set "MVN_CMD=%MAVEN_DIR%\bin\mvn.cmd"

echo [2/5] Comprobando Maven...

where mvn >nul 2>&1
if not errorlevel 1 (
    set "MVN_CMD=mvn"
    goto BUILD
)

if exist "%MVN_CMD%" goto BUILD

if not exist "%TOOLS%" mkdir "%TOOLS%"

echo Descargando Apache Maven %MAVEN_VERSION%...

powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip' -OutFile '%MAVEN_ZIP%'"

if errorlevel 1 (
    echo ERROR: No se pudo descargar Maven.
    pause
    exit /b 1
)

echo Extrayendo Maven...

powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Expand-Archive -LiteralPath '%MAVEN_ZIP%' -DestinationPath '%TOOLS%' -Force"

if errorlevel 1 (
    echo ERROR: No se pudo extraer Maven.
    pause
    exit /b 1
)

if not exist "%MVN_CMD%" (
    echo ERROR: No se encontro mvn.cmd.
    pause
    exit /b 1
)

:BUILD

echo.
echo [3/5] Comprobando proyecto...

if not exist "pom.xml" (
    echo ERROR: No se encontro pom.xml.
    echo Coloca este instalador en la carpeta principal del proyecto.
    pause
    exit /b 1
)

echo [4/5] Compilando WaiVIdol Universe...
echo.

call "%MVN_CMD%" clean package

if errorlevel 1 (
    echo.
    echo ERROR: Maven no pudo compilar el proyecto.
    echo Revisa los errores que aparecen arriba.
    pause
    exit /b 1
)

echo.
echo [5/5] Buscando archivo JAR...

if not exist "target\waividol-universe-1.0.0.jar" (
    echo ERROR: No se encontro el JAR esperado.
    echo Archivos disponibles:
    dir target\*.jar
    pause
    exit /b 1
)

echo.
echo ==========================================
echo       COMPILACION CORRECTA
echo ==========================================
echo.
echo Iniciando WaiVIdol Universe...
echo.

java -jar "target\waividol-universe-1.0.0.jar"

echo.
echo WaiVIdol Universe se ha cerrado.
pause