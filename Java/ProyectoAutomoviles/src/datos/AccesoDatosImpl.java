package datos;

import dominio.*;
import excepciones.AccesoDatosEx;
import java.io.*;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Fabricio
 */
public class AccesoDatosImpl implements IAccesoDatos {

    public static final String ARCHIVO_MARCAS = "Marcas.txt";
    public static final String ARCHIVO_MODELOS = "Modelos.txt";
    public static final String ARCHIVO_CARACTERISTICA_TEC = "Caracteristicas Tecnicas.txt";
    public static final String ARCHIVO_DISTRIBUIDORES = "Distribuidores.txt";
    public static final String ARCHIVO_AGENCIAS = "Agencias.txt";
    public static final String ARCHIVO_GERENTES = "Gerentes.txt";
    public static final String ARCHIVO_VENDEDORES = "Vendedores.txt";
    public static final String ARCHIVO_MECANICOS = "Mecanicos.txt";
    public static final String ARCHIVO_RECEPCIONISTA = "Recepcionista.txt";
    public static final String ARCHIVO_TALLER = "Taller.txt";
    public static final String ARCHIVO_MANTENIMIENTO = "Mantenimiento.txt";

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (nombreArchivo.equalsIgnoreCase(ARCHIVO_MARCAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MODELOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_CARACTERISTICA_TEC)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_DISTRIBUIDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_AGENCIAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_GERENTES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_VENDEDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MECANICOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_RECEPCIONISTA)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_TALLER)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MANTENIMIENTO)){
            try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo " + nombreArchivo + "!" + ex.getMessage());
            }
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Object object, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (nombreArchivo.equalsIgnoreCase(ARCHIVO_MARCAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MODELOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_CARACTERISTICA_TEC)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_DISTRIBUIDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_AGENCIAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_GERENTES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_VENDEDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MECANICOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_RECEPCIONISTA)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_TALLER)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MANTENIMIENTO)){
            try {
                PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                switch (nombreArchivo) {
                    case ARCHIVO_MARCAS: {
                        Marca marca = (Marca) object;
                        write.println(marca.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_MODELOS: {
                        Modelo modelo = (Modelo) object;
                        write.println(modelo.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_CARACTERISTICA_TEC: {
                        CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                        write.println(caracteristica.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_DISTRIBUIDORES: {
                        Distribuidor distribuidor = (Distribuidor) object;
                        write.println(distribuidor.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_AGENCIAS: {
                        Agencia agencia = (Agencia) object;
                        write.println(agencia.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_GERENTES: {
                        Gerente gerente = (Gerente) object;
                        write.println(gerente.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_VENDEDORES: {
                        Vendedor vendedor = (Vendedor) object;
                        write.println(vendedor.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_MECANICOS: {
                        Mecanico mecanico = (Mecanico) object;
                        write.println(mecanico.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_RECEPCIONISTA: {
                        Recepcionista recepcionista = (Recepcionista) object;
                        write.println(recepcionista.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_TALLER: {
                        Taller taller = (Taller) object;
                        write.println(taller.toString());
                        write.close();
                        break;
                    }
                    case ARCHIVO_MANTENIMIENTO: {
                        Mantenimiento mantenimiento = (Mantenimiento) object;
                        write.println(mantenimiento.toString());
                        write.close();
                        break;
                    }
                    default: {
                        System.out.println("La opcion ingresada no existe, ingrese una opcion valida!");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al excribir en el archivo" + nombreArchivo + "!" + ex.getMessage());
            }
        }
    }

    @Override
    public void modificarDatoEnArchivo(String nombreArchivo, List object) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (nombreArchivo.equalsIgnoreCase(ARCHIVO_MARCAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MODELOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_CARACTERISTICA_TEC)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_DISTRIBUIDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_AGENCIAS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_GERENTES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_VENDEDORES)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MECANICOS)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_RECEPCIONISTA)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_TALLER)
                || nombreArchivo.equalsIgnoreCase(ARCHIVO_MANTENIMIENTO)) {
            this.borrar(nombreArchivo);
            this.crear(nombreArchivo);
            for (int i = 0; i < object.size(); i++) {
                this.escribir(object.get(i), nombreArchivo);
            }
        }
    }

    @Override
    public List listar(Object object, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        BufferedReader leer;
        try {
            leer = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
        }
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                List<Marca> marcas = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) { // Marca: | Nombre: Ferrari | Origen: Italia | Logo: Cavallino rampante -
                        linea = linea.substring(17);
                        String nombre = linea.substring(0, linea.indexOf(" | "));
                        String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo:"));
                        String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                        Marca marca = new Marca(nombre, origen, logo);
                        marcas.add(marca);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return marcas;
            }
            case ARCHIVO_MODELOS -> {
                List<Modelo> modelos = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) { // Marca: Lamborghini | Denominacion: Aventador | Tipo de Vehiculo: auto | Cantidad: 100 -
                        linea = linea.substring(7);
                        String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Tipo de Vehiculo:"));
                        String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo modelo = new Modelo(nombreMarca, denominacion, tipoVehiculo, Integer.valueOf(cantidad));
                        modelos.add(modelo);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return modelos;
            }
            case ARCHIVO_CARACTERISTICA_TEC -> {
                List<CaracteristicasTec> caracteristicas = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        //Modelo | Denominacion: Testarossa | TipoMotor: Naftero central | Cilindros: 12 boxer | cilindrada: 4997 cm3 | HP: 412 | Caja: Manual de 5 velocidades | Carroceria: Berlineta coupe | id: null -
                        linea = linea.substring(23);
                        String modeloDenominacion = linea.substring(0, linea.indexOf(" | "));
                        String tipoMotor = linea.substring(linea.indexOf("TipoMotor:") + 11, linea.indexOf(" | Cilindros:"));
                        String cilindros = linea.substring(linea.indexOf("Cilindros:") + 11, linea.indexOf(" | Cilindrada:"));
                        String cilindrada = linea.substring(linea.indexOf("Cilindrada:") + 12, linea.indexOf(" | HP:"));
                        String hp = linea.substring(linea.indexOf("HP:") + 4, linea.indexOf(" | Caja:"));
                        String caja = linea.substring(linea.indexOf("Caja:") + 6, linea.indexOf(" | Equipamiento:"));
                        String equipamiento = linea.substring(linea.indexOf("Equipamiento:") + 14, linea.indexOf(" | Carroceria:"));
                        String carroceria = linea.substring(linea.indexOf("Carroceria:") + 12, linea.indexOf(" | id:"));
                        String id = linea.substring(linea.indexOf("id:") + 4, linea.indexOf(" -"));
                        CaracteristicasTec caracteristica = new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, cilindrada, Integer.valueOf(hp), caja, equipamiento, carroceria, Integer.valueOf(id));
                        caracteristicas.add(caracteristica);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return caracteristicas;
            }
            case ARCHIVO_DISTRIBUIDORES -> {
                List<Distribuidor> distribuidores = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(23);
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" | Marca Distribuida:"));
                        String marcaDistribuida = linea.substring(linea.indexOf("Marca Distribuida:") + 19, linea.indexOf(" -"));
                        Distribuidor distribuidor = new Distribuidor(nombreDistribuidor, pais, marcaDistribuida);
                        distribuidores.add(distribuidor);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return distribuidores;
            }
            case ARCHIVO_AGENCIAS -> {
                List<Agencia> agencias = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) { // Agencia | Nombre: Miami motors | Ciudad: Miami | Marca Comercializada: Ferrari -
                        linea = linea.substring(18);
                        String nombreAgencia = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" | Marca Comercializada:"));
                        String marcaComerzializada = linea.substring(linea.indexOf("Marca Comercializada:") + 22, linea.indexOf(" -"));
                        Agencia agencia = new Agencia(nombreAgencia, ciudad, marcaComerzializada);
                        agencias.add(agencia);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return agencias;
            }
            case ARCHIVO_GERENTES -> { // Gerente | Area: Marketing | Estudios: Lic Marketing | Nombre Agencia: Miami motors | Nombre: Juan | Apellido: Gabriel | DNI: 32323232 | Edad: 36 - 
                List<Gerente> gerentes = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(16);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String estudios = linea.substring(linea.indexOf("Estudios:") + 10, linea.indexOf(" | Nombre Agencia:"));
                        String agencia = linea.substring(linea.indexOf("Nombre Agencia:") + 16, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Gerente gerente = new Gerente(area, estudios, agencia, nombre, apellido, Integer.parseInt(dni), Integer.parseInt(edad));
                        gerentes.add(gerente);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return gerentes;
            }
            case ARCHIVO_VENDEDORES -> {
                List<Vendedor> vendedores = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(17);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Vendedor vendedor = new Vendedor(nombre, apellido, Integer.parseInt(dni), Integer.parseInt(edad), area, formacion);
                        vendedores.add(vendedor);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return vendedores;
            }
            case ARCHIVO_MECANICOS -> {
                List<Mecanico> mecanicos = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(25);
                        String especialidad = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Mecanico mecanico = new Mecanico(nombre, apellido, Integer.parseInt(dni), Integer.parseInt(edad), especialidad, formacion);
                        mecanicos.add(mecanico);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return mecanicos;
            }
            case ARCHIVO_RECEPCIONISTA -> { //Recepcionista | Formacion: RRPP | Nombre: Marina | Apellido: Dow | DNI: 23232323 | Edad: 19 -
                List<Recepcionista> recepcionistas = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(27);
                        String formacion = linea.substring(0, linea.indexOf(" | "));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Recepcionista recepcionista = new Recepcionista(formacion, nombre, apellido, Integer.valueOf(dni), Integer.valueOf(edad));
                        recepcionistas.add(recepcionista);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return recepcionistas;
            }
            case ARCHIVO_TALLER -> { //Taller | Especialidad: Mecanica general | Ciudad: Miami -
                List<Taller> talleres = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(23);
                        String especialidad = linea.substring(0, linea.indexOf(" | "));
                        String Ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" -"));
                        Taller taller = new Taller(especialidad, Ciudad);
                        talleres.add(taller);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return talleres;
            }
            case ARCHIVO_MANTENIMIENTO -> { //Mantenimiento | Area: Taller | Formacion: Secundaria | Nombre: Juan | Apellido: Perez | DNI: 32323232 | Edad: 21 -
                List<Mantenimiento> operarios = new ArrayList<>();
                try {
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(22);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Mantenimiento operario = new Mantenimiento(nombre, apellido, Integer.parseInt(dni),
                                Integer.parseInt(edad), area, formacion);
                        operarios.add(operario);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar archivo " + nombreArchivo + "!" + ex.getMessage());
                }
                return operarios;
            }
        }
        return (List) object;
    }

    @Override
    public Object buscar(String nombreArchivo, Object object) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS: {
                Marca marca = (Marca) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(16);
                        String nombre = linea.substring(0, linea.indexOf(" | "));
                        String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo"));
                        String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                        Marca datos = new Marca(nombre, origen, logo);
                        if (marca.getNombre() != null && marca.getNombre().equalsIgnoreCase(datos.getNombre())) {
                            object = "La marca " + marca.getNombre() + " se encuentra en el indice "
                                    + indice + " es de origen " + datos.getOrigen() + " y el logo es " + datos.getLogo();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (marca.getNombre() == null || encontrado == false) {
                        System.out.println("La marca indicada no esta registrada en este archivo o no existe!, "
                                + "Si desea buscar otra marca inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_MODELOS: {
                Modelo modelo = (Modelo) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(7);
                        String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Tipo de Vehiculo:"));
                        String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo datos = new Modelo(nombreMarca, denominacion, tipoVehiculo, Integer.parseInt(cantidad));
                        if (modelo.getDenominacion() != null && modelo.getDenominacion().equalsIgnoreCase(datos.getDenominacion())) {
                            object = "Se ha localizado el modelo " + datos.getDenominacion() + " en el indice "
                                    + indice + " y hay en stock " + datos.getCantidad() + " unidades";
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (modelo.getDenominacion() == null || encontrado == false) {
                        System.out.println("El modelo indicado no esta registrada en este achivo o no existe!, "
                                + "Si desea buscar otro modelo inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_CARACTERISTICA_TEC: {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(8);
                        String modeloDenominacion = linea.substring(0, linea.indexOf(" "));
                        String tipoMotor = linea.substring(linea.indexOf("TipoMotor:") + 11, linea.indexOf(" | Cilindros:"));
                        String cilindros = linea.substring(linea.indexOf("Cilindros:") + 11, linea.indexOf(" | Cilindrada:"));
                        String cilindrada = linea.substring(linea.indexOf("Cilindrada:") + 12, linea.indexOf(" | HP:"));
                        String HP = linea.substring(linea.indexOf("HP:") + 4, linea.indexOf(" | Caja:"));
                        String caja = linea.substring(linea.indexOf("Caja:") + 6, linea.indexOf(" | Equipamiento:"));
                        String equipamiento = linea.substring(linea.indexOf("Equipamiento:") + 14, linea.indexOf(" | Carroceria:"));
                        String carroceria = linea.substring(linea.indexOf("Carroceria:") + 12, linea.indexOf(" | id:"));
                        String id = linea.substring(linea.indexOf("id:") + 4, linea.indexOf(" -"));
                        CaracteristicasTec detalle = new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, cilindrada, Integer.parseInt(HP),
                                caja, equipamiento, carroceria, Integer.parseInt(id));
                        if (caracteristica.getModeloDenominacion() != null
                                && caracteristica.getModeloDenominacion().equalsIgnoreCase(detalle.getModeloDenominacion())) {
                            object = "El modelo " + caracteristica.getModeloDenominacion() + " que se encuentra en el indice "
                                    + indice + " tiene las siguientes caracteristicas: "
                                    + detalle.getTipoMotor() + " | "
                                    + detalle.getCilindros() + " | "
                                    + detalle.getCilindrada() + " | "
                                    + detalle.getHP() + " | "
                                    + detalle.getCaja() + " | "
                                    + detalle.getEquipamiento() + " | "
                                    + detalle.getCarroceria() + " | "
                                    + detalle.getId();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (caracteristica.getModeloDenominacion() == null || encontrado == false) {
                        System.out.println("El modelo indicado esta registrado en este archivo o no existe!, "
                                + "Si desea buscar otro modelo ingreselo nuevamente");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo caracteristicas tecnicas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo caracteristicas tecnicas!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_DISTRIBUIDORES: {
                Distribuidor distribuidor = (Distribuidor) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(23);
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" | Marca Distribuida:"));
                        String marcaDistribuida = linea.substring(linea.indexOf("Marca Distribuida:") + 19, linea.indexOf(" -"));
                        Distribuidor datos = new Distribuidor(nombreDistribuidor, pais, marcaDistribuida);
                        if (distribuidor.getNombreDistribuidor() != null
                                && distribuidor.getNombreDistribuidor().equalsIgnoreCase(datos.getNombreDistribuidor())) {
                            object = "El distribuidor " + distribuidor.getNombreDistribuidor() + " se encuentra en el indice "
                                    + indice + " y se localiza en " + datos.getPais();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (distribuidor.getNombreDistribuidor() == null || encontrado == false) {
                        System.out.println("El distribuidor indicado no esta registrado en este archivo o no existe!, "
                                + "Si desea buscar otro distribuidor inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo distribuidores!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo distribuidores!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_AGENCIAS: {
                Agencia agencia = (Agencia) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(18);
                        String nombreAgencia = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" | Marca:"));
                        String marcaComercializada = linea.substring(linea.indexOf("Marca:") + 7, linea.indexOf(" -"));
                        Agencia datos = new Agencia(nombreAgencia, ciudad, marcaComercializada);
                        if (agencia.getNombreAgencia() != null && agencia.getNombreAgencia().equalsIgnoreCase(datos.getNombreAgencia())) {
                            object = "La agencia " + datos.getNombreAgencia() + " que se encuentra en el indice "
                                    + indice + ", se localiza en la ciudad de " + datos.getCiudad()
                                    + " y comercializa la marca " + datos.getMarcaComercializada();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (agencia.getNombreAgencia() == null || encontrado == false) {
                        System.out.println("La agencia indicada no esta registrada en este archivo o no existe!, "
                                + "Si desea buscar otra agencia inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo agencias!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo agencias!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_GERENTES: {
                Gerente gerente = (Gerente) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(16);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String estudios = linea.substring(linea.indexOf("Estudios:") + 10, linea.indexOf(" | Agencia:"));
                        String agencia = linea.substring(linea.indexOf("Agencia:") + 9, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Gerente datos = new Gerente(area, estudios, agencia, nombre, apellido, Integer.parseInt(dni),
                                Integer.parseInt(edad));
                        if (gerente.getNombre() != null
                                && gerente.getApellido() != null
                                && gerente.getNombre().equalsIgnoreCase(datos.getNombre())
                                && gerente.getApellido().equalsIgnoreCase(datos.getApellido())) {
                            object = "El gerente " + datos.getNombre() + " " + datos.getApellido() + " que se encuentra en el indice "
                                    + indice + ", se desempeña en el area " + datos.getArea()
                                    + " y su formacion es " + datos.getEstudios();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (gerente.getNombre() == null || gerente.getApellido() == null || encontrado == false) {
                        System.out.println("El gerente requerido no esta registrado en este archivo o no esta entre el personal de la firma!, "
                                + "Si desea buscar otra agencia inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo gerentes!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo gerentes!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_VENDEDORES: {
                Vendedor vendedor = (Vendedor) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(17);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Vendedor datos = new Vendedor(nombre, apellido, Integer.parseInt(dni), Integer.parseInt(edad),
                                area, formacion);
                        if (vendedor.getNombre() != null && vendedor.getApellido() != null
                                && vendedor.getNombre().equalsIgnoreCase(datos.getNombre())
                                && vendedor.getApellido().equalsIgnoreCase(datos.getApellido())) {
                            object = "El vendedor " + datos.getNombre() + " " + datos.getApellido() + " que se encuentra en el indice "
                                    + indice + ", y su area de desempeño es " + datos.getArea();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (vendedor.getNombre() == null || vendedor.getApellido() == null || encontrado == false) {
                        System.out.println("El vendedor requerido no esta registrado en este archivo o no pertenece a la plantilla de empleados!, "
                                + "Si desea buscar otro taller inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo vendedores!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo vendedores!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_RECEPCIONISTA: {
                Recepcionista recepcionista = (Recepcionista) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(27);
                        String formacion = linea.substring(0, linea.indexOf(" | "));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Recepcionista datos = new Recepcionista(formacion, nombre, apellido, Integer.parseInt(dni),
                                Integer.parseInt(edad));
                        if (recepcionista.getNombre() != null && recepcionista.getApellido() != null
                                && recepcionista.getNombre().equalsIgnoreCase(datos.getNombre())
                                && recepcionista.getApellido().equalsIgnoreCase(datos.getApellido())) {
                            object = "La recepcionista " + datos.getNombre() + " " + datos.getApellido() + " se encuentra en el indice "
                                    + indice + " y su formacion es " + datos.getFormacion();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (recepcionista.getNombre() == null || recepcionista.getApellido() == null || encontrado == false) {
                        System.out.println("La recepcionista requerida no esta registrada en este archivo o no pertenece a la plantilla de empleados!, "
                                + "Si desea buscar otro taller inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo recepcionista!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo recepcionista!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_MECANICOS: {
                Mecanico mecanico = (Mecanico) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(25);
                        String especialidad = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Mecanico datos = new Mecanico(nombre, apellido, Integer.parseInt(dni),
                                Integer.parseInt(edad), especialidad, formacion);
                        if (mecanico.getNombre() != null && mecanico.getApellido() != null
                                && mecanico.getNombre().equalsIgnoreCase(datos.getNombre())
                                && mecanico.getApellido().equalsIgnoreCase(datos.getApellido())) {
                            object = "El mecanico " + datos.getNombre() + " " + datos.getApellido() + " que se encuentra en el indice "
                                    + indice + " se especializa en " + datos.getEspecialidad() + " y esta formado como " + datos.getFormacion();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (mecanico.getNombre() == null || mecanico.getApellido() == null || encontrado == false) {
                        System.out.println("El mecanico requerido no esta registrado en este archivo o no pertenece a la plantilla de empleados!,"
                                + "Si desea buscar otro taller inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo mecanicos!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo mecanicos!" + ex.getMessage());
                }
                return object;
            }

            case ARCHIVO_TALLER: {
                Taller taller = (Taller) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(23);
                        String especialidad = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" -"));
                        Taller datos = new Taller(especialidad, ciudad);
                        if (taller.getEspecialidad() != null && taller.getEspecialidad().equalsIgnoreCase(datos.getEspecialidad())) {
                            object = "El taller de " + datos.getEspecialidad() + " que se encuentra en el indice "
                                    + indice + ", se localiza en la ciudad de " + datos.getCiudad();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (taller.getEspecialidad() == null || encontrado == false) {
                        System.out.println("El taller indicado no esta registrada en este archivo o no existe!, "
                                + "Si desea buscar otro taller inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo taller!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo taller!" + ex.getMessage());
                }
                return object;
            }
            case ARCHIVO_MANTENIMIENTO: {
                Mantenimiento operario = (Mantenimiento) object;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    int indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(22);
                        String area = linea.substring(0, linea.indexOf(" | "));
                        String formacion = linea.substring(linea.indexOf("Formacion:") + 11, linea.indexOf(" | Nombre:"));
                        String nombre = linea.substring(linea.indexOf("Nombre:") + 8, linea.indexOf(" | Apellido:"));
                        String apellido = linea.substring(linea.indexOf("Apellido:") + 10, linea.indexOf(" | DNI:"));
                        String dni = linea.substring(linea.indexOf("DNI:") + 5, linea.indexOf(" | Edad:"));
                        String edad = linea.substring(linea.indexOf("Edad:") + 6, linea.indexOf(" -"));
                        Mantenimiento datos = new Mantenimiento(nombre, apellido, Integer.parseInt(dni),
                                Integer.parseInt(edad), area, formacion);
                        if (operario.getNombre() != null && operario.getApellido() != null
                                && operario.getNombre().equalsIgnoreCase(datos.getNombre())
                                && operario.getApellido().equalsIgnoreCase(datos.getApellido())) {
                            object = "El operario " + datos.getNombre() + " " + datos.getApellido() + " que se encuentra en el indice "
                                    + indice + " esta afectado al area " + datos.getArea();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (operario.getNombre() == null || operario.getApellido() == null || encontrado == false) {
                        System.out.println("El operario requerido no esta registrado en este archivo o no pertenece a la plantilla de empleados!,"
                                + "Si desea buscar otro taller inicie nuevamente la busqueda");
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo operarios!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo operarios!" + ex.getMessage());
                }
                return object;
            }
            default: {
                System.out.println("La opcion ingresada no exitste, ingrese una opcion valida!");
            }
        }
        return object;
    }

    @Override
    public int buscarIndice(String nombreArchivo, Object object, String modeloDenominacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer stockModelo(String nombreArchivo, String denominacionModelo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        int stock = 0;
        boolean existencia = false;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while (linea != null) {
                linea = linea.substring(7);
                String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Tipo de Vehiculo:"));
                String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Cantidad:"));
                String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                Modelo datos = new Modelo(nombreMarca, denominacion, tipoVehiculo, Integer.parseInt(cantidad));
                if (denominacionModelo != null && denominacionModelo.equalsIgnoreCase(datos.getDenominacion())
                        && datos.getCantidad() > 0) {
                    stock = datos.getCantidad();
                    existencia = true;
                    System.out.println("Del modelo " + denominacionModelo + " hay en existencia " + datos.getCantidad() + " unidades.");
                    break;
                } else if (denominacionModelo != null && denominacionModelo.equalsIgnoreCase(datos.getDenominacion())
                        && datos.getCantidad() == 0) {
                    existencia = true;
                    System.out.println("Del modelo " + denominacionModelo + " hay en existencia " + datos.getCantidad() + " unidades.");
                }
                linea = leer.readLine();
            }
            if (existencia == false) {
                System.out.println("El modelo no se encuentra en la lista!");
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        }
        return stock;
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
