# 🏥 Sistema de Registro de Consultas Médicas

Este proyecto es una prueba técnica que consiste en desarrollar un sistema para gestionar consultas médicas, permitiendo registrar médicos, pacientes y citas, así como consultar historiales clínicos.

## ✅ Funcionalidades

* **Registro de médicos:** nombre y especialidad.
* **Registro de pacientes:** nombre, edad y antecedentes médicos.
* **Agendamiento de citas médicas:** fecha, hora, médico y paciente.
* **Historial de citas por paciente:** con resumen de diagnóstico y tratamiento recomendado.
* **Consulta de historial por médico y por paciente.**

## 🛠️ Tecnologías utilizadas

* **Backend:**

  * Java 8
  * Spring Boot
  * MyBatis (ORM)
  * Oracle Database

* **Frontend:**

  * Angular
  * Bootstrap (framework de diseño de componentes)

## 🧱 Arquitectura

El sistema está dividido en una arquitectura de tipo **cliente-servidor**, con las siguientes capas:

* **Presentación (Frontend):** Angular con Bootstrap para una interfaz limpia y responsiva.
* **Negocio (Backend):** Spring Boot con lógica RESTful y MyBatis para la persistencia.
* **Persistencia (Base de Datos):** Oracle DB.

## 🚀 Instrucciones para ejecutar el proyecto

### Backend

1. Configurar una base de datos Oracle.
2. Actualizar el archivo `application.properties` con las credenciales y URL de conexión.
3. Ejecutar el proyecto con Maven o desde tu IDE preferido.

### Frontend

1. Instalar dependencias:

   ```bash
   npm install
   ```
2. Ejecutar la aplicación:

   ```bash
   ng serve
   ```
3. Acceder desde `http://localhost:4200`
