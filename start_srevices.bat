@echo off
cd /d "C:\Users\micha\OneDrive\Desktop\Project\CITIZEN-SERVICES-PORTAL\cspserver\cspserver"
start cmd /k mvn spring-boot:run

timeout /t 15 /nobreak >nul

cd /d "C:\Users\micha\OneDrive\Desktop\Project\CITIZEN-SERVICES-PORTAL\citizenservicesportal\citizenservicesportal"
start cmd /k mvn spring-boot:run

timeout /t 15 /nobreak >nul

cd /d "C:\Users\micha\OneDrive\Desktop\Project\CITIZEN-SERVICES-PORTAL\citizen-services-portal\src"
start cmd /k npm start

timeout /t 15 /nobreak >nul
start "" "http://localhost:8761"