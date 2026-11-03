
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
    pause
    exit /b 1
)

for /f tokens^=3 delims^=^" %%V in ('java -version 2^>^&1 ^| findstr /i "version"') do set "JAVA_VERSION=%%V"

echo Version detectada: %JAVA_VERSION%

if not defined JAVA_VERSION (
    echo ERROR: No se pudo detectar la version de Java.
    pause
    exit /b 1
)

for /f "tokens=1 delims=." %%V in ("%JAVA_VERSION%") do set "JAVA_MAJOR=%%V"

if %JAVA_MAJOR% LSS 21 (
    echo ERROR: Se necesita Java 21 o superior.
    pause
    exit /b 1
)

echo Java correcto.
echo.

set "TOOLS=%~dp0.tools"
set "MAVEN_VERSION=3.9.11"
set "MAVEN_DIR=%TOOLS%\apache-maven-%MAVEN_VERSION%"
set "MVN_CMD=%MAVEN_DIR%\bin\mvn.cmd"
set "MAVEN_ZIP=%TOOLS%\maven.zip"

echo [2/5] Comprobando Maven...

if not exist "%MVN_CMD%" (
    if not exist "%TOOLS%" mkdir "%TOOLS%"

    echo Descargando Maven...

    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Invoke-WebRequest 'https://archive.apache.org/dist/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip' -OutFile '%MAVEN_ZIP%'"

    if errorlevel 1 (
        echo ERROR: Fallo la descarga de Maven.
        pause
        exit /b 1
    )

    echo Extrayendo Maven...

    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Expand-Archive -LiteralPath '%MAVEN_ZIP%' -DestinationPath '%TOOLS%' -Force"

    if errorlevel 1 (
        echo ERROR: Fallo la extraccion de Maven.
        pause
        exit /b 1
    )
)

if not exist "%MVN_CMD%" (
    echo ERROR: No se encontro Maven.
    pause
    exit /b 1
)

echo Maven correcto.
echo.

echo [3/5] Comprobando proyecto...

if not exist "%~dp0pom.xml" (
    echo ERROR: No se encontro pom.xml.
    pause
    exit /b 1
)

echo Proyecto encontrado.
echo.

echo [4/5] Compilando proyecto...
echo.

call "%MVN_CMD%" -e clean package > "%~dp0build-error.log" 2>&1

if errorlevel 1 (
    echo ERROR: La compilacion fallo.
    echo.
    echo Ultimas lineas del registro:
    powershell -NoProfile -Command "Get-Content '%~dp0build-error.log' -Tail 40"
    echo.
    echo Registro completo: build-error.log
    pause
    exit /b 1
)

echo Compilacion correcta.
echo.

echo [5/5] Buscando JAR...

if not exist "target\waividol-universe-1.0.0.jar" (
    echo ERROR: No se encontro el JAR esperado.
    echo JAR disponibles:
    dir /b target\*.jar 2>nul
    pause
    exit /b 1
)

echo.
echo ==========================================
echo       INSTALACION CORRECTA
echo ==========================================
echo.

java -jar "target\waividol-universe-1.0.0.jar"

echo.
echo WaiVIdol Universe se ha cerrado.
pause