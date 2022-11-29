@echo off
md app
jar --create --file=app/CustomerManagement.jar --main-class=smtdatabasemanagement.CustomerManagement -m Manifest.txt -C classes .
md app\lib
copy lib\mysql-connector-java.jar app\lib 
Pause