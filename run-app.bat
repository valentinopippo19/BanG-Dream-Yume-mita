

@echo off
setlocal EnableExtensions
cd /d "%~dp0"

title WaiVIdol Universe - Inicio rapido

echo ==========================================
echo       WaiVIdol Universe - Inicio rapido
echo ==========================================
echo.

echo Comprobando Java...

where java >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java no esta instalado o no esta en PATH.
    echo Se requiere Java 21 o superior.
    pause
    exit /b 1
)

java -version
echo.

set "APP_JAR=%~dp0target\waividol-universe-1.0.0.jar"

if not exist "%APP_JAR%" (
    echo ERROR: No se encontro la aplicacion compilada.
    echo.
    echo Ejecuta primero INSTALL.bat o run-local.bat.
    pause
    exit /b 1
)

echo Iniciando WaiVIdol Universe sin recompilar...
echo.
echo El navegador se abrira automaticamente.
echo Para cerrar la aplicacion, cierra esta ventana.
echo.

java -jar "%APP_JAR%"

echo.
echo WaiVIdol Universe se ha cerrado.
pause
