package westmarket;

import java.util.ArrayList;
import java.util.Scanner;

public class WestMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Productos> productosList = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Congelados"));
        categorias.add(new Categoria(3, "Lácteos"));
        categorias.add(new Categoria(4, "Aseo"));

        int opcion;
        do {
            System.out.println("--- West Market ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Imprimir productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarProducto(scanner, productosList, categorias);
                    break;
                case 2:
                    imprimirProductos(productosList);
                    break;
                case 3:
                    eliminarProducto(scanner, productosList);
                    break;
                case 4:
                    System.out.println("Ha salido del sistema");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarProducto(Scanner scanner, ArrayList<Productos> productosList, ArrayList<Categoria> categorias) {
        int contador = 0;
        int codigo = 0;
        String descripcion = "";
        int precio = 0;
        int cantidad = 0;

        while (contador < 3) {
            System.out.print("Ingrese código: ");
            try {
                codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1) {
                    contador++;
                    System.out.println("Ingrese código válido.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese código válido.");
                contador++;
            }
        }

        if (contador < 3) {
            while (contador < 3) {
                System.out.print("Ingrese descripción: ");
                descripcion = scanner.nextLine();
                if (descripcion.isEmpty()) {
                    contador++;
                    System.out.println("Ingrese descripción válida.");
                } else {
                    break;
                }
            }
        }

        if (contador < 3) {
            while (contador < 3) {
                System.out.print("Ingrese precio: ");
                try {
                    precio = Integer.parseInt(scanner.nextLine());
                    if (precio < 1) {
                        contador++;
                        System.out.println("Ingrese precio válido.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese precio válido.");
                    contador++;
                }
            }
        }

        if (contador < 3) {
            while (contador < 3) {
                System.out.print("Ingrese cantidad: ");
                try {
                    cantidad = Integer.parseInt(scanner.nextLine());
                    if (cantidad < 1) {
                        contador++;
                        System.out.println("Ingrese cantidad válida.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese cantidad válida.");
                    contador++;
                }
            }
        }
        int categoriaSeleccionada = 0;
        if (contador < 3) {
            while (contador < 3) {
                System.out.println("Categorías disponibles:");

                for (Categoria categoria : categorias) {
                    System.out.println(categoria.getCodigo() + ". " + categoria.getNombre());
                }

                int categoriaSeleccionadaTemp = 0;

                System.out.print("Seleccione una categoría: ");
                try {
                    categoriaSeleccionadaTemp = Integer.parseInt(scanner.nextLine());
                    if (categoriaSeleccionadaTemp < 1 || categoriaSeleccionadaTemp > categorias.size()) {
                        contador++;
                        System.out.println("Ingrese categoria válida.");
                    } else {
                        categoriaSeleccionada = categoriaSeleccionadaTemp;
                        
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese categoría válida.");
                    contador++;
                }

            }
        }

        if (contador == 3) {
            System.out.println("Ha sobrepasado la cantidad máxima de intentos, adiós!");
        } else {
            Categoria categoria = categorias.get(categoriaSeleccionada - 1);
            Productos producto = new Productos(codigo, descripcion, precio, cantidad, categoria);
            productosList.add(producto);
            System.out.println("El producto ha sido ingresado.");
        }
    }

    private static void imprimirProductos(ArrayList<Productos> productosList) {
        if (productosList.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Productos producto : productosList) {
                producto.imprimirListado();
            }
        }
    }

    private static void eliminarProducto(Scanner scanner, ArrayList<Productos> productosList) {
        if (productosList.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
        } else {
            System.out.println("--- Productos ingresados ---");
            for (Productos producto : productosList) {
                producto.imprimirListadoSimple();
            }

            System.out.print("Ingrese el código del producto que desea eliminar: ");
            int codigoEliminar = Integer.parseInt(scanner.nextLine());
            boolean encontrado = false;
            for (Productos producto : productosList) {
                if (producto.getCodigo() == codigoEliminar) {
                    productosList.remove(producto);
                    System.out.println("El producto ha sido eliminado.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Producto no encontrado.");
            }
        }
    }
}
