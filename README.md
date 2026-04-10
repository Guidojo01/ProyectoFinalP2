# ProyectoFinalP2
Este proyecto consiste en un sistema basico web desarrollado en Java, se realizan operaciones del CRUD en consola y se agrega CRUD de cursos en web 

Utilice estos programas para poder desarrollar este proyecto 
Java, JSP, Servlets, MySQL, JDBC, Netbeans y GlassFish Server 

Implementé  un CRUD completamente funcional en consola para los cursos y los usuarios 
Cursos:
-Agregar Curso
-Listar cursos
-Buscar curso por ID
-Actualizar curso
-Eliminar curso

Usuarios:
-Agregar usuario
-Listar usuarios
-Buscar usuario por ID
-Actualizar usuario
-Eliminar usuario

En la parte Web se implementa un Login de usuarios, se valida por medio de los usuarios guardados en la base de datos, se crea un logout, se implementó un CRUD de cursos 

Se creo por medio de MySQL la base de datos con dos tablas una de usuarios y la otra de cursos, todo se guarda por medio del CRUD 
Los datos se gestionan mediante clases DAO que estos se encargan de la conexion y la ejecucion de realizar consultas 

La estructura de este proyecto se ve de la siguiente manera 
Paquetes:
Modelo: Clases como Usuario, Estudiante, Profesor y Curso
DAO: Acceso a los datos UsuarioDAO y CursoDAO
Servlet: Aqui se encarga la logica de control de la Web 
Util: Conexion a la base de datos y CRUD en la consola 

Durante la realizacion de este proyecto se priorizó 
-Tener CRUD completo en consola tanto de Usuarios como de Cursos
-La conexion a la base de datos 
-Mantener la estructura del proyecto bien organizada por medio de los DAO
-Agregar una interfaz web funcional 

Gracias a este proyecto logre entender mejor la realizacion de la conexion de Java con MySQL, uso de los PreparedStatement para realizar consultas, manejo de sesiones en aplicaciones Web, separar la logica con el patron DAO.

Josue David Guido Baltodano 
