# El Despertar del Héroe

## Descripción del proyecto

El Despertar del Héroe es un juego de aventuras desarrollado en Java que se ejecuta por consola.

La historia se desarrolla en el reino de Eldrath, donde el protagonista debe enfrentarse a varios enemigos para recuperar la Llama Eterna y salvar el reino.

Durante la partida, el jugador puede atacar, utilizar pociones para recuperar vida y avanzar por diferentes combates.

Al finalizar, el juego calcula una puntuación que puede guardarse en un ranking.

## Requisitos

Para ejecutar el proyecto es necesario tener instalado:

- Java JDK.
- Un editor de código o un entorno de desarrollo compatible con Java.
- Una terminal para compilar y ejecutar el programa.

## Archivos principales

- `despertarDelHeroe.java`: contiene el menú principal y el desarrollo del juego.
- `Personaje.java`: contiene los atributos comunes de los personajes.
- `Heroe.java`: representa al protagonista.
- `Enemigo.java`: representa a los enemigos.
- `CrearXMLRanking.java`: crea el archivo XML del ranking si no existe.
- `GuardarRanking.java`: guarda las puntuaciones.
- `LeerRanking.java`: permite consultar el ranking.
- `ranking.xml`: almacena los jugadores y sus puntuaciones.
- `ranking.dtd`: define la estructura del XML.
- `ranking.xslt`: transforma el XML en una tabla HTML.
- `ranking.css`: contiene los estilos de la página.
- `ranking.html`: muestra el ranking en formato HTML.

## Cómo ejecutar el juego

Tener instalado Java JDK y Visual Studio Code con las extensiones necesarias para trabajar con Java.

Abrir Visual Studio Code.

Abrir la carpeta del proyecto El Despertar del Héroe.

Abrir el archivo despertarDelHeroe.java, que contiene el método principal del programa.

Pulsar el botón Run (Ejecutar) que aparece en Visual Studio Code.

El juego se iniciará y aparecerá el menú principal en la consola.
## Cómo jugar

Al iniciar el programa aparece un menú con cuatro opciones:

1. **Nueva partida:** comienza una aventura.
2. **Consultar ranking:** muestra las puntuaciones guardadas.
3. **Ayuda:** explica cómo funciona el juego.
4. **Salir:** cierra el programa.

Al comenzar una partida, el jugador introduce el nombre de su héroe.

Durante los combates puede atacar a los enemigos y utilizar pociones para recuperar vida.

El héroe comienza con 100 puntos de vida y dispone de tres pociones. Cada poción recupera 25 puntos de vida, sin superar el máximo de 100.

El objetivo es derrotar a los tres enemigos y completar la historia.

## Sistema de puntuación

El juego calcula la puntuación de la siguiente manera:

- Cada enemigo derrotado suma 100 puntos.
- Si el jugador derrota a los tres enemigos, también se suman los puntos de vida que le quedan al héroe.

Las puntuaciones se guardan en `ranking.xml`.

El ranking muestra los diez mejores resultados, ordenados de mayor a menor puntuación.

## Ranking en HTML

El proyecto también permite mostrar el ranking en una página web.

Para ello se utilizan los siguientes archivos:

- `ranking.xml`, que contiene los datos.
- `ranking.xslt`, que transforma los datos en una tabla HTML.
- `ranking.css`, que aplica los estilos visuales.
- `ranking.html`, que contiene el resultado de la transformación.

Para actualizar la página HTML después de guardar nuevas puntuaciones, es necesario volver a ejecutar la transformación XSLT.

Después se puede abrir `ranking.html` en un navegador para consultar el ranking.

## Pruebas recomendadas

Para comprobar el funcionamiento del proyecto se pueden realizar las siguientes pruebas:

1. Iniciar una nueva partida e introducir el nombre del héroe.
2. Atacar a un enemigo y comprobar que pierde vida.
3. Utilizar una poción y comprobar que recupera vida.
4. Intentar utilizar todas las pociones disponibles.
5. Derrotar a los tres enemigos y comprobar la puntuación final.
6. Consultar el ranking después de guardar una partida.
7. Comprobar que el ranking conserva como máximo diez puntuaciones.
8. Ejecutar la transformación XSLT y abrir el archivo HTML generado.

## Control de versiones

Durante el desarrollo se ha utilizado Git para guardar los cambios realizados en el proyecto.

Se ha trabajado con las ramas `main` y `Out`, realizando commits para registrar las diferentes fases de desarrollo.

También se ha utilizado un archivo `.gitignore` para indicar qué archivos no deben incluirse en el repositorio.
