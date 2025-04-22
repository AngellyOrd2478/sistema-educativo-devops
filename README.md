# 🎓 Sistema Educativo Distribuido - Evaluación Final DevOps

Este proyecto corresponde a la **evaluación final del curso DevOps**, donde se integran todos los temas vistos: configuración de entornos, pruebas unitarias e integración, microservicios, comunicación entre servicios, seguridad con JWT, monitoreo, despliegue y automatización CI/CD.

---

## 📌 Objetivo General

Construir un sistema educativo distribuido basado en microservicios que sea:

- Funcional y desacoplado.
- Seguro (con autenticación JWT).
- Automatizado (con pruebas y GitHub Actions).
- Desplegable localmente con Docker Compose.
- Monitorizable (con Spring Boot Actuator).

---

## 🧩 Microservicios del Sistema

El sistema está compuesto por los siguientes microservicios:

| Microservicio         | Descripción                                            | Puerto |
|------------------------|--------------------------------------------------------|--------|
| `usuarios-servicio`    | Registro, login, autenticación JWT, gestión de usuarios| 8001   |
| `asignaturas-servicio` | Gestión de asignaturas disponibles                     | 8002   |
| `matriculas-servicio`  | Registro de matrículas, consulta de asignaturas y usuarios | 8003 |
| `eureka-server`        | Servicio de descubrimiento (naming server)            | 8761   |
| `config-server`        | Servidor de configuración centralizada                 | 8888   |
| `MongoDB`              | Base de datos independiente para cada microservicio    | 27017+ |

---

## 🧱 Arquitectura General

La aplicación está basada en la arquitectura de microservicios, donde cada componente se comunica a través de **Feign Clients** y se registra en **Eureka**. Las configuraciones están centralizadas en **Config Server**, y los datos se almacenan en bases de datos **MongoDB** independientes.

---

## 🔐 Seguridad con JWT

En `usuarios-servicio` se implementa seguridad basada en **JSON Web Tokens (JWT)** con:

- Registro de usuario (`POST /auth/register`)
- Inicio de sesión (`POST /auth/login`)
- Generación de token válido
- Protección de rutas según rol (ej. ADMIN o USER)
- Verificación de token con filtros de seguridad Spring Security

---

## 🔄 Comunicación entre microservicios

- `matriculas-servicio` usa Feign para consultar a:
  - `usuarios-servicio` (por datos del estudiante)
  - `asignaturas-servicio` (por la asignatura matriculada)

Esto permite una **operación compuesta** como registrar una matrícula y mostrar información cruzada.

---

## 🧪 Pruebas Automatizadas

Cada microservicio tiene pruebas que garantizan su correcto funcionamiento:

- ✅ **Pruebas unitarias con Mockito** (mínimo 2 por microservicio)
- ✅ **Pruebas de integración** con WebTestClient o TestRestTemplate

Las pruebas se ejecutan automáticamente con GitHub Actions al hacer `push`.

---

## ⚙️ Automatización CI/CD

El proyecto está integrado con **GitHub Actions**:

- Archivo `.github/workflows/test.yml`
- Ejecuta `mvn test` al hacer push
- Muestra el estado de compilación y pruebas

```yaml
name: Java CI

on: [push]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v2
    - name: Set up JDK 17
      uses: actions/setup-java@v2
      with:
        java-version: '17'
    - name: Build with Maven
      run: mvn clean test
```
---
## Despliegue con Docker y Docker Compose 

Cada microservicio tiene su propio Dockerfile. El archivo docker-compose.yml levanta todos los servicios:

✅ Servicios que se levantan:
3 microservicios (usuarios, asignaturas, matriculas)

1. MongoDB (x3)
2. Eureka Server
3. Config Server

Comandos 
- Construir
docker-compose build
-Ejecutar
docker-compose up
----

## Spring Boot Actuator

Cada microservicio expone endpoints de monitoreo:

-/actuator/health
-/actuator/info
-/actuator/metrics

Puedes consultarlos con Postman o curl para verificar el estado de cada servicio.

## Estructura del Repositorio 

📦 sistema-educativo-devops
├── usuarios-servicio
│   ├── src/main/java/... (controladores, modelos, seguridad, etc.)
│   └── Dockerfile
├── asignaturas-servicio
├── matriculas-servicio
├── eureka-server
├── config-server
├── docker-compose.yml
├── .github/workflows/test.yml
└── README.md


## Repositorio de configuración
Las configuraciones de los microservicios están centralizadas y versionadas en un repositorio aparte, utilizado por config-server.

Puedes tener un repo como: sistema-configuracion

Contiene archivos:

>usuarios-servicio.yml
>asignaturas-servicio.yml
>matriculas-servicio.yml

## Postman
Se realizaron pruebas de endpoints en Postman
Se verificó la autenticación con JWT
Se probaron operaciones entre microservicios

## Requisitos
Java 17
Maven
Docker y Docker Compose
Git

🙋 Autor
👤 Nombre: Angelly Ordoñez
🎓 Curso: Ingeniería de Sistemas - Lenguaje de Programacion Avanzado II - Evaluación DevOps
