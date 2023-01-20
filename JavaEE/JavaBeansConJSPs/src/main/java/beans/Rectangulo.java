package beans;

//Los JSPs poueden acceder a los Java Beans.
//REGLAS BASICAS DE UN JAVA BEANS
//Debe tener un costructor vacio.
//Todos los atributos deben ser privados
//Se deben generar los metodos getter y setter para todos los atributos
//Un jsp debe utilizar el nombre de la propiedad para acceder o modificar el atributo de un Java Bean
//Indirectqmente el jsp manda a llamar al maetodo get o set asociado con la propiedad indicada en el jsp.

//PROPIEDADES DE JAVA BEANS.
//NOMBRE PROPIEDAD              NOMBRE DE LOS METODOS               CODIGO EN EL JSP (se utiliza una accion)
//nombreUsuario                 getNombreUsuario                    <jsp:getProperty...property="nombreUsuario" />
//                              setNombreUsuario                    <jsp:setProperty...property="nombreUsuario" />
//eliminado                     isEliminado (formato boolean)       <jsp:getProperty...property="eliminado" /> 
//                              setEliminado                        <jsp:setProperty...property="eliminado" />

//ALCANCE DE UNA VARIABLE EN UN JSP (SCOPE) (El alcance es la duracion o el tiempo que esta activa para su uso en un app web)
//page: Es el alcance mas basico y unicamente lo utilizamos dentro del jsp y solo perdura el tiempo en que se traduce un jsp a un servlet.
//request: Esta variable perdura hasta que el usuario haga una peticion hacia el servidor, luego se destruye.
//session: Esta variable perdura en peticiones sucesivas y se mantiene vigente mientras dure la sesion o por defecto durante 30 minutuos de inactividad o en el tiempo que se configure.
//application: Esta variable perdura durante todo el tiempo que este arriba la app o hasta que se detenga el servidor web o hagamos un undeploy de la app. Este el mayor alcance de una variable.

//USO BASICO DE LOS JAVA BEANS
//jsp:useBean : Permite acceder a un bean en un alcace especificado, sin no lo especificamos el alcance por default es page
//jsp:useBean id="nombreBean" class="paquete.NombreClase" />

//jsp:setProperty : Permite modificar una o varias propiedades de un bean especificado
//<jsp:setProperty name="nombreBean" property="nombreUsuario" value="Juan" />
//<jsp:getProperty name="nombreBean" property="nombreUsuario" value="nombreUsuario" />


public class Rectangulo {
    private int base;
    private int altura;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
            
    public int getArea(){
        return this.base * this.altura;
    }
}
