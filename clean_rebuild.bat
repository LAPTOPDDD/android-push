@echo off
chcp 65001 >nul
cd /d "%~dp0"

echo === Tekushaya papka: %cd% ===
echo.

if exist "NotifReader" (
    echo Naiden ostatok papki NotifReader - perenoshu ostavshiesya faily...
    robocopy "NotifReader" "." /E /MOVE >nul
    rmdir /s /q "NotifReader" 2>nul
    echo Gotovo.
)

echo.
echo === Soderzhimoe papki seichas (dolzhno byt bez podpapki NotifReader): ===
dir /b
echo.

echo === Ochistka staroi git-istorii ===
if exist ".git" (
    rmdir /s /q ".git"
)

echo === Sozdanie chistogo git-repozitoriya ===
git init
git add -A
git commit -m "clean project structure"
git branch -M main
git remote add origin https://github.com/LAPTOPDDD/android-push.git

echo.
echo === Otpravka na GitHub (perezapis remote repo) ===
git push -u origin main --force

echo.
echo === GOTOVO ===
echo Proverte stranicu https://github.com/LAPTOPDDD/android-push
pause
