/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Usuario;
import modelo.Estudiante;
import modelo.Profesor;

/**
 *
 * @author josue
 */
public class CRUDUsuarios {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("   CRUD DE USUARIOS ");
            System.out.println("==============================");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarUsuario(sc, dao);
                    break;
                case 2:
                    listarUsuarios(dao);
                    break;
                case 3:
                    buscarUsuarioPorId(sc, dao);
                    break;
                case 4:
                    actualizarUsuario(sc, dao);
                    break;
                case 5:
                    eliminarUsuario(sc, dao);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }

    public static void agregarUsuario(Scanner sc, UsuarioDAO dao) {
        System.out.println("\n--- AGREGAR USUARIO ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Tipo (estudiante/profesor): ");
        String tipo = sc.nextLine();

        Usuario u = null;

        if (tipo.equalsIgnoreCase("estudiante")) {
            u = new Estudiante();
        } else if (tipo.equalsIgnoreCase("profesor")) {
            u = new Profesor();
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setPassword(password);

        dao.agregarUsuario(u);
    }

    public static void listarUsuarios(UsuarioDAO dao) {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        ArrayList<Usuario> lista = dao.listarUsuarios();

        if (lista.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario u : lista) {
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Correo: " + u.getCorreo());
            System.out.println("Tipo: " + u.getTipo());
            System.out.println("----------------------------");
        }
    }

    public static void buscarUsuarioPorId(Scanner sc, UsuarioDAO dao) {
        System.out.println("\n--- BUSCAR USUARIO POR ID ---");
        System.out.print("Ingrese el ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario u = dao.obtenerUsuarioPorId(id);

        if (u != null) {
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Correo: " + u.getCorreo());
            System.out.println("Tipo: " + u.getTipo());
        } else {
            System.out.println("No se encontró el usuario.");
        }
    }

    public static void actualizarUsuario(Scanner sc, UsuarioDAO dao) {
        System.out.println("\n--- ACTUALIZAR USUARIO ---");
        System.out.print("Ingrese el ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario existente = dao.obtenerUsuarioPorId(id);

        if (existente == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = sc.nextLine();

        System.out.print("Nuevo password: ");
        String password = sc.nextLine();

        System.out.print("Nuevo tipo (estudiante/profesor): ");
        String tipo = sc.nextLine();

        Usuario u = null;

        if (tipo.equalsIgnoreCase("estudiante")) {
            u = new Estudiante();
        } else if (tipo.equalsIgnoreCase("profesor")) {
            u = new Profesor();
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        u.setId(id);
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setPassword(password);

        dao.actualizarUsuario(u);
    }

    public static void eliminarUsuario(Scanner sc, UsuarioDAO dao) {
        System.out.println("\n--- ELIMINAR USUARIO ---");
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario existente = dao.obtenerUsuarioPorId(id);

        if (existente == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        System.out.println("Usuario: " + existente.getNombre() + " - " + existente.getCorreo());
        System.out.print("¿Seguro que desea eliminarlo? (s/n): ");
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            dao.eliminarUsuario(id);
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
}
