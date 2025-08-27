# InventPro

Sistema de gestión de inventarios desarrollado en Java con conexión a base de datos PostgreSQL.

## 📋 Descripción

Inventpro es una aplicación Java que proporciona funcionalidades CRUD (Create, Read, Update, Delete) para la gestión de usuarios en un sistema de inventarios. La aplicación utiliza una arquitectura de capas con DAO (Data Access Object) para el acceso a datos.

## 🏗️ Arquitectura del Proyecto

```
inventpro-server/
├── src/
│   └── com/
│       └── inventpro/
│           ├── main/
│           │   └── Main.java                 # Punto de entrada de la aplicación
│           ├── model/
│           │   └── User.java                 # Modelo de datos para usuarios
│           ├── dao/
│           │   └── UserDAO.java              # Capa de acceso a datos
│           └── connection/
│               └── InnerConnectionDB.java    # Gestión de conexiones DB
├── lib/
│   └── postgresql-42.7.7.jar                 # Driver de PostgreSQL
├── bin/                                      # Archivos compilados (generado)
└── README.md
```

## 🚀 Requisitos Previos

- **Java**: OpenJDK 24
- **PostgreSQL**

## 📦 Instalación

1. **Clonar el repositorio**

   ```bash
   git clone git@github.com:niccommit/proyecto-sena.git
   cd inventpro-server
   ```

2. **Configurar la base de datos**
   - Asegúrate de que PostgreSQL esté ejecutándose
   - Crea una base de datos llamada `inventpro-db`
   - Crea un usuario `inventpro` con contraseña `inventpro`
   - O modifica las credenciales en `InnerConnectionDB.java`

## 🧪 Funcionalidades

La aplicación incluye las siguientes operaciones de prueba:

1. **Insertar Usuario**: Crea un nuevo usuario en la base de datos
2. **Listar Usuarios**: Muestra todos los usuarios registrados
3. **Actualizar Usuario**: Modifica los datos de un usuario existente
4. **Eliminar Usuario**: Elimina un usuario de la base de datos

## 📊 Estructura de Datos

### Modelo User:

- `id_usuario`: Identificador único del usuario
- `nombre_completo`: Nombre completo del usuario
- `email`: Correo electrónico (único)
- `password_hash`: Hash de la contraseña
- `rol`: Rol del usuario (Admin, Director, etc.)
- `id_organizacion`: ID de la organización (opcional)

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **PostgreSQL**: Sistema de gestión de base de datos
- **Git**: Control de versiones

## 📝 Notas de Desarrollo

- El proyecto utiliza una arquitectura de capas simple
- La gestión de conexiones está centralizada en `InnerConnectionDB`
- Los DAOs implementan el patrón Data Access Object
- El código incluye manejo básico de excepciones

## 👨‍💻 Autor

**Nicolás Pantoja** - [GitHub](https://github.com/niccommit)

## 📞 Contacto

- Email: nicolas_pantoja@soy.sena.edu.co
- Proyecto SENA: [Inventpro](https://github.com/niccommit/proyecto-sena)
