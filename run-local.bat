
@echo off
setlocal
cd /d "%~dp0"

title WaiVIdol Universe - Diagnostico

echo ==========================================
echo       WaiVIdol Universe - Local
echo ==========================================
echo.

echo [1] Comprobando Java...
java -version

if errorlevel 1 (
    echo ERROR: Java no funciona.
    pause
    exit /b 1
)

echo.
echo [2] Comprobando pom.xml...

if not exist "pom.xml" (
    echo ERROR: No existe pom.xml en esta carpeta.
    pause
    exit /b 1
)

echo.
echo [3] Comprobando Maven...

set "MVN_CMD=%~dp0.tools\apache-maven-3.9.11\bin\mvn.cmd"

if not exist "%MVN_CMD%" (
    where mvn >nul 2>&1
    if errorlevel 1 (
        echo ERROR: Maven no esta instalado.
        echo.
        echo No se puede continuar.
        pause
        exit /b 1
    )
    set "MVN_CMD=mvn"
)

echo Maven encontrado.
echo.

echo [4] Compilando proyecto...
call "%MVN_CMD%" clean package

if errorlevel 1 (
    echo.
    echo ERROR: Maven fallo al compilar.
    pause
    exit /b 1
)

echo.
echo [5] Iniciando aplicacion...

if not exist "target\waividol-universe-1.0.0.jar" (
    echo ERROR: No se encontro el JAR.
    pause
    exit /b 1
)

java -jar "target\waividol-universe-1.0.0.jar"

echo.
echo Aplicacion cerrada.
pause
