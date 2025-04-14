# Práctica Nº1
Este repositorio contiene el código de base para el desarrollo de la guía práctica Nº1.

Se espera que las soluciones provistas consistan en código Java (archivo .java) estructurado en carpetas que correspondan a los paquetes utilizados.

Varios de los ejercicios, de esta práctica, son modificaciones de ejemplos tomados del libro: "Programación Orientada a Objetos con Java usando BlueJ" (Barnes & Kölling).


Recordamos algunos comandos útiles:
## Comandos básicos git:
```
  git clone <dirección del repositorio>
  git status 
  git pull
  git add <archivo modificado/agregado>
  git commit - m "mensaje significativo"
  git push
```


## Comandos básicos gradle
Para compilar y correr un proyecto gradle en un sistema unix, desde una consola, posicionados en el directorio que contiene los archivos gradle de configuración:
```
  ./gradlew build (compilar el proyecto)
  ./gradlew run (ejecutar el main)
  ./gradlew run --args="argumento1 argumento2" (ejecutar el main con los argumentos "argumento1" y "argumento2")
  ./gradlew test (para correr los tests)
  ./gradlew clean 

```
Para un sistema windows, desde la consola del sistema usar el archivo:
```
  gradlew.bat
```