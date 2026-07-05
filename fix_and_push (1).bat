@echo off
chcp 65001 >nul
cd /d "%~dp0"

echo === Tekushaya papka: %cd% ===
echo.

if exist "NotifReader" (
    echo Naiden ostatok papki NotifReader vnutri - perenoshu soderzhimoe i udalyayu ee...
    robocopy "NotifReader" "." /E /MOVE >nul
    echo Gotovo.
) else (
    echo Lishnaya papka NotifReader ne naidena - vse uzhe na meste.
)

echo.
echo === Soderzhimoe papki seichas: ===
dir /b
echo.

echo === Otpravka izmeneniy na GitHub ===
git add -A
git commit -m "fix folder structure"
git push

echo.
echo === GOTOVO ===
pause
