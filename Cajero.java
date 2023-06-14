import java.util.ArrayList;

/* Esta clase contendrá el menú completo del cajero automático y las declaraciones, inicializaciones e instanciaciones necesarias */

public class Cajero {
    public static void menu() {

        // Declaracion de variables
        String usuario, user, contraseña, password, rta, newC, alias, nServ;
        int laopcion, intentos, contacto, cbu, servicio, pin, pinsec;
        double monto, saldo, maxi;
        boolean irMenu, salida, continuar;

        // Inicializacion de variables
        user = "juanpep";
        password = "javajava";
        intentos = 2;
        saldo = 50000;
        monto = 0;
        maxi = 25000;
        pin = 4567;

        // Declaracion del objeto AL
        ArrayList<String> contactos;
        ArrayList<String> servicios;

        // Instanciación del objeto AL
        contactos = new ArrayList<String>();
        servicios = new ArrayList<String>();

        // Carga AL
        contactos.add("*** Lista de Contactos frecuentes ***");
        contactos.add("Patricia Sosa");
        contactos.add("Carlos Artola");
        contactos.add("Joaquín Pereyra");
        contactos.add("Rodolfo Ledesma");
        contactos.add("Lidia Barrientos");

        servicios.add("*** Servicios ***");
        servicios.add("Aysa");
        servicios.add("Edenor");
        servicios.add("Telecentro");
        servicios.add("Metrogas");
        servicios.add("ABL");

        // Procesos
        do {
            salida = false;

            Consola.imprimir(
                    "<-------ATENCIÓN------->\nSI EL CAJERO RETUVO SU TARJETA NO ACEPTE AYUDA DE DESCONOCIDOS\nRECUERDE QUE TODAS SUS CLAVES SON PERSONALES E INTRASFERIBLES");
            Consola.imprimir("*** Bienvenido ***\nPor favor, ingrese su usuario: ");
            usuario = Consola.leertxt();
            Consola.imprimir("Ingrese su contraseña: ");
            contraseña = Consola.leertxt();

            if (user.equals(usuario) && password.equals(contraseña)) {
                do {
                    irMenu = false;

                    Consola.imprimir("*** BANCO FANTASIA ***");
                    Consola.imprimir(
                            "Sr/a Cliente: Sea Bienvenido.\nPor favor, seleccione una opción\n1.Datos de la cuenta\n2.Saldo disponible\n3.Transferencias\n4.Pagos online\n5.Extracciones\n6.Salir");
                    laopcion = Consola.leernum();

                    switch (laopcion) {

                        case (1):
                            Consola.imprimir(
                                    "*** DATOS DE CUENTA ***\nCliente: Juan Pepito\nNúmero de cuenta: 13524866620\nCBU:2266784952684798524799\nAlias:pep.pep");
                            Consola.imprimir(
                                    "- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                            rta = Consola.leertxt();

                            if (rta.equalsIgnoreCase("m")) {
                                irMenu = true;
                            } else if (rta.equalsIgnoreCase("s")) {
                                irMenu = false;
                                salida = true;
                            } else {
                                Consola.imprimir("* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                irMenu = true;
                            }
                            break;

                        case (2):
                            Consola.imprimir("*** SALDO ***\nSu saldo disponible es " + saldo);
                            Consola.imprimir(
                                    "- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                            rta = Consola.leertxt();

                            if (rta.equalsIgnoreCase("m")) {
                                irMenu = true;
                            } else if (rta.equalsIgnoreCase("s")) {
                                irMenu = false;
                                salida = true;
                            } else {
                                Consola.imprimir(
                                        "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                irMenu = true;
                            }
                            break;

                        case (3):
                            do {
                                continuar = false;
                                Consola.imprimir("*** TRANSFERENCIAS ***");
                                Consola.imprimir(
                                        "<------- Para transferir a contactos frecuentes presione 1, para transferir a un nuevo contacto presione 2 ------->");
                                laopcion = Consola.leernum();

                                if (laopcion == 1) {
                                    Consola.imprimir("Aquí estan sus contactos frecuentes ");
                                    for (int i = 0; i < contactos.size(); i++) {
                                        Consola.imprimir(i + ". " + contactos.get(i));
                                    }
                                    Consola.imprimir(
                                            "Indique el número de contacto frecuente para realizar la transferencia");
                                    contacto = Consola.leernum();

                                    if (contacto <= 5){
                                    Consola.imprimir("Usted ha seleccionado a: " + contactos.get(contacto)
                                            + "\nIngrese la cantidad a transferir");
                                    monto = Consola.leerdoub();
                                    Consola.imprimir("Usted ha ingresado el siguiente monto a transferir " + monto
                                            + "\n¿Está seguro que desea realizar esta operación?(s/n)");
                                    rta = Consola.leertxt();

                                    if (saldo >= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("La transferencia ha sido realizada con éxito");
                                        saldo = saldo - monto;
                                    } else if (saldo <= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("Saldo insuficiente");
                                    } else if (rta.equalsIgnoreCase("n")) {
                                        Consola.imprimir(
                                                "* La operación ha sido cancelada *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    }
                                    }else{
                                        Consola.imprimir("*|*|*| El número de contacto frecuente no existe o no está listo para usarse |*|*|*");
                                    }

                                    Consola.imprimir(
                                            "- Para realizar otra transferencia presione 'C'\n- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                                    rta = Consola.leertxt();
                                    if (rta.equalsIgnoreCase("m")) {
                                        irMenu = true;
                                    } else if (rta.equalsIgnoreCase("s")) {
                                        irMenu = false;
                                        salida = true;
                                    } else if (rta.equalsIgnoreCase("c")) {
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                        irMenu = true;
                                    }

                                } else if (laopcion == 2) {
                                    Consola.imprimir(
                                            "Si desea transferir a un nuevo cbu marque 1, si desea transferir a un nuevo alias marque 2");
                                    laopcion = Consola.leernum();

                                    if (laopcion == 1) {
                                        Consola.imprimir("Ingrese el cbu al que desea transferir");
                                        cbu = Consola.leernum();
                                        Consola.imprimir("Usted ha ingresado el siguiente CBU " + cbu);
                                    } else if (laopcion == 2) {
                                        Consola.imprimir("Ingrese el alias al que desea transferir");
                                        alias = Consola.leertxt();
                                        Consola.imprimir("Usted ha ingresado el siguiente alias " + alias);
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    }
                                    Consola.imprimir("Ingrese la cantidad a transferir");
                                    monto = Consola.leerdoub();
                                    Consola.imprimir("Usted ha ingresado el siguiente monto a transferir " + monto
                                            + "\n¿Está seguro que desea realizar esta operación?(s/n)");
                                    rta = Consola.leertxt();

                                    if (saldo >= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("La transferencia ha sido realizada con éxito");
                                        saldo = saldo - monto;
                                        Consola.imprimir(
                                                "Para añadir el nuevo contacto a contactos frecuentes presione 'N'. De lo contrario presione cualquier tecla");
                                        rta = Consola.leertxt();

                                        if (rta.equalsIgnoreCase("n")) {
                                            Consola.imprimir("Ingrese el nombre del nuevo contacto");
                                            newC = Consola.leertxt();
                                            contactos.add(newC);
                                            Consola.imprimir(
                                                    "Para conocer su nueva lista de contactos presione 'N'. De lo contrario presione cualquier tecla");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("n")) {
                                                for (int i = 0; i < contactos.size(); i++) {
                                                    Consola.imprimir(i + ". " + contactos.get(i));
                                                }
                                            }
                                        }
                                    } else if (saldo <= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("Saldo insuficiente");
                                    } else if (rta.equalsIgnoreCase("n")) {
                                        Consola.imprimir(
                                                "* La operación ha sido cancelada *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    }
                                    Consola.imprimir(
                                            "- Para realizar otra transferencia presione 'C'\n- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                                    rta = Consola.leertxt();
                                    if (rta.equalsIgnoreCase("m")) {
                                        irMenu = true;
                                    } else if (rta.equalsIgnoreCase("s")) {
                                        irMenu = false;
                                        salida = true;
                                    } else if (rta.equalsIgnoreCase("c")) {
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                        irMenu = true;
                                    }

                                } else {
                                    Consola.imprimir(
                                            "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                    irMenu = true;
                                }
                            } while (continuar);
                            break;

                        case (4):
                            do {
                                continuar = false;
                                Consola.imprimir(
                                        "*** PAGOS ONLINE ***\n<-------ATENCIÓN------->\n<--- Si usted abonó un servicio recientemente puede que el pago del mismo demore en verse reflejado en el sistema --->");
                                Consola.imprimir(
                                        "<------- Para pagar un servicio ya añadido presione 1, para pagar un nuevo servicio presione 2 ------->");
                                laopcion = Consola.leernum();

                                if (laopcion == 1) {
                                    Consola.imprimir("Estos son los servicios adheridos: ");
                                    for (int i = 0; i < servicios.size(); i++) {
                                        Consola.imprimir(i + ". " + servicios.get(i));
                                    }
                                    Consola.imprimir("Indique el número de servicio que desea abonar");
                                    servicio = Consola.leernum();

                                    switch (servicio) {
                                        case (1):
                                            monto = 2545.3;
                                            Consola.imprimir("Usted ha seleccionado: " + servicios.get(servicio)
                                                    + "\n El monto a abonar es: " + monto);
                                            Consola.imprimir(
                                                    "Para abonar el servicio presione 'P', para volver al menú principal presione 'M'");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("m")) {
                                                irMenu = true;
                                            } else if (rta.equalsIgnoreCase("p")) {
                                                if (saldo >= monto) {
                                                    Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                                    saldo = saldo - monto;
                                                } else if (saldo <= monto) {
                                                    Consola.imprimir("Saldo insuficiente");
                                                }
                                            }
                                            break;

                                        case (2):
                                            monto = 4066.5;
                                            Consola.imprimir("Usted ha seleccionado: " + servicios.get(servicio)
                                                    + "\n El monto a abonar es: " + monto);
                                            Consola.imprimir(
                                                    "Para abonar el servicio presione 'P', para volver al menú principal presione 'M'");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("m")) {
                                                irMenu = true;
                                            } else if (rta.equalsIgnoreCase("p")) {
                                                if (saldo >= monto) {
                                                    Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                                    saldo = saldo - monto;
                                                } else if (saldo <= monto) {
                                                    Consola.imprimir("Saldo insuficiente");
                                                }
                                            }
                                            break;

                                        case (3):
                                            monto = 6750.4;
                                            Consola.imprimir("Usted ha seleccionado: " + servicios.get(servicio)
                                                    + "\n El monto a abonar es: " + monto);
                                            Consola.imprimir(
                                                    "Para abonar el servicio presione 'P', para volver al menú principal presione 'M'");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("m")) {
                                                irMenu = true;
                                            } else if (rta.equalsIgnoreCase("p")) {
                                                if (saldo >= monto) {
                                                    Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                                    saldo = saldo - monto;
                                                } else if (saldo <= monto) {
                                                    Consola.imprimir("Saldo insuficiente");
                                                }
                                            }
                                            break;

                                        case (4):
                                            monto = 4900;
                                            Consola.imprimir("Usted ha seleccionado: " + servicios.get(servicio)
                                                    + "\n El monto a abonar es: " + monto);
                                            Consola.imprimir(
                                                    "Para abonar el servicio presione 'P', para volver al menú principal presione 'M'");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("m")) {
                                                irMenu = true;
                                            } else if (rta.equalsIgnoreCase("p")) {
                                                if (saldo >= monto) {
                                                    Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                                    saldo = saldo - monto;
                                                } else if (saldo <= monto) {
                                                    Consola.imprimir("Saldo insuficiente");
                                                }
                                            }
                                            break;

                                        case (5):
                                            monto = 3615.7;
                                            Consola.imprimir("Usted ha seleccionado: " + servicios.get(servicio)
                                                    + "\n El monto a abonar es: " + monto);
                                            Consola.imprimir(
                                                    "Para abonar el servicio presione 'P', para volver al menú principal presione 'M'");
                                            rta = Consola.leertxt();

                                            if (rta.equalsIgnoreCase("m")) {
                                                irMenu = true;
                                            } else if (rta.equalsIgnoreCase("p")) {
                                                if (saldo >= monto) {
                                                    Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                                    saldo = saldo - monto;
                                                } else if (saldo <= monto) {
                                                    Consola.imprimir("Saldo insuficiente");
                                                }
                                            }
                                            break;

                                        default:
                                            Consola.imprimir("*|*|*| La opción ingresada es incorrecta o el servicio aún no esta habilitado |*|*|*");
                                            break;
                                    }
                                    Consola.imprimir(
                                            "- Para seguir abonando servicios presione 'C'\n- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                                    rta = Consola.leertxt();

                                    if (rta.equalsIgnoreCase("m")) {
                                        irMenu = true;
                                    } else if (rta.equalsIgnoreCase("s")) {
                                        irMenu = false;
                                        salida = true;
                                    } else if (rta.equalsIgnoreCase("c")) {
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                        irMenu = true;
                                    }

                                } else if (laopcion == 2) {
                                    Consola.imprimir("Ingrese el nombre del servicio que desea abonar");
                                    nServ = Consola.leertxt();
                                    Consola.imprimir("Usted ha ingresado el siguiente servicio " + nServ);
                                    Consola.imprimir("Ingrese el monto indicado en su factura");
                                    monto = Consola.leerdoub();
                                    Consola.imprimir("Usted ha ingresado el siguiente monto a transferir " + monto
                                            + "\n¿Está seguro que desea realizar esta operación?(s/n)");
                                    rta = Consola.leertxt();

                                    if (saldo >= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("El pago del servicio se ha realizado con éxito");
                                        saldo = saldo - monto;
                                        Consola.imprimir(
                                                "Para adherir el servicio a pagos online presione 'N'. De lo contrario presione cualquier tecla");
                                        rta = Consola.leertxt();

                                        if (rta.equalsIgnoreCase("n")) {
                                            servicios.add(nServ);
                                            Consola.imprimir(
                                                    "Para conocer su nueva lista de servicios presione 'N'. De lo contrario presione cualquier tecla");
                                            rta = Consola.leertxt();
                                            if (rta.equalsIgnoreCase("n")) {
                                                for (int i = 0; i < servicios.size(); i++) {
                                                    Consola.imprimir(i + ". " + servicios.get(i));
                                                }
                                            }
                                        }
                                    } else if (saldo <= monto && rta.equalsIgnoreCase("s")) {
                                        Consola.imprimir("Saldo insuficiente");
                                    } else if (rta.equalsIgnoreCase("n")) {
                                        Consola.imprimir(
                                                "* La operación ha sido cancelada *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú inicial --->");
                                        continuar = true;
                                    }

                                    Consola.imprimir(
                                            "- Para seguir abonando servicios presione 'C'\n- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                                    rta = Consola.leertxt();
                                    if (rta.equalsIgnoreCase("m")) {
                                        irMenu = true;
                                    } else if (rta.equalsIgnoreCase("s")) {
                                        irMenu = false;
                                        salida = true;
                                    } else if (rta.equalsIgnoreCase("c")) {
                                        continuar = true;
                                    } else {
                                        Consola.imprimir(
                                                "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                        irMenu = true;
                                    }
                                } else {
                                    Consola.imprimir(
                                            "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                    irMenu = true;
                                }
                            } while (continuar);
                            break;

                        case (5):
                            do {
                                continuar = false;
                                Consola.imprimir("*** EXTRACCIONES ***");
                                Consola.imprimir(
                                        "<------- Estimado usuario " + user + " su saldo actual es " + saldo
                                                + " ARS ------->\n<------- Su máximo disponible para extracciones es de "
                                                + maxi
                                                + " ARS ------->\nPor favor, ingrese el monto a retirar:");
                                monto = Consola.leernum();

                                if (saldo >= monto && monto <= maxi) {
                                    Consola.imprimir("Ingrese su pin de 4 dígitos");
                                    pinsec = Consola.leernum();

                                    if (pinsec == pin) {
                                        Consola.imprimir(
                                                "<-------ATENCIÓN------->\nPor favor, retire el efectivo de la bandeja de salida");
                                        saldo = saldo - monto;
                                        Consola.imprimir("Su nuevo saldo es " + saldo
                                                + " ARS\n*** Presione una tecla para continuar ***");
                                        rta= Consola.leertxt();
                                    } else {
                                        Consola.imprimir("Su pin es incorrecto, no se pudo realizar la operación");
                                    }
                                } else if (saldo < monto) {
                                    Consola.imprimir("Su saldo es insuficiente");
                                } else if (monto > maxi) {
                                    Consola.imprimir("El monto supera su límite de extracción");
                                }
                                Consola.imprimir(
                                        "- Para realizar otra extracción presione 'C'\n- Para volver al menú principal presione 'M'\n- Para cerrar sesión presione 'S'");
                                rta = Consola.leertxt();

                                if (rta.equalsIgnoreCase("m")) {
                                    irMenu = true;
                                } else if (rta.equalsIgnoreCase("s")) {
                                    irMenu = false;
                                    salida = true;
                                } else if (rta.equalsIgnoreCase("c")) {
                                    continuar = true;
                                } else {
                                    Consola.imprimir(
                                            "* Opción incorrecta *\n ---> Redirigiendo a menú de bienvenida --->");
                                    irMenu = true;
                                }
                            } while (continuar);
                            break;

                        case (6):
                            irMenu = false;
                            salida = true;
                            break;

                        default:
                            Consola.imprimir("*|*|*| La opción ingresada es incorrecta |*|*|*");
                            irMenu = true;
                            break;
                    }
                } while (irMenu);

            } else if (intentos >= 1) {
                Consola.imprimir("Credenciales incorrectas, quedan " + intentos + " intentos");
                intentos = intentos - 1;
            } else if (intentos == 0) {
                Consola.imprimir("Credenciales incorrectas, no quedan mas intentos. Por favor, dirijase al personal");
                salida = true;
            }

        } while (!salida);

        Consola.imprimir("<------- Por favor, extraiga su tarjeta ------->\n** Gracias por usar nuestros servicios **");

    }
}
