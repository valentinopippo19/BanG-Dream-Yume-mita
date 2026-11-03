# WaiVIdol Universe
## Proyecto académico fan-made basado en la serie *BanG Dream! YUME∞MITA*

**Título del trabajo:** Diseño y desarrollo de una aplicación web interactiva de entretenimiento, participación de fans y economía virtual simulada: *WaiVIdol Universe*  
**Versión del prototipo:** 1.4  
**Tipo de proyecto:** Prototipo académico / aplicación web local  
**Plataforma:** Navegador web de escritorio y móvil  
**Estado de WVID:** Saldo virtual de demostración; no es una criptomoneda real.

<img width="1200" height="630" alt="BanG_Dream3Fmita_KV" src="https://github.com/user-attachments/assets/cf816c95-ebc0-4f37-9db8-38e5ba36d348" />

---

# Índice

1. [Presentación del proyecto](#1-presentación-del-proyecto)
2. [Serie y universo de referencia](#2-serie-y-universo-de-referencia)
3. [Idea central y fundamentación](#3-idea-central-y-fundamentación)
4. [Objetivos](#4-objetivos)
5. [Público destinatario y alcance](#5-público-destinatario-y-alcance)
6. [Concepto de WaiVIdol y significado de WVID](#6-concepto-de-waividol-y-significado-de-wvid)
7. [Descripción de la aplicación y sus secciones](#7-descripción-de-la-aplicación-y-sus-secciones)
8. [Personajes y grupos representados](#8-personajes-y-grupos-representados)
9. [Imágenes, galerías y videos](#9-imágenes-galerías-y-videos)
10. [Sistema de preguntas y respuestas — Quiz](#10-sistema-de-preguntas-y-respuestas--quiz)
11. [Billetera, tienda y economía virtual simulada](#11-billetera-tienda-y-economía-virtual-simulada)
12. [Diseño de navegación e identidad visual](#12-diseño-de-navegación-e-identidad-visual)
13. [Construcción técnica del prototipo](#13-construcción-técnica-del-prototipo)
14. [Estructura de carpetas y archivos](#14-estructura-de-carpetas-y-archivos)
15. [Instalación y ejecución](#15-instalación-y-ejecución)
16. [Flujo de uso de principio a fin](#16-flujo-de-uso-de-principio-a-fin)
17. [Privacidad, almacenamiento y funcionamiento local](#17-privacidad-almacenamiento-y-funcionamiento-local)
18. [Pruebas y criterios de evaluación](#18-pruebas-y-criterios-de-evaluación)
19. [Etapas de desarrollo y evolución del trabajo](#19-etapas-de-desarrollo-y-evolución-del-trabajo)
20. [Limitaciones y posibles mejoras futuras](#20-limitaciones-y-posibles-mejoras-futuras)
21. [Derechos de autor y aclaración de afiliación](#21-derechos-de-autor-y-aclaración-de-afiliación)
22. [Objetivo final y conclusión](#22-objetivo-final-y-conclusión)
23. [Fuentes de referencia](#23-fuentes-de-referencia)

---

# 1. Presentación del proyecto

**WaiVIdol Universe** es una propuesta de aplicación web interactiva concebida como trabajo académico. Toma como universo temático de referencia la serie y proyecto multimedia *BanG Dream! YUME∞MITA*, y plantea una experiencia digital para que los fans puedan recorrer personajes, conocer grupos, reproducir material audiovisual, participar en desafíos y utilizar un sistema interno de puntos virtuales.

El nombre **WaiVIdol** reúne tres ideas que definen la propuesta:

- **Waifu:** la relación de afinidad que una persona puede desarrollar con personajes ficticios.
- **Virtual Idol:** la figura de la idol o artista que se presenta mediante una identidad virtual.
- **VTuber:** el formato de creador o intérprete que utiliza un avatar digital como representación pública.

La palabra **Universe** expresa que la aplicación busca reunir distintas áreas de una misma experiencia: personajes, grupos, material multimedia, desafíos, recompensas y una tienda de contenido simulado.

El resultado es un prototipo funcional que se ejecuta localmente en una computadora mediante un servidor Java 21 y un navegador web. No pretende ser una plataforma comercial ni un servicio financiero. Su finalidad es demostrar cómo se pueden integrar diseño de interfaz, organización de contenidos, recursos multimedia, interacción con el usuario y persistencia de datos en una aplicación web.

# 2. Serie y universo de referencia

La obra de referencia es **BanG Dream! YUME∞MITA**. El proyecto académico utiliza sus personajes, grupos y elementos públicos como inspiración temática y como contenido de consulta para construir la experiencia de navegación.

Dentro de la aplicación se destacan:

- **Mugendai Mewtype**, grupo virtual integrado por Arale Nakamachi, Nonoka Miyanaga, Ritsu Minetsuki, Miyako Fuji y Yuno Sengoku.
- **Fairy Bouquet**, representado por Viola, Bell y Popo.
- **Manager**, incluido como personaje de apoyo dentro del universo de la aplicación.

La aplicación organiza estos contenidos para que el usuario pueda pasar de la vista general de un grupo a las fichas individuales de sus integrantes. El propósito no es reemplazar los canales oficiales de la franquicia, sino ofrecer una interfaz demostrativa y un recorrido de fan interactivo.

https://github.com/user-attachments/assets/f3ecef09-be73-4959-a75b-ad50aa7ebab3

# 3. Idea central y fundamentación

La idea principal consiste en trasladar la experiencia de seguimiento de un universo de idols virtuales a una pequeña plataforma web. En lugar de presentar únicamente una página informativa, WaiVIdol Universe propone que el usuario participe activamente.

La experiencia se apoya en cinco componentes:

1. **Exploración:** consultar personajes, grupos y sus materiales.
2. **Contenido audiovisual:** visualizar el opening, el ending y los videos individuales.
3. **Participación:** responder preguntas relacionadas con los personajes y grupos.
4. **Recompensa:** obtener puntos WVID virtuales por las respuestas correctas.
5. **Progresión simulada:** utilizar el saldo para probar compras y desbloqueos internos.

Esta combinación permite estudiar cómo se relacionan la presentación visual, la navegación, la gamificación y un sistema sencillo de recompensas dentro de una misma aplicación.

# 4. Objetivos

## 4.1 Objetivo general

Diseñar y desarrollar un prototipo de aplicación web interactiva, adaptable a PC y dispositivos móviles, que reúna información de personajes y grupos de *BanG Dream! YUME∞MITA*, contenido audiovisual local y dinámicas de participación mediante un sistema de puntos virtuales sin valor monetario.

## 4.2 Objetivos específicos

- Diseñar una identidad visual propia para WaiVIdol Universe.
- Crear una pantalla de bienvenida y una navegación clara entre secciones.
- Organizar los personajes en fichas individuales y por grupos.
- Asociar imágenes y videos locales a los personajes correspondientes.
- Incorporar un opening de entrada y un ending de salida.
- Desarrollar un cuestionario interactivo con preguntas temáticas.
- Vincular las preguntas con imágenes o videos de referencia.
- Implementar un saldo WVID de demostración y un historial de movimientos.
- Simular una tienda y desbloqueos sin efectuar pagos.
- Guardar cuentas, saldo, historial, intentos y desbloqueos en una base SQLite local.
- Evitar dependencias de blockchain, servicios financieros y servidores externos.

# 5. Público destinatario y alcance

El público destinatario principal son los fans de la temática de idols virtuales, VTubers y personajes de *BanG Dream! YUME∞MITA*, además de docentes y estudiantes interesados en observar un prototipo de aplicación web con componentes multimedia e interacción.

El alcance del trabajo es académico y demostrativo. La versión entregada permite recorrer la interfaz, reproducir los recursos incorporados, responder preguntas y experimentar con el saldo simulado.

No forma parte del alcance de esta versión:

- Crear una criptomoneda real.
- Registrar operaciones en una blockchain.
- Conectar billeteras digitales o cuentas bancarias.
- Cobrar dinero, procesar tarjetas o realizar pagos.
- Crear cuentas locales gestionadas por el backend Java, sin servicios remotos.
- Sincronizar datos entre distintas computadoras.
- Ofrecer un mercado real de productos o activos digitales.

# 6. Concepto de WaiVIdol y significado de WVID

**WaiVIdol** es el concepto de comunidad y experiencia digital que da identidad al proyecto. El usuario puede recorrer el universo de personajes, participar en desafíos y utilizar un saldo interno para probar las funciones de la aplicación.

**WVID** es la unidad de puntos virtuales que utiliza el prototipo. Aunque el nombre y la estética puedan recordar a una moneda digital, WVID no es una criptomoneda y no tiene cotización, respaldo financiero, valor de cambio ni existencia fuera de la aplicación.

En la demostración:

- El usuario comienza con un saldo de prueba.
- Puede recibir puntos por contestar correctamente preguntas habilitadas.
- Cada cuenta comienza con **10 WVID**.
- Puede ganar **1 WVID por cada respuesta correcta** del quiz.
- Las respuestas incorrectas y los tiempos agotados no otorgan puntos.
- Puede gastar puntos para desbloquear imágenes adicionales, historias extendidas y videos especiales.
- Puede consultar el historial de movimientos.
- Los cambios quedan guardados en SQLite y asociados a la cuenta local.

# 7. Descripción de la aplicación y sus secciones

La interfaz está organizada en pantallas accesibles desde la navegación principal. Cada sección cumple una función dentro del recorrido del usuario.

## 7.1 Bienvenida / Intro

Es la primera pantalla de la experiencia. Presenta el logo de WaiVIdol Universe y funciona como acceso al entorno principal. Su objetivo es establecer la identidad del proyecto antes de comenzar la navegación.

## 7.2 Inicio / Home

Es el panel general desde el que se presenta el universo de la aplicación. Resume el acceso a las funciones principales y permite consultar datos generales, como el saldo disponible y la actividad de participación.

## 7.3 Personajes

Contiene el directorio de personajes. Permite explorar las fichas individuales, localizar integrantes y acceder al material gráfico y audiovisual asociado a cada uno.

## 7.4 Ficha individual / Detail

Es la vista dedicada a un personaje. Reúne su nombre, información descriptiva, grupo o pertenencia cuando corresponde, imágenes de su carpeta y el video individual disponible. La ficha busca concentrar la información sin obligar al usuario a recorrer varias pantallas.

## 7.5 Grupos

Organiza los grupos incluidos en el prototipo. Presenta la identidad visual de cada agrupación y permite reconocer a sus integrantes. Desde esta sección se puede continuar hacia las fichas individuales.

## 7.6 Tienda WVID

Es una sección de contenidos desbloqueables. No vende paquetes de saldo ni procesa compras reales: los WVID solo se obtienen jugando al quiz y se gastan en contenidos internos.

## 7.7 Desafío fan / Quiz

Es la sección de preguntas y respuestas. Las preguntas están relacionadas con los personajes y grupos del universo temático. Cuando hay material disponible, cada pregunta se acompaña con una imagen o un video pertinente para dar contexto visual al desafío.

Al seleccionar una respuesta, la aplicación informa el resultado. Las respuestas correctas habilitadas otorgan la recompensa virtual correspondiente.

## 7.8 Billetera / Wallet

Muestra el saldo WVID del usuario y el historial de movimientos generados durante la demostración. Permite observar cómo cambian los puntos al recibir recompensas o realizar operaciones simuladas.

## 7.9 Salir / Exit

La salida forma parte del recorrido audiovisual: al seleccionar la opción de salir se presenta el ending local antes de finalizar la experiencia. La reproducción utiliza los archivos multimedia incluidos en el proyecto.

# 8. Personajes y grupos representados

La organización de contenidos contempla los siguientes perfiles:

## 8.1 Mugendai Mewtype

- **Arale Nakamachi**
  
<img width="1000" height="714" alt="Arale Nakamachi" src="https://github.com/user-attachments/assets/526c6000-5c15-4675-881f-7928698f53bc" />

https://github.com/user-attachments/assets/23a470b0-fb4b-434b-9029-5f222e0ac381

- **Nonoka Miyanaga**

<img width="1800" height="1064" alt="Nonoka Miyanaga" src="https://github.com/user-attachments/assets/573f74b8-a3ad-4861-8d54-7fcf216d2b4a" />

https://github.com/user-attachments/assets/9182f093-64ef-4bfd-81a9-a341c467693d

- **Ritsu Minetsuki**

<img width="1800" height="1084" alt="Ritsu Minetsuki" src="https://github.com/user-attachments/assets/cb8eb3cc-69a3-41cd-bb56-71b9f256fc5e" />

https://github.com/user-attachments/assets/e2a63b65-2b9e-4c93-ba53-b085b82e89fb

- **Miyako Fuji**
  
<img width="383" height="326" alt="Miyako Fuji" src="https://github.com/user-attachments/assets/0309b8b2-55d9-473e-8a51-f38641e739f0" />

https://github.com/user-attachments/assets/02be0dc7-5416-4e3b-8940-34e7d2364b24

- **Yuno Sengoku**

<img width="400" height="344" alt="Yuno Sengoku" src="https://github.com/user-attachments/assets/9631c533-6135-4c96-981d-f95075c0dece" />

https://github.com/user-attachments/assets/2926ea87-54a3-45b0-a96e-f8128beb4795

Cada integrante cuenta con una carpeta propia con imágenes y, cuando está incluido, un video individual. La aplicación usa esos recursos para ilustrar el directorio, las fichas y el contenido relacionado del quiz.

## 8.2 Fairy Bouquet

- **Viola**

<img width="736" height="736" alt="Viola" src="https://github.com/user-attachments/assets/30d6e4c7-ba9f-45c1-b422-112d94495e1e" />

https://github.com/user-attachments/assets/2b5f8be9-003d-4dcd-9a65-5e167d5e2580

- **Bell**

<img width="736" height="736" alt="Bell" src="https://github.com/user-attachments/assets/2202c05f-af7a-49ba-ac59-ac83e12c00a2" />

https://github.com/user-attachments/assets/d6f95ae4-220b-405c-86c6-49a90a6ab4fc

- **Popo**

<img width="736" height="735" alt="Popo" src="https://github.com/user-attachments/assets/a23aef6d-2ccd-4d4e-9c58-60f4671145c4" />

https://github.com/user-attachments/assets/d5fdcae7-169e-4b47-8181-6057b8ff204a

El grupo dispone de una imagen de identificación y carpetas individuales para las integrantes, con material gráfico y audiovisual incluido en el paquete.

## 8.3 Manager / Staff

Se incorpora Manager como figura de apoyo. Su carpeta incluye recursos visuales y un video, de modo que también pueda formar parte de las pantallas y preguntas que correspondan.

La aplicación presenta las identidades ficticias y los créditos públicos pertinentes. No intenta deducir ni inventar datos personales privados de intérpretes o personas detrás de avatares.

<img width="736" height="736" alt="Manager" src="https://github.com/user-attachments/assets/91bb64ec-8e6e-4967-81f5-b8c02f5f7491" />

https://github.com/user-attachments/assets/23ea71cc-8108-4e87-a544-84a755ab984b

# 9. Imágenes, galerías y videos

Los recursos multimedia son parte esencial del proyecto porque permiten que la navegación no sea solamente textual.

## 9.1 Imágenes de personajes

Las imágenes se organizan en carpetas con el nombre de cada personaje. Esta estructura permite identificar con claridad qué recursos corresponden a cada ficha y facilita el mantenimiento del proyecto.

## 9.2 Imágenes de grupos y secciones

La carpeta `assets` reúne recursos gráficos generales, como la portada, la contratapa, el logo, las imágenes de grupos y las ilustraciones asociadas a las funciones principales.

## 9.3 Videos individuales

Las carpetas de personajes incluyen videos MP4 cuando están disponibles. Estos archivos se utilizan como contenido audiovisual relacionado con el personaje correspondiente.

## 9.4 Opening y ending

En `Videos/` se encuentran:

- `Opening.mp4`: presentación audiovisual de entrada.
- `Ending.mp4`: cierre audiovisual al seleccionar la opción de salir.

La reproducción se realiza desde archivos locales, sin depender de YouTube ni de una plataforma externa. Los controles de la experiencia permiten saltar el video o volver al recorrido cuando corresponda. La reproducción automática con sonido puede estar condicionada por las políticas del navegador; si el navegador bloquea el inicio automático, será necesario iniciar la reproducción mediante una acción del usuario.

## 9.5 Organización y mantenimiento

Es importante conservar los nombres y la estructura de las carpetas al extraer o mover el proyecto. Si se renombran o eliminan archivos, las rutas que utiliza la aplicación pueden dejar de encontrarlos.

# 10. Sistema de preguntas y respuestas — Quiz

El quiz incorpora una dinámica de gamificación: el usuario demuestra lo que conoce del universo de personajes y grupos y recibe una recompensa virtual por las respuestas correctas.

El funcionamiento general es:

1. El usuario entra en la sección Desafío fan.
2. La aplicación presenta una pregunta.
3. Se muestra una imagen o video relacionado cuando existe material asociado.
4. El usuario selecciona una respuesta.
5. La aplicación comprueba si la respuesta es correcta.
6. Si la respuesta es correcta dentro de los 5 segundos, acredita **+1 WVID**.
7. Si la respuesta es incorrecta o se agota el tiempo, acredita **+0 WVID** y avanza sin revelar la respuesta correcta.
8. El servidor valida el tiempo y registra el intento para evitar depender solamente del contador del navegador.

La asociación de medios tiene una función didáctica y de ambientación: ayuda a reconocer al personaje o grupo sobre el que se pregunta y vuelve más atractiva la actividad.

# 11. Billetera, tienda y economía virtual simulada

La billetera y la tienda se incorporan para demostrar cómo una aplicación puede administrar puntos, recompensas, consumos y desbloqueos.

## 11.1 Saldo inicial

Cada cuenta nueva comienza con **10 WVID**.

## 11.2 Recompensas

Cada respuesta correcta dentro del límite de tiempo acredita **1 WVID**. Una respuesta incorrecta o un tiempo agotado acredita 0 WVID.

## 11.3 Desbloqueos

| Contenido | Costo |
|---|---:|
| Galería / imágenes adicionales | 5 WVID |
| Historia extendida | 10 WVID |
| Video especial | 15 WVID |

El retrato principal del personaje se muestra gratuitamente. Los desbloqueos se guardan por usuario y no se vuelven a cobrar una vez adquiridos.

## 11.4 Historial

La billetera registra el saldo inicial, las recompensas del quiz y los gastos por desbloqueos, de manera que el usuario pueda revisar cómo se modificó el saldo.

# 12. Diseño de navegación e identidad visual

La identidad de WaiVIdol Universe se apoya en un logo propio y en recursos gráficos asociados a sus secciones. La interfaz combina elementos de catálogo, fichas, tarjetas, reproductores y paneles de información.

Los principios de diseño son:

- **Reconocimiento:** identificar rápidamente cada sección por su nombre y recurso gráfico.
- **Consistencia:** mantener una estructura visual común entre las pantallas.
- **Jerarquía:** diferenciar títulos, información secundaria, controles y contenido multimedia.
- **Accesibilidad de navegación:** permitir volver a secciones anteriores y recorrer el contenido sin perder la orientación.
- **Adaptabilidad:** organizar los elementos para distintos anchos de pantalla.

# 13. Construcción técnica del prototipo

La versión 1.4 utiliza una arquitectura cliente-servidor local. El navegador presenta la interfaz y Java ejecuta la lógica de negocio, expone una API HTTP y sirve los recursos estáticos.

Tecnologías utilizadas:

- **Java 21:** backend, autenticación, reglas de negocio y API HTTP.
- **SQLite / SQL:** almacenamiento persistente de cuentas, billeteras, transacciones, desbloqueos e intentos del quiz.
- **JDBC:** conexión entre Java y SQLite.
- **JSON:** catálogo de personajes y banco de preguntas.
- **HTML5, CSS3 y JavaScript:** estructura, diseño e interacción del frontend.
- **Maven:** compilación y gestión de dependencias.

El servidor escucha en `127.0.0.1:8080`. Es un servicio local para la computadora donde se ejecuta; no es un sitio público ni requiere alojamiento remoto.

## 13.1 Arquitectura general

```text
NAVEGADOR
  HTML + CSS + JavaScript
          | HTTP / JSON
          v
BACKEND JAVA 21
  Main / ApiServer / servicios
          | JDBC
          v
      SQLite local

Catálogos JSON: personajes y preguntas
Recursos estáticos: imágenes, videos y frontend
```

## 13.2 Componentes del backend

- `Main.java`: inicializa base de datos, catálogo, servicios y servidor.
- `ApiServer.java`: publica los endpoints de la API y sirve archivos estáticos.
- `Database.java`: inicializa y administra la conexión SQLite.
- `AuthService.java`: registro, inicio y cierre de sesión. Las contraseñas se almacenan mediante hash PBKDF2 con salt, no como texto plano.
- `WalletService.java`: saldo, historial, recompensas y cobros por desbloqueo.
- `QuizService.java`: preguntas, control del tiempo y validación de respuestas.
- `JsonCatalog.java`: carga personajes y preguntas desde JSON.
- `Http.java` y `Json.java`: utilidades para HTTP y JSON.

## 13.3 API local

Entre las rutas principales se encuentran:

```text
POST /api/auth/register
POST /api/auth/login
POST /api/auth/logout
GET  /api/me
GET  /api/characters
GET  /api/characters/{id}
POST /api/characters/{id}/unlock
GET  /api/wallet
POST /api/quiz/next
POST /api/quiz/answer
```

## 13.4 Frontend

- `index.html`: estructura de pantallas y componentes.
- `style.css`: identidad visual, distribución, tarjetas y adaptación responsive.
- `app.js`: navegación, autenticación, consumo de la API, renderizado de personajes y grupos, temporizador, quiz, desbloqueos y billetera.

El frontend no es responsable de decidir el saldo definitivo: el backend valida las operaciones y SQLite conserva los datos.

# 14. Estructura de carpetas y archivos

```text
WaiVIdol-Universe-Java-SQL-v1.4/
├── pom.xml
├── run-local.bat
├── run-local.sh
├── README.md
└── src/
    └── main/
        ├── java/com/waividol/
        │   ├── Main.java
        │   ├── ApiServer.java
        │   ├── Http.java
        │   ├── Json.java
        │   ├── Database.java
        │   ├── AuthService.java
        │   ├── WalletService.java
        │   ├── QuizService.java
        │   ├── JsonCatalog.java
        │   ├── Character.java
        │   └── QuizQuestion.java
        └── resources/
            ├── db/schema.sql
            ├── data/characters.json
            ├── data/quiz.json
            └── static/
                ├── index.html
                ├── style.css
                ├── app.js
                ├── assets/
                ├── Videos/
                ├── Arale Nakamachi/
                ├── Nonoka Miyanaga/
                ├── Ritsu Minetsuki/
                ├── Miyako Fuji/
                ├── Yuno Sengoku/
                ├── Viola/
                ├── Bell/
                ├── Popo/
                └── Manager/
```

Los nombres y las rutas de los recursos multimedia deben conservarse al mover o extraer el proyecto.

# 15. Instalación y ejecución

## 15.1 Requisitos

- **JDK 21** instalado y disponible en el PATH (o configurado para Maven).
- Conexión a Internet la primera vez si el script necesita descargar Maven o las dependencias.
- Navegador actualizado, preferentemente Chrome o Edge.
- No es necesario instalar SQLite por separado: la aplicación utiliza la dependencia JDBC incluida en Maven.

## 15.2 Windows

1. Descargar y extraer el ZIP completo.
2. Abrir la carpeta raíz `WaiVIdol-Universe-Java-SQL-v1.4`, donde se encuentra `pom.xml`.
3. Abrir una terminal de PowerShell en esa carpeta.
4. Ejecutar:

```powershell
.\run-local.bat
```

5. El script compila el proyecto y ejecuta el backend. La aplicación queda disponible en `http://127.0.0.1:8080`; el lanzador puede abrir el navegador automáticamente.
6. Para detener el servidor, utilizar `Ctrl+C` en la terminal.

## 15.3 Visual Studio Code

Abrir la carpeta completa del proyecto, no solamente `Main.java`. Iniciar la aplicación con `run-local.bat` desde la terminal integrada. No utilizar el botón **Run Java** sobre `Main.java` para esta configuración: eso puede ejecutar una clase aislada sin las demás clases ni las dependencias Maven.

## 15.4 macOS o Linux

Con JDK 21 instalado, abrir una terminal en la raíz del proyecto y ejecutar:

```bash
sh run-local.sh
```

La dirección local es `http://127.0.0.1:8080`. Para detener el servidor, presionar `Ctrl+C`.

# 16. Flujo de uso de principio a fin

1. Ejecutar el proyecto y abrir la aplicación local.
2. Crear una cuenta o iniciar sesión.
3. Una cuenta nueva recibe 10 WVID iniciales.
4. Explorar Inicio, Personajes y Grupos.
5. Abrir una ficha para consultar descripción, avatar virtual e intérprete.
6. Ver gratuitamente el retrato principal.
7. Jugar el quiz: cada pregunta presenta imagen y video del personaje relacionado y un límite de 5 segundos.
8. Recibir +1 WVID por respuesta correcta; una respuesta incorrecta o el tiempo agotado no suman puntos ni revelan la respuesta correcta.
9. Consultar el saldo y el historial en Billetera.
10. Gastar WVID para desbloquear galería adicional, historia extendida o video especial.
11. Cerrar sesión y volver a ingresar: la cuenta, saldo e ítems desbloqueados permanecen guardados en SQLite.

# 17. Privacidad, almacenamiento y funcionamiento local

- Las cuentas se administran en el backend local.
- La base SQLite se almacena en el perfil local del sistema operativo, en `~/.waividol-universe/waividol.sqlite`. En Windows corresponde normalmente al perfil del usuario.
- Las contraseñas se guardan como hash PBKDF2 con salt aleatorio.
- El saldo, los movimientos, los intentos del quiz y los desbloqueos se guardan en SQLite.
- Los archivos de imagen, video, HTML, CSS y JavaScript se sirven desde los recursos incluidos en el proyecto.
- No se conecta a blockchain, wallets externas, bancos ni procesadores de pago.
- WVID no tiene valor monetario, cotización, posibilidad de retiro ni transferencia.
- No existe sincronización automática entre computadoras: cada instalación local utiliza su propia base de datos.

La base de datos debe conservarse si se desea mantener las cuentas y el progreso. Eliminar `waividol.sqlite` equivale a perder los datos locales guardados.

# 18. Pruebas y criterios de evaluación

Para evaluar el prototipo se recomienda comprobar los siguientes aspectos:

| Área | Comprobación esperada |
|---|---|
| Inicio | El logo y la pantalla inicial se muestran correctamente. |
| Navegación | Se puede entrar y salir de cada sección. |
| Personajes | Las fichas muestran el contenido correspondiente. |
| Grupos | Se reconocen los grupos y sus integrantes. |
| Imágenes | Los recursos se cargan desde las carpetas locales. |
| Videos | Los videos individuales se reproducen cuando se seleccionan. |
| Opening / ending | Los videos de entrada y salida se encuentran y reproducen. |
| Quiz | Las preguntas aceptan respuestas y muestran el resultado. |
| Recompensas | Una pregunta no acredita dos veces la misma recompensa. |
| Billetera | El saldo y el historial reflejan las operaciones simuladas. |
| Tienda | Las operaciones son internas y no solicitan pagos. |
| Persistencia | Las cuentas, el saldo y los desbloqueos continúan disponibles al volver a iniciar sesión en la misma base SQLite. |
| Adaptabilidad | La interfaz se puede recorrer en pantalla grande y pequeña. |

También conviene probar la aplicación después de extraer nuevamente el ZIP, para confirmar que todas las carpetas y rutas estén presentes.

# 19. Etapas de desarrollo y evolución del trabajo

El proyecto se fue construyendo por etapas, desde la definición conceptual hasta la integración de contenido multimedia.

## Etapa 1 — Definición de la propuesta

Se estableció la idea de crear una plataforma fan-made que reúna personajes, idols virtuales, VTubers y elementos de participación. En esta etapa se definió el nombre WaiVIdol Universe y el universo temático de referencia.

## Etapa 2 — Delimitación académica y funcional

Se decidió que WVID sería únicamente un saldo virtual local. Esta decisión delimitó el alcance y evitó incorporar blockchain, billeteras reales, pagos o servicios financieros.

## Etapa 3 — Identidad visual y estructura

Se creó el logo y se definieron las secciones principales: inicio, personajes, grupos, quiz, billetera y salida audiovisual.

## Etapa 4 — Desarrollo de la navegación

Se construyó el HTML principal y la lógica de navegación entre pantallas, buscando que el usuario pudiera recorrer la aplicación desde un punto de entrada único.

## Etapa 5 — Incorporación de personajes y grupos

Se organizaron las fichas de Mugendai Mewtype, Fairy Bouquet y Manager. Se añadieron descripciones y relaciones de pertenencia.

## Etapa 6 — Economía virtual simulada

Se implementaron cuentas locales, saldo inicial de 10 WVID, recompensas de +1 WVID por acierto, desbloqueos y registro de movimientos en SQLite.

## Etapa 7 — Integración audiovisual

Se incorporaron las carpetas de imágenes y videos de cada personaje, junto con el opening y el ending. Se estableció el uso de recursos locales para que la experiencia no dependa de alojamientos externos.

## Etapa 8 — Quiz contextual

Se vinculó el desafío de preguntas con imágenes y videos relacionados con el contenido de cada pregunta, reforzando la relación entre aprendizaje, reconocimiento visual y recompensa.

## Etapa 9 — Pruebas y documentación

Se revisaron rutas, archivos y estructura del proyecto, y se preparó esta documentación para explicar su propósito, funcionamiento, límites y recorrido de desarrollo.

# 20. Limitaciones y posibles mejoras futuras

Al tratarse de un prototipo académico local, existen límites deliberados:

- Los datos no se comparten ni sincronizan entre dispositivos.
- Las cuentas son locales y no se sincronizan con un servidor remoto.
- El saldo no tiene valor real ni puede transferirse.
- La disponibilidad de pantalla completa y reproducción automática depende del navegador y de sus permisos.
- La reproducción de archivos locales depende de que se mantengan las carpetas y nombres de archivo.
- La cantidad de preguntas y contenidos depende del material incorporado al prototipo.

Como futuras ampliaciones se podrían considerar:

- Más preguntas y niveles de dificultad.
- Filtros por grupo, personaje o categoría.
- Más opciones de accesibilidad y subtítulos.
- Mejoras en las transiciones y animaciones.
- Un panel de estadísticas de participación local.
- Un modo de presentación para exponer el proyecto en clase.
- Una documentación técnica complementaria con diagramas de navegación y modelo de datos.

Cualquier ampliación debe conservar el alcance definido: WVID continúa siendo una unidad virtual de demostración, salvo que el proyecto académico cambie formalmente de objetivos y se realice un análisis independiente de seguridad, legalidad y viabilidad.

# 21. Derechos de autor y aclaración de afiliación

**WaiVIdol Universe es un concepto fan-made desarrollado con fines académicos y demostrativos. No es un producto oficial, no está afiliado, patrocinado ni respaldado por Bushiroad ni por los titulares de BanG Dream!.**

Los nombres, personajes, diseños, marcas y materiales audiovisuales relacionados con *BanG Dream! YUME∞MITA* pertenecen a sus respectivos titulares. El uso de recursos en una presentación académica debe respetar las condiciones aplicables y no debe interpretarse como autorización para su distribución comercial.

No se inventan fotografías ni identidades privadas de intérpretes o personas detrás de avatares. La aplicación se limita a información pública y a los materiales que forman parte del paquete de trabajo.

# 22. Objetivo final y conclusión

El objetivo final de WaiVIdol Universe es presentar un prototipo académico completo que demuestre cómo una idea temática puede convertirse en una experiencia web navegable, visual e interactiva.

El proyecto busca integrar en una sola aplicación:

- Una identidad visual reconocible.
- Una estructura ordenada de personajes y grupos.
- Fichas individuales con imágenes y videos.
- Una presentación audiovisual de entrada y salida.
- Un sistema de preguntas y respuestas contextualizado.
- Una recompensa virtual que incentiva la participación.
- Un sistema de desbloqueos y una billetera virtual de prueba.
- Persistencia local de los datos.
- Una experiencia adaptable a distintos dispositivos.

Desde el punto de vista académico, el valor del trabajo está en la integración de diseño, organización de información, programación web, gestión de recursos multimedia, interacción y gamificación. El prototipo permite demostrar el recorrido completo de una aplicación, desde su presentación inicial hasta el cierre, sin depender de pagos reales ni de infraestructura financiera.

**En síntesis, WaiVIdol Universe transforma el seguimiento de un universo de idols virtuales en una experiencia digital participativa: explorar, mirar, responder, obtener puntos de demostración y descubrir contenido dentro de un entorno local creado como proyecto académico.**

# 23. Fuentes de referencia

Las siguientes páginas oficiales sirven como referencia para contrastar nombres, personajes, grupos y créditos públicos:

- BanG Dream! YUME∞MITA — sitio oficial en inglés: https://en.bang-dream.com/anime/yumemita/
- BanG Dream! — artistas / YUME∞MITA: https://bang-dream.com/artist/yumemita/
- BanG Dream! YUME∞MITA — Staff & Cast: https://anime.bang-dream.com/yumemita/staff-cast/

**Fin del documento.**


---

# 24. Notas de versión

## Versión 1.3

- El lanzador `run-local.bat` compila y ejecuta el backend; Java abre automáticamente `http://127.0.0.1:8080` en el navegador predeterminado cuando el servidor ya está iniciado.
- El directorio de personajes muestra gratuitamente la imagen de portada de cada personaje.
- Si una imagen de portada no se puede cargar, se utiliza una alternativa visual.

## Versión 1.4 — Restauración del diseño clásico

- Quiz visual con retrato y video local del personaje asociado a cada pregunta; conserva el límite de 5 segundos y el premio de +1 WVID por acierto.
- Se quitaron las páginas independientes Multimedia y Ajustes de la navegación.
- Perfiles de personajes con retrato principal gratuito a la izquierda y descripción, avatar virtual, intérprete, historia y desbloqueos a la derecha.
- Las imágenes adicionales cuestan 5 WVID, la historia extendida 10 WVID y el video especial 15 WVID.
- Grupos con imágenes de los personajes que integran cada banda.

# 25. Derechos de autor y aclaración de afiliación

**WaiVIdol Universe es un concepto fan-made desarrollado con fines académicos y demostrativos. No es un producto oficial, no está afiliado, patrocinado ni respaldado por Bushiroad ni por los titulares de BanG Dream!.**

Los nombres, personajes, diseños, marcas y materiales audiovisuales relacionados con *BanG Dream! YUME∞MITA* pertenecen a sus respectivos titulares. El uso de recursos en una presentación académica debe respetar las condiciones aplicables y no debe interpretarse como autorización para su distribución comercial.

# 26. Objetivo final y conclusión

WaiVIdol Universe integra identidad visual, organización de personajes y grupos, fichas individuales, recursos multimedia, un quiz contextualizado, recompensas virtuales y desbloqueos persistentes. Desde el punto de vista académico, el valor del trabajo está en integrar diseño de interfaz, programación Java, persistencia SQL, catálogos JSON, gestión de archivos multimedia e interacción gamificada.

El flujo central de la versión 1.4 es **explorar → responder → ganar WVID → ahorrar → desbloquear contenido** dentro de un entorno local y sin operaciones monetarias reales.

# 27. Fuentes de referencia

- BanG Dream! YUME∞MITA — sitio oficial en inglés: https://en.bang-dream.com/anime/yumemita/
- BanG Dream! — artistas / YUME∞MITA: https://bang-dream.com/artist/yumemita/
- BanG Dream! YUME∞MITA — Staff & Cast: https://anime.bang-dream.com/yumemita/staff-cast/

**Fin del documento.**
