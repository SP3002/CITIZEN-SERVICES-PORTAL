@echo off
cd /d "C:\Users\micha\OneDrive\Desktop\Project\CITIZEN-SERVICES-PORTAL\cspserver\cspserver"
start cmd /k mvn spring-boot:run

timeout /t 5 /nobreak >nul

cd /d "C:\Users\micha\OneDrive\Desktop\Project\CITIZEN-SERVICES-PORTAL\citizenservicesportal\citizenservicesportal"
start cmd /k mvn spring-boot:run

timeout /t 5 /nobreak >nul

cd /d "C:\path\to\react-app"
start cmd /k npm start
