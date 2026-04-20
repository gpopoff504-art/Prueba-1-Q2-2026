/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1package;

/**
 *
 * @author gpopo
 */
import java.util.Scanner;

public class JavaLook {

    static EmailAccount[] cuentas = new EmailAccount[100];
    static EmailAccount cuentaActiva = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuInicial();
    }

    static void menuInicial() {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\n=== MENU INICIAL ===");
            System.out.println("1. Login");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> login();
                case 2 -> crearCuenta();
                case 3 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    static void menuPrincipal() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n=== MENU PRINCIPAL | " + cuentaActiva.getEmail() + " ===");
            System.out.println("1. Ver inbox");
            System.out.println("2. Mandar correo");
            System.out.println("3. Leer un correo");
            System.out.println("4. Limpiar inbox");
            System.out.println("5. Cerrar sesion");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> cuentaActiva.mostrarInbox();
                case 2 -> mandarCorreo();
                case 3 -> leerCorreo();
                case 4 -> cuentaActiva.limpiarInbox();
                case 5 -> {
                    cuentaActiva = null;
                    System.out.println("Sesion cerrada.");
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    static void login() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        EmailAccount cuenta = buscarCuenta(email);

        if (cuenta != null && cuenta.getPassword().equals(password)) {
            cuentaActiva = cuenta;
            System.out.println("Bienvenido, " + cuenta.getNombre());
            menuPrincipal();
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    static void crearCuenta() {
        System.out.print("Email: ");
        String email = sc.nextLine();

        if (buscarCuenta(email) != null) {
            System.out.println("Ese email ya existe.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new EmailAccount(email, password, nombre);
                cuentaActiva = cuentas[i];
                System.out.println("Cuenta creada. Bienvenido, " + nombre);
                menuPrincipal();
                return;
            }
        }

        System.out.println("No hay espacio para nuevas cuentas.");
    }

    static void mandarCorreo() {
        System.out.print("Email del destinatario: ");
        String destino = sc.nextLine();

        EmailAccount destinatario = buscarCuenta(destino);

        if (destinatario == null) {
            System.out.println("El destinatario no existe.");
            return;
        }

        System.out.print("Asunto: ");
        String asunto = sc.nextLine();
        System.out.print("Contenido: ");
        String contenido = sc.nextLine();

        Email correo = new Email(cuentaActiva.getEmail(), asunto, contenido);

        if (destinatario.recibirEmail(correo)) {
            System.out.println("Correo enviado exitosamente.");
        } else {
            System.out.println("El inbox del destinatario esta lleno.");
        }
    }

    static void leerCorreo() {
        System.out.print("Posicion del correo: ");
        int pos = sc.nextInt();
        sc.nextLine();
        cuentaActiva.leerEmail(pos);
    }

    static EmailAccount buscarCuenta(String email) {
        for (EmailAccount cuenta : cuentas) {
            if (cuenta != null && cuenta.getEmail().equals(email)) {
                return cuenta;
            }
        }
        return null;
    }
}
