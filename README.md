## Escuela Colombiana de Ingeniería

## Arquitecturas de Software
# Blueprints Middleware

Este proyecto implementa un sistema de manejo de **planos (blueprints)** en Java, usando **Spring** y pruebas con **JUnit 5**.  
El sistema permite almacenar, consultar y aplicar filtros a los planos registrados.

---

## 📂 Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes:
- `edu.eci.arsw.blueprints`: Paquete raíz que contiene la clase principal `App`.
- `edu.eci.arsw.blueprints.model`: Contiene las clases del modelo de datos, como `Point` y `Blueprint`.
- `edu.eci.arsw.blueprints.persistence`: Contiene las interfaces y clases relacionadas con la persistencia de datos, como `BlueprintsPersistence` e `InMemoryBlueprintPersistence`.
- `edu.eci.arsw.blueprints.services`: Contiene las interfaces y clases de servicios, como `BlueprintServices` y su implementación `BlueprintServicesImpl`.
- `edu.eci.arsw.blueprints.filters`: Contiene las interfaces y clases de filtros, como `BlueprintFilter`, `RedundancyFilter` y `SubsamplingFilter`.
- `edu.eci.arsw.blueprints.test`: Contiene las clases de prueba para las diferentes funcionalidades del sistema.
- `resources`: Contiene archivos de configuración y otros recursos necesarios para la aplicación.
- `img`: Contiene imágenes utilizadas en la documentación.
- `pom.xml`: Archivo de configuración de Maven que gestiona las dependencias del proyecto.
- `README.md`: Este archivo de documentación del proyecto.
---

---

## ⚙️ Instalación y compilación

1. Clona este repositorio o copia los archivos fuente.
2. Compila el proyecto con Maven:

```bash
mvn clean install
```
3. Ejecuta las pruebas unitarias con Maven:

```bash
mvn test
```
4. Ejecuta la aplicación principal:

```bash
mvn exec:java -Dexec.mainClass="edu.eci.arsw.blueprints.App"
```




# Componentes y conectores - Parte I.

El ejercicio se debe traer terminado para el siguiente laboratorio (Parte II).

#### Middleware- gestión de planos.


## Antes de hacer este ejercicio, realice [el ejercicio introductorio al manejo de Spring y la configuración basada en anotaciones](https://github.com/ARSW-ECI/Spring_LightweightCont_Annotation-DI_Example).

En este ejercicio se va a construír un modelo de clases para la capa lógica de una aplicación que permita gestionar planos arquitectónicos de una prestigiosa compañia de diseño. 

![](img/ClassDiagram1.png)

1. Configure la aplicación para que funcione bajo un esquema de inyección de dependencias, tal como se muestra en el diagrama anterior.


	Lo anterior requiere:

	* Agregar las dependencias de Spring.
	* Agregar la configuración de Spring.
	* Configurar la aplicación -mediante anotaciones- para que el esquema de persistencia sea inyectado al momento de ser creado el bean 'BlueprintServices'.


2. Complete los operaciones getBluePrint() y getBlueprintsByAuthor(). Implemente todo lo requerido de las capas inferiores (por ahora, el esquema de persistencia disponible 'InMemoryBlueprintPersistence') agregando las pruebas correspondientes en 'InMemoryPersistenceTest'.

3. Haga un programa en el que cree (mediante Spring) una instancia de BlueprintServices, y rectifique la funcionalidad del mismo: registrar planos, consultar planos, registrar planos específicos, etc.

4. Se quiere que las operaciones de consulta de planos realicen un proceso de filtrado, antes de retornar los planos consultados. Dichos filtros lo que buscan es reducir el tamaño de los planos, removiendo datos redundantes o simplemente submuestrando, antes de retornarlos. Ajuste la aplicación (agregando las abstracciones e implementaciones que considere) para que a la clase BlueprintServices se le inyecte uno de dos posibles 'filtros' (o eventuales futuros filtros). No se contempla el uso de más de uno a la vez:
	* (A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.
	* (B) Filtrado de submuestreo: suprime 1 de cada 2 puntos del plano, de manera intercalada.

5. Agrege las pruebas correspondientes a cada uno de estos filtros, y pruebe su funcionamiento en el programa de prueba, comprobando que sólo cambiando la posición de las anotaciones -sin cambiar nada más-, el programa retorne los planos filtrados de la manera (A) o de la manera (B). 

Autor: David Santiago Espinosa