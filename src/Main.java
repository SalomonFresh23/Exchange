import java.io.IOException;
import java.util.Scanner;

public class Main {


    static void main()  {


            ConexionApi conexionApi = new ConexionApi();

            Scanner in = new Scanner(System.in);
            Boolean salida = false;
            double monto = 0;
            String monedaBase;
            String monedaDeseada;
            String opcion;
            while (!salida) {


                System.out.println("Bienvenido al conversor de monedas! \n");
                System.out.println("A continuacion, escribe el monto que deseas convertir ");
                monto = in.nextInt();

                in.nextLine();

                System.out.println("Tipo de moneda del monto");
                monedaBase = in.nextLine().toUpperCase();

                System.out.println("Tipo de moneda al cambio deseada");
                monedaDeseada = in.nextLine().toUpperCase();

                try {
                    String json = conexionApi.obtenerJson(monedaBase);
                    double tasaDeCambio = TasaDeCambio.obtenerTasa(json, monedaDeseada);
                    System.out.println("el resultado es: " + tasaDeCambio * monto);
                } catch (IOException e) {
                    System.out.println("ERROR con la conexion" + e.getMessage());
                    System.out.println("Intente otra vez");

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Chanfles, no sabemos que ocurio...." + e.getMessage());
                }


                System.out.println("Si deseas salir, escribe 'salir', de lo contrario presiona enter");
                opcion = in.nextLine();
                if (opcion.equalsIgnoreCase("salir")) {
                    salida = true;
                }


            }
        }
    }

