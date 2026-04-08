/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import dao.CursoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Curso;

/**
 *
 * @author josue
 */
public class CRUDCursos {
    
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CursoDAO dao = new CursoDAO();
        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("   CRUD DE CURSOS ");
            System.out.println("==============================");
            System.out.println("1. Agregar curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Buscar curso por ID");
            System.out.println("4. Actualizar curso");
            System.out.println("5. Eliminar curso");
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
                    agregarCurso(sc, dao);
                    break;

                case 2:
                    listarCursos(dao);
                    break;

                case 3:
                    buscarCursoPorId(sc, dao);
                    break;

                case 4:
                    actualizarCurso(sc, dao);
                    break;

                case 5:
                    eliminarCurso(sc, dao);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }

    public static void agregarCurso(Scanner sc, CursoDAO dao) {
        System.out.println("\n--- AGREGAR CURSO ---");

        System.out.print("Nombre del curso: ");
        String nombre = sc.nextLine();

        System.out.print("Descripción del curso: ");
        String descripcion = sc.nextLine();

        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);

        dao.agregarCurso(curso);
        System.out.println("Curso agregado correctamente.");
    }

    public static void listarCursos(CursoDAO dao) {
        System.out.println("\n--- LISTA DE CURSOS ---");

        ArrayList<Curso> lista = dao.listarCursos();

        if (lista.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        for (Curso c : lista) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Descripción: " + c.getDescripcion());
            System.out.println("----------------------------");
        }
    }

    public static void buscarCursoPorId(Scanner sc, CursoDAO dao) {
        System.out.println("\n--- BUSCAR CURSO POR ID ---");
        System.out.print("Ingrese el ID del curso: ");

        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un ID válido: ");
            sc.next();
        }

        int id = sc.nextInt();
        sc.nextLine();

        Curso curso = dao.obtenerCurso(id);

        if (curso != null) {
            System.out.println("Curso encontrado:");
            System.out.println("ID: " + curso.getId());
            System.out.println("Nombre: " + curso.getNombre());
            System.out.println("Descripción: " + curso.getDescripcion());
        } else {
            System.out.println("No se encontró un curso con ese ID.");
        }
    }

    public static void actualizarCurso(Scanner sc, CursoDAO dao) {
        System.out.println("\n--- ACTUALIZAR CURSO ---");
        System.out.print("Ingrese el ID del curso a actualizar: ");

        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un ID válido: ");
            sc.next();
        }

        int id = sc.nextInt();
        sc.nextLine();

        Curso existente = dao.obtenerCurso(id);

        if (existente == null) {
            System.out.println("No existe un curso con ese ID.");
            return;
        }

        System.out.println("Curso actual:");
        System.out.println("Nombre: " + existente.getNombre());
        System.out.println("Descripción: " + existente.getDescripcion());

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();

        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);

        dao.actualizarCurso(curso);
        System.out.println("Curso actualizado correctamente.");
    }

    public static void eliminarCurso(Scanner sc, CursoDAO dao) {
        System.out.println("\n--- ELIMINAR CURSO ---");
        System.out.print("Ingrese el ID del curso a eliminar: ");

        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un ID válido: ");
            sc.next();
        }

        int id = sc.nextInt();
        sc.nextLine();

        Curso existente = dao.obtenerCurso(id);

        if (existente == null) {
            System.out.println("No existe un curso con ese ID.");
            return;
        }

        System.out.println("Curso a eliminar:");
        System.out.println("ID: " + existente.getId());
        System.out.println("Nombre: " + existente.getNombre());
        System.out.println("Descripción: " + existente.getDescripcion());

        System.out.print("¿Seguro que desea eliminarlo? (s/n): ");
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            dao.eliminarCurso(id);
            System.out.println("Curso eliminado correctamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
}

