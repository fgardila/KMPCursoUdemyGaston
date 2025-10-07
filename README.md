# KMPCursoUdemyGasto

Este proyecto es una aplicación desarrollada en Kotlin Multiplatform, siguiendo los pasos del
curso [Kotlin Multiplataforma: Curso Intensivo para Android y iOS](https://www.udemy.com/course/kotlin-multiplataforma-curso-intensivo-para-android-y-ios/)
disponible en Udemy.

## Descripción

La aplicación permite gestionar gastos de manera persistente y está diseñada para funcionar tanto en
Android como en iOS,
utilizando Jetpack Compose Multiplatform para la interfaz de usuario y SQLDelight para el
almacenamiento local.

## Características principales

- Arquitectura multiplataforma (Android/iOS)
- UI con Jetpack Compose Multiplatform
- Navegación multiplataforma
- Gestión de gastos con persistencia local
- Base de datos SQLite multiplataforma con SQLDelight
- Inyección de dependencias con Koin
- Arquitectura MVVM con Repository Pattern
- Observación reactiva de cambios con StateFlow
- Operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar)

## Tecnologías utilizadas

- **Kotlin Multiplatform**: Código compartido entre plataformas
- **Jetpack Compose Multiplatform**: Interfaz de usuario declarativa
- **SQLDelight**: Base de datos SQLite multiplataforma
- **Koin**: Inyección de dependencias
- **Coroutines**: Programación asíncrona
- **StateFlow**: Manejo de estado reactivo
- **Navigation Compose**: Navegación multiplataforma

## Estructura del proyecto

- `composeApp/`: Código compartido multiplataforma
    - `commonMain/`: Código común (UI, lógica de negocio, modelos)
    - `androidMain/`: Implementaciones específicas de Android
    - `iosMain/`: Implementaciones específicas de iOS
- `iosApp/`: Proyecto iOS (SwiftUI wrapper)

## Arquitectura

El proyecto sigue una arquitectura limpia con separación de responsabilidades:

- **Presentation Layer**: ViewModels y UI con Compose
- **Domain Layer**: Repositorios y modelos de negocio
- **Data Layer**: Implementación de repositorios con SQLDelight

## Requisitos

- Android Studio Narwhal o superior
- Xcode (para desarrollo iOS)
- Kotlin Multiplatform
- macOS (para compilación iOS)

## Instalación

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Sincroniza los gradle files.
4. Para Android: Ejecuta en el emulador/dispositivo Android.
5. Para iOS: Abre el proyecto `iosApp.xcodeproj` en Xcode y ejecuta.

## Funcionalidades

- ✅ Agregar nuevos gastos
- ✅ Editar gastos existentes
- ✅ Eliminar gastos
- ✅ Visualizar lista de gastos
- ✅ Calcular total de gastos
- ✅ Categorización de gastos
- ✅ Persistencia local en ambas plataformas
- ✅ Actualización automática de la UI

## Créditos

Este proyecto sigue el contenido del curso de Udemy impartido por Gastón Saillén, con mejoras
adicionales en arquitectura y persistencia de datos.

---

¡Explora el código y aprende sobre Kotlin Multiplatform con SQLDelight!
