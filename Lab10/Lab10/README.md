# Laboratorio 10 - Programacion concurrente en Java

Implementacion de la [practica del curso](https://github.com/jorgealbertopineda78-del/java/wiki/Laboratorio-10-%E2%80%94-Programaci%C3%B3n-Concurrente-en-Java).

Desde esta carpeta, con el JDK instalado:

```powershell
javac -encoding UTF-8 *.java
java Main
```

Tambien puedes ejecutar `java Main lab10`. Las opciones `lab7`, `lab8` y
`lab9` conservan las demostraciones anteriores.

- `CombateConcurrente` implementa `Runnable`: tres campos se ejecutan con
  `start()`, cada uno con sus propios personajes y pausas de 500 ms.
- `TablaResultados` protege la escritura y lectura con `synchronized`.
- `MonitorTorneo` extiende `Thread` e informa cada segundo durante tres segundos.
- `Main` espera los combates y el monitor con `join()` antes de mostrar la tabla.
- `ContadorCompartido` compara cinco hilos de 1000 incrementos sin y con
  sincronizacion. Se espera a todos antes de consultar y reiniciar el contador.
- `respuestas.txt` contiene las reflexiones solicitadas.

El orden de los mensajes varia. El contador sin sincronizacion puede incluso
dar 5000; la condicion de carrera no se manifiesta necesariamente en cada
ejecucion. Con sincronizacion debe dar 5000.

Se mantienen los ataques unidireccionales del ejemplo de la guia y los
constructores y formulas de daño de este proyecto. Se cuentan las rondas
completadas, y un combate interrumpido o detenido por una excepcion se registra
sin declarar un ganador falso.

Para entregar, coloca estos fuentes y `respuestas.txt` en la carpeta
`lab10_concurrencia` de tu repositorio, como solicita la guia.
