@echo off
setlocal EnableExtensions
cd /d "%~dp0"

echo ==========================================
echo       WaiVIdol Universe - Inicio rapido
echo ==========================================
echo.

where java >nul 2>&1
if errorlevel 1 (
  echo ERROR: Java no esta instalado o no esta en PATH. Se requiere Java 21.
  pause
  exit /b 1
)

set "APP_JAR=%~dp0target\waividol-universe-1.0.0.jar"
if not exist "%APP_JAR%" (
  echo No se encontro la aplicacion compilada.
  echo Ejecuta primero run-local.bat para compilarla una sola vez.
  echo Despues, para los siguientes inicios, usa run-app.bat.
  pause
  exit /b 1
)

echo Iniciando WaiVIdol Universe sin recompilar...
echo El navegador se abrira automaticamente.
echo Para cerrar la aplicacion, cierra esta ventana.
echo.
java -jar "%APP_JAR%"
echo.
echo WaiVIdol Universe se ha cerrado.
pause
