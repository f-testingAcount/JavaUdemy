package usuario;

import datos.*;
import static datos.AccesoDatosImpl.*;
import dominio.*;
import excepciones.AccesoDatosEx;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import negocios.*;

/**
 *
 * @author Fabricio
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AccesoDatosEx {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        Marca marca = new Marca();
        Modelo modelo = new Modelo();
        CaracteristicasTec caracteristicas = new CaracteristicasTec();
        Distribuidor distribuidor = new Distribuidor();
        Agencia agencia = new Agencia();
        Gerente gerente = new Gerente();
        Vendedor vendedor = new Vendedor();
        Recepcionista recepcionista = new Recepcionista();
        Mantenimiento operario = new Mantenimiento();
        Mecanico mecanico = new Mecanico();
        Taller taller = new Taller();

        IAccesoDatos datos = new AccesoDatosImpl();
        IAccionesComerciales accion = new AccionesComercialesImpl();

        int opcion = -1;

        do {
            opcion = 0;
            System.out.println("""
                               
                               Ingrese una opcion: 
                               1  - Iniciar archivos 
                               2  - Agregar datos 
                               3  - Vender Vehiculo 
                               4  - Ingresar al service de garantia 
                               5  - Servicio mecanico externo 
                               6  - Listar archivos (seleccione cual) 
                               7  - Buscar 
                               8  - Borrar archivo 
                               9  - Control stock 
                               10 - Buscar indice 
                               11 - Empty 
                               12 - Enviar pedido / recibir unidades 
                               13 - Empty 
                               0  - Salir
                               """);

            opcion = input.nextInt();

            switch (opcion) {
                case 1 -> { //Agregar marca
                    accion.iniciar();
                }
                case 2 -> {
                    opcion = 0;
                    System.out.println("""
                                       \nIngrese el nombre del archivo: 
                                       1  - Marcas.txt 
                                       2  - Modelos.txt 
                                       3  - Caracteristicas Tecnicas.txt 
                                       4  - Distribuidores.txt 
                                       5  - Agencias.txt 
                                       6  - Gerentes.txt 
                                       7  - Vendedores.txt 
                                       8  - Recepcionistas.txt 
                                       9  - Mantenimiento.txt 
                                       10 - Mecanicos.txt 
                                       11 - Taller.txt\n""");
                    opcion = input.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            var nombreArchivo = "Marcas.txt";
                            System.out.println("Ingrese el nombre de la marca: ");
                            var nombre = inputString.nextLine();
                            marca.setNombre(nombre);
                            System.out.println("Ingrese el origen de la marca: ");
                            var origen = inputString.nextLine();
                            marca.setOrigen(origen);
                            System.out.println("Ingrese el logo de la marca: ");
                            var logo = inputString.nextLine();
                            marca.setLogo(logo);
                            accion.agregar(nombreArchivo, marca);
                        }
                        case 2 -> {
                            var nombreArchivo = "Modelos.txt";
                            System.out.println("Ingrese la marca: ");
                            var nombreMarca = inputString.nextLine();
                            modelo.setNombreMarca(nombreMarca);
                            System.out.println("Ingrese la denominacion del modelo: ");
                            var denominacion = inputString.nextLine();
                            modelo.setDenominacion(denominacion);
                            System.out.println("Ingrese el tipo de vehiculo (auto, camioneta, moto, camion): ");
                            var tipoVehiculo = inputString.nextLine();
                            modelo.setTipoVehiculo(tipoVehiculo);
                            System.out.println("Ingrese la cantidad de unidades: ");
                            var cantidad = inputString.nextInt();
                            modelo.setCantidad(cantidad);
                            accion.agregar(nombreArchivo, modelo);
                        }
                        case 3 -> { //Agregar caracteristicas tecnicas
                            var nombreArchio = "Caracteristicas Tecnicas.txt";
                            System.out.println("Ingrese la denominacion del modelo: ");
                            var modeloDenominacion = inputString.nextLine();
                            caracteristicas.setModeloDenominacion(modeloDenominacion);
                            System.out.println("Ingrese el tipo de motor y la posicion(Nafta / gasoil, Delantero / Central / Trasero): ");
                            var tipoMotor = inputString.nextLine();
                            caracteristicas.setTipoMotor(tipoMotor);
                            System.out.println("Ingrese la cantidad de cilindros y la disposion: ");
                            var cilindros = inputString.nextLine();
                            caracteristicas.setCilindros(cilindros);
                            System.out.println("Ingrese la cilindrada y la unidad de medida: ");
                            var cilindrada = inputString.nextLine();
                            caracteristicas.setCilindrada(cilindrada);
                            System.out.println("Ingrese la potencia del motor en HP: ");
                            var HP = input.nextInt();
                            caracteristicas.setHP(HP);
                            System.out.println("Ingrese las caracteristicas de la caja de transmision (manual o automatica y cantidad de velocidades)");
                            var caja = inputString.nextLine();
                            caracteristicas.setCaja(caja);
                            System.out.println("Ingrese el nivel de equipamiento (base o full): ");
                            var equipamiento = inputString.nextLine();
                            caracteristicas.setEquipameiento();
                            System.out.println("Ingrese el tipo de carroceria (auto, camioneta, suv, camion, moto, cantidad de puertas, berlina o spider ");
                            var carroceria = inputString.nextLine();
                            caracteristicas.setCarroceria(carroceria);
                            System.out.println("Ingrese el id del vehiculo: ");
                            var id = inputString.nextInt();
                            caracteristicas.setCarroceria(carroceria);
                            accion.agregar(nombreArchio, caracteristicas);
                        }
                        case 4 -> {//Agregar distribuidor
                            var nombreArchivo = "Distribuidores.txt";
                            System.out.println("Ingrese el nombre del distribuidor: ");
                            var nombreDistribuidor = inputString.nextLine();
                            distribuidor.setNombreDistribuidor(nombreDistribuidor);
                            System.out.println("Ingrese el pais donde se localiza la sede: ");
                            var pais = inputString.nextLine();
                            distribuidor.setPais(pais);
                            System.out.println("Ingrese la marca distribuida: ");
                            var marcaDistribuida = inputString.nextLine();
                            distribuidor.setMarcaDistribuida(marcaDistribuida);
                            accion.agregar(nombreArchivo, distribuidor);
                        }
                        case 5 -> { //Agregar agencia
                            var nombreArchivo = "Agencias.txt";
                            System.out.println("Ingrese el nombre de la agencia: ");
                            var nombreAgencia = inputString.nextLine();
                            agencia.setNombreAgencia(nombreAgencia);
                            System.out.println("Ingrese la ciudad donde se localiza la agencia: ");
                            var ciudad = inputString.nextLine();
                            agencia.setCiudad(ciudad);
                            System.out.println("Ingrese la marca que comercializa la agencia: ");
                            var marcaComercializada = inputString.nextLine();
                            agencia.setMarcaComercializada(marcaComercializada);
                            accion.agregar(nombreArchivo, agencia);
                        }
                        case 6 -> {//Agregar distribuidor
                            var nombreArchivo = "Gerentes.txt";
                            System.out.println("Ingrese el nombre del gerente: ");
                            var nombre = inputString.nextLine();
                            gerente.setNombre(nombre);
                            System.out.println("Ingrese el apellido del gerente: ");
                            var apellido = inputString.nextLine();
                            gerente.setApellido(apellido);
                            System.out.println("Ingrese el DNI del gerente: ");
                            var dni = input.nextInt();
                            gerente.setDni(dni);
                            System.out.println("Ingrese la edad del gerente: ");
                            var edad = input.nextInt();
                            gerente.setEdad(edad);
                            System.out.println("Ingrese el area de desempeño: ");
                            var area = inputString.nextLine();
                            gerente.setArea(area);
                            System.out.println("Ingrese los estudios acreditados: ");
                            var estudios = inputString.nextLine();
                            gerente.setEstudios(estudios);
                            System.out.println("Ingrese el nombre de la agencia donde se desempeña el gerente: ");
                            var nombreAgencia = inputString.nextLine();
                            gerente.setNombreAgencia(nombreAgencia);
                            accion.agregar(nombreArchivo, gerente);
                        }
                        case 7 -> {//Agregar vendedor
                            var nombreArchivo = "Vendedores.txt";
                            System.out.println("Ingrese el nombre del vendedor: ");
                            var nombre = inputString.nextLine();
                            vendedor.setNombre(nombre);
                            System.out.println("Ingrese el apellido del vendedor: ");
                            var apellido = inputString.nextLine();
                            vendedor.setApellido(apellido);
                            System.out.println("Ingrese el DNI del vendedor: ");
                            var dni = input.nextInt();
                            vendedor.setDni(dni);
                            System.out.println("Ingrese la edad del vendedor: ");
                            var edad = input.nextInt();
                            vendedor.setEdad(edad);
                            System.out.println("Ingrese el area donde se desempeña el vendedor: ");
                            var area = inputString.nextLine();
                            vendedor.setArea(area);
                            System.out.println("Ingrese la formacion acreditada del vendedor: ");
                            var formacion = inputString.nextLine();
                            vendedor.setFormacion(formacion);
                            accion.agregar(nombreArchivo, vendedor);
                        }
                        case 8 -> { //Agregar recepcionista
                            var nombreArchivo = "Recepcionistas.txt";
                            System.out.println("Ingrese el nombre de la recepcionista: ");
                            var nombre = inputString.nextLine();
                            recepcionista.setNombre(nombre);
                            System.out.println("Ingrese el apellido de la recepcionista: ");
                            var apellido = inputString.nextLine();
                            recepcionista.setApellido(apellido);
                            System.out.println("Ingrese el DNI de la recepcionista: ");
                            var dni = input.nextInt();
                            recepcionista.setDni(dni);
                            System.out.println("Ingrese la edad de la recepcionista: ");
                            var edad = input.nextInt();
                            recepcionista.setEdad(edad);
                            System.out.println("Ingrese la formacion de la recepcionista: ");
                            var formacion = inputString.nextLine();
                            recepcionista.setFormacion(formacion);
                            accion.agregar(nombreArchivo, recepcionista);
                        }
                        case 9 -> { //Agregar mantenimiento
                            var nombreArchivo = "Mantenimiento.txt";
                            System.out.println("Ingrese el nombre del operario: ");
                            var nombre = inputString.nextLine();
                            operario.setNombre(nombre);
                            System.out.println("Ingrese el apellido del operario: ");
                            var apellido = inputString.nextLine();
                            operario.setApellido(apellido);
                            System.out.println("Ingrese el DNI del operario: ");
                            var dni = input.nextInt();
                            operario.setDni(dni);
                            System.out.println("Ingrese la edad del operario: ");
                            var edad = input.nextInt();
                            operario.setEdad(edad);
                            System.out.println("Ingrese el area de desempeño del operario: ");
                            var area = inputString.nextLine();
                            operario.setArea(area);
                            System.out.println("Ingrese la formacion del operario: ");
                            var formacion = inputString.nextLine();
                            operario.setFormacion(formacion);
                            accion.agregar(nombreArchivo, operario);
                        }
                        case 10 -> { //Agregar mecanico
                            var nombreArchivo = "Mecanicos.txt";
                            System.out.println("Ingrese el nombre del mecanico: ");
                            var nombre = inputString.nextLine();
                            mecanico.setNombre(nombre);
                            System.out.println("Ingrese el apellido del mecanico: ");
                            var apellido = inputString.nextLine();
                            mecanico.setApellido(apellido);
                            System.out.println("Ingrese el DNI del mecanico: ");
                            var dni = input.nextInt();
                            mecanico.setDni(dni);
                            System.out.println("Ingrese la edad del mecanico: ");
                            var edad = input.nextInt();
                            mecanico.setEdad(edad);
                            System.out.println("Ingrese la especialidad del mecanico: ");
                            var especialidad = inputString.nextLine();
                            mecanico.setEspecialidad(especialidad);
                            System.out.println("Ingrese la formacion acreditada por el mecanico: ");
                            var formacion = inputString.nextLine();
                            mecanico.setFormacion(formacion);
                            accion.agregar(nombreArchivo, mecanico);
                        }
                        case 11 -> { //Agregar taller
                            String nombreArchivo = "Taller.txt";
                            System.out.println("Ingrese la especialidad del taller: ");
                            var especialidad = inputString.nextLine();
                            taller.setEspecialidad(especialidad);
                            System.out.println("Ingrese la ciudad donde se ubica el taller: ");
                            var ciudad = inputString.nextLine();
                            taller.setCiudad(ciudad);
                            accion.agregar(nombreArchivo, taller);
                        }
                        default -> {
                            System.out.println("La opcion ingresada no existe, ingrese una opcion valida!");
                        }
                    }
                }
                case 3 -> { //Vender vehiculo
                    System.out.println("A continuacion se solicitan los datos del vehiculo que desea adquirir: ");
                    System.out.println("Ingrese el tipo de vehiculo (auto, camioneta, moto, camion): ");
                    var tipoVehiculo = inputString.nextLine();
                    modelo.setTipoVehiculo(tipoVehiculo);
                    System.out.println("Ingrese la denominacion del modelo: ");
                    var denominacionModelo = inputString.nextLine();
                    modelo.setDenominacion(denominacionModelo);
                    accion.venderVehiculo(tipoVehiculo, denominacionModelo);
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                    opcion = 0;
                    System.out.println("""
                                       ingrese el archivo a listar:
                                       1  - Marcas.txt
                                       2  - Modelos.txt
                                       3  - Caracteristicas.txt
                                       4  - Distribuidores.txt
                                       5  - Agencias.txt
                                       6  - Gerentes.txt
                                       7  - Vendedor.txt
                                       8  - Mecanico.txt
                                       9  - Recepcionista.txt
                                       10 - Taller.txt
                                       11 - Mantenimiento.txt
                                       """);
                    opcion = input.nextInt();
                    switch (opcion) {
                        case 1 ->
                            accion.listarArchivo(ARCHIVO_MARCAS, marca);
                        case 2 ->
                            accion.listarArchivo(ARCHIVO_MODELOS, modelo);
                        case 3 ->
                            accion.listarArchivo(ARCHIVO_CARACTERISTICA_TEC, caracteristicas);
                        case 4 ->
                            accion.listarArchivo(ARCHIVO_DISTRIBUIDORES, distribuidor);
                        case 5 ->
                            accion.listarArchivo(ARCHIVO_AGENCIAS, agencia);
                        case 6 ->
                            accion.listarArchivo(ARCHIVO_GERENTES, gerente);
                        case 7 ->
                            accion.listarArchivo(ARCHIVO_VENDEDORES, vendedor);
                        case 8 ->
                            accion.listarArchivo(ARCHIVO_MECANICOS, mecanico);
                        case 9 ->
                            accion.listarArchivo(ARCHIVO_RECEPCIONISTA, recepcionista);
                        case 10 ->
                            accion.listarArchivo(ARCHIVO_TALLER, taller);
                        case 11 ->
                            accion.listarArchivo(ARCHIVO_MANTENIMIENTO, operario);
                    }
                }
                case 7 -> { //Buscar
                    opcion = 0;
                    System.out.println("""
                                       Seleccione lo que desea buscar:
                                       1 - Buscar Marca
                                       2 - Buscar Modelo
                                       3 - Buscar Caracteristicas Tecnicas de un modelo
                                       4 - Buscar Distribuidor
                                       5 - Buscar Agencia
                                       6 - Buscar Gerente
                                       7 - Buscar Vendedor
                                       8 - Buscar Mecanico
                                       9 - Buscar Recepcionista
                                      10 - Buscar Taller
                                      11 - Buscar Operario de Mantenimiento 
                                       """);
                    opcion = input.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Ingrese la marca a buscar: ");
                            var nombre = inputString.nextLine();
                            marca.setNombre(nombre);
                            System.out.println(datos.buscar(ARCHIVO_MARCAS, marca));
                            break;
                        }
                        case 2 -> {
                            System.out.println("Ingrese la denominacion; ");
                            var denominacion = inputString.nextLine();
                            modelo.setDenominacion(denominacion);
                            System.out.println(datos.buscar(ARCHIVO_MECANICOS, modelo));
                            break;
                        }
                        case 3 -> {
                            System.out.println("Ingrese la deniminacion del modelo del cual desea saber las caracteristicas: ");
                            var modeloDenominacion = inputString.nextLine();
                            caracteristicas.setModeloDenominacion(modeloDenominacion);
                            System.out.println(datos.buscar(ARCHIVO_CARACTERISTICA_TEC, caracteristicas));
                            break;
                        }
                        case 4 -> {
                            System.out.println("Ingrese el nombre del distribuidor: ");
                            var nombreDistribuidor = inputString.nextLine();
                            distribuidor.setNombreDistribuidor(nombreDistribuidor);
                            System.out.println(datos.buscar(ARCHIVO_DISTRIBUIDORES, distribuidor));
                            break;
                        }
                        case 5 -> {
                            System.out.println("Ingrese el nombre de la agencia: ");
                            var nombreAgencia = inputString.nextLine();
                            agencia.setNombreAgencia(nombreAgencia);
                            System.out.println(datos.buscar(ARCHIVO_AGENCIAS, agencia));
                            break;
                        }
                        case 6 -> {
                            System.out.println("Ingrese el nombre del gerente: ");
                            var nombre = inputString.nextLine();
                            gerente.setNombre(nombre);
                            System.out.println("Ingrese el apellido del gerente: ");
                            var apellido = inputString.nextLine();
                            gerente.setApellido(apellido);
                            System.out.println(datos.buscar(ARCHIVO_GERENTES, gerente));
                            break;
                        }
                        case 7 -> {
                            System.out.println("Ingrese el nombre del vendedor: ");
                            var nombre = inputString.nextLine();
                            vendedor.setNombre(nombre);
                            System.out.println("Ingrese el apellido del vendedor: ");
                            var apellido = inputString.nextLine();
                            vendedor.setApellido(apellido);
                            System.out.println(datos.buscar(ARCHIVO_VENDEDORES, vendedor));
                            break;
                        }
                        case 8 -> {
                            System.out.println("Ingrese el nombre de la recepcionista: ");
                            var nombre = inputString.nextLine();
                            recepcionista.setNombre(nombre);
                            System.out.println("Ingrese el apellido de la recepcionista: ");
                            var apellido = inputString.nextLine();
                            recepcionista.setApellido(apellido);
                            System.out.println(datos.buscar(ARCHIVO_RECEPCIONISTA, recepcionista));
                            break;
                        }
                        case 9 -> {
                            System.out.println("Ingrese el nombre del operario de mantenimiento: ");
                            var nombre = inputString.nextLine();
                            operario.setNombre(nombre);
                            System.out.println("Ingrese el apellido del operario: ");
                            var apellido = inputString.nextLine();
                            operario.setApellido(apellido);
                            System.out.println(datos.buscar(ARCHIVO_MANTENIMIENTO, operario));
                            break;
                        }
                        case 10 -> {
                            System.out.println("Ingrese el nombre del mecanico: ");
                            var nombre = inputString.nextLine();
                            mecanico.setNombre(nombre);
                            System.out.println("Ingrese el apellido del mecanico: ");
                            var apellido = inputString.nextLine();
                            mecanico.setApellido(apellido);
                            System.out.println(datos.buscar(ARCHIVO_MECANICOS, mecanico));
                            break;
                        }
                        case 11 -> {
                            System.out.println("Ingrese la especialidad del taller: ");
                            var especialidad = inputString.nextLine();
                            taller.setEspecialidad(especialidad);
                            System.out.println(datos.buscar(ARCHIVO_TALLER, taller));
                            break;
                        }
                        default ->
                            System.out.println("La opcion ingresada no existe!, ingrese una opcion valida");
                    }
                }
                case 8 -> { //Borrar
                    opcion = 0;
                    System.out.println("""
                                       Ingrese el nombre del archivo:
                                       1 - Marcas
                                       2 - Modelos
                                       3 - Caracteristicas Tecnicas
                                       4 - Distribuidores
                                       5 - Agencias
                                       6 - Gerente
                                       7 - Vendedor
                                       8 - Mecanico
                                       9 - Recepcionista
                                      10 - Taller
                                      11 - Mantenimiento                                       
                                       """);

                    opcion = input.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            accion.borrarArchivo(ARCHIVO_MARCAS);
                            System.out.println("El archivo Marcas ha sido borrado");
                            break;
                        }
                        case 2 -> {
                            accion.borrarArchivo(ARCHIVO_MODELOS);
                            System.out.println("El archivo modelos ha sido borrado");
                            break;
                        }
                        case 3 -> {
                            accion.borrarArchivo(ARCHIVO_CARACTERISTICA_TEC);
                            System.out.println("El archivo Caracteristicas Tecnicas.txt ha sido borrado!");
                            break;
                        }
                        case 4 -> {
                            accion.borrarArchivo(ARCHIVO_DISTRIBUIDORES);
                            System.out.println("El archivo Distribuidores.txt ha sido borrado!");
                            break;
                        }
                        case 5 -> {
                            accion.borrarArchivo(ARCHIVO_AGENCIAS);
                            System.out.println("El archivo Agencias.txt ha sido borrado!");
                            break;
                        }
                        case 6 -> {
                            accion.borrarArchivo(ARCHIVO_GERENTES);
                            System.out.println("El archivo Gerentes.txt ha sido borrado!");
                            break;
                        }
                        case 7 -> {
                            accion.borrarArchivo(ARCHIVO_VENDEDORES);
                            System.out.println("El archivo Vendedores.txt ha sido borrado!");
                            break;
                        }
                        case 8 -> {
                            accion.borrarArchivo(ARCHIVO_RECEPCIONISTA);
                            System.out.println("El archivo Recepcionistas.txt ha sido borrado!");
                            break;
                        }
                        case 9 -> {
                            accion.borrarArchivo(ARCHIVO_MANTENIMIENTO);
                            System.out.println("El archivo Mantenimiento.txt ha sido borrado!");
                            break;
                        }
                        case 10 -> {
                            accion.borrarArchivo(ARCHIVO_MECANICOS);
                            System.out.println("El archivo Mecanicos.txt ha sido borrado!");
                            break;
                        }
                        case 11 -> {
                            accion.borrarArchivo(ARCHIVO_TALLER);
                            System.out.println("El archivo taller.txt ha sido borrado!");
                            break;
                        }
                        default ->
                            System.out.println("La opcion ingresada no existe!, ingrese una opcion valida");
                    }
                }
                case 9 -> { //Test control stock
                    System.out.println("Control de stock");
                    System.out.println("Ingrese el modelo: ");
                    var denominacionModelo = inputString.nextLine();
                    modelo.setDenominacion(denominacionModelo);
                    datos.stockModelo(ARCHIVO_MODELOS, denominacionModelo);
                }
                case 10 -> { //Test Buscar por indice
                    System.out.println("Ingrese el nombre del modelo a indexar: ");
                    var modeloDenominacion = inputString.nextLine();
                    modelo.setDenominacion(modeloDenominacion);
                    System.out.println(datos.buscarIndice(ARCHIVO_MODELOS, modelo, modeloDenominacion));
                }
                case 11 -> {
                }
                case 12 -> { // Test Solicitar / Recibir unidades
                    System.out.println("Ingrese el nombre del modelo del cual se necesita stock: ");
                    var denominacionModelo = inputString.nextLine();
                    System.out.println("Ingrese la cantidad de unidades solicitadas a incorporar en stock: ");
                    var unidadesRecibidas = input.nextInt();
                    accion.enviarRecibirPedidoDeFabricante(ARCHIVO_MODELOS, modelo, denominacionModelo, unidadesRecibidas);
                }
                case 13 -> { //Contratar o despedir empleado
                    opcion = 0;
                    System.out.println("""
                                        Ingrese el nombre del archivo donde desea agregar o despedir empleado:
                                        1 - Archivo Gerentes.txt
                                        2 - Archivo Vendedores.txt
                                        3 - Archivo Recepcionistas.txt
                                        4 - Archivo Mantenimiento.txt
                                        5 - Archivo Mecanicos.txt
                                        6 - Archivo Taller.txt
                                        """);

                    opcion = input.nextInt();

                    switch (opcion) {

                        case 1 -> {

                        }

                        case 2 -> {

                        }

                        case 3 -> {

                        }

                        case 4 -> {

                        }

                        case 5 -> {

                        }

                        case 6 -> {

                        }

                        default ->
                            System.out.println("La opcion seleccionada no existe ingrese una opcion valida!");
                    }
                }

                case 0 -> { //Salir
                    System.out.println("Hasta pronto!");
                    System.exit(0);
                }

                default -> { //Como evitar la excepcion si no ingreso un valor y solo ingreso enter?
                    System.out.println("La opcion ingresada no existe! , ingrese una opcion valida! ");
                }
            }
        } while (opcion != 0);
    }
}
