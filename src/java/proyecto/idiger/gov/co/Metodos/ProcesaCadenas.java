/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.Metodos;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

/**
 * Documento : ManejadosFechas
 * Fecha de Creación : 22/01/2018, 10:34:33 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : moortiz
 * Funcion del Archivo :
 */
public class ProcesaCadenas {

    public String armaCadena(String[] cadena) {
        String retorno = null;
        for (int a = 0; a < cadena.length; a++) {
            retorno = retorno + cadena[a] + ",";
        }
        retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }

    public String writter(String str) throws UnsupportedEncodingException {
        String stringbuffer = new String();
        if (str != null) {
            ProcesaCaracEspeciales cadenas = new ProcesaCaracEspeciales();
            stringbuffer = cadenas.quitarEspeciales(str);
        } else {
            stringbuffer = "NULO";
        }
        return stringbuffer;
    }

    public String notNull(String str) throws UnsupportedEncodingException {
        String retorno = "";
        if (str == null) {
            retorno = "";
        } else {
            retorno = str;
        }
        return this.writter(retorno);
    }

    public String notNull(String str, String cambio) throws UnsupportedEncodingException {
        String retorno = "";
        if (str == null) {
            retorno = cambio;
        } else {
            retorno = str;
        }
        return this.writter(retorno);
    }

    public String html(String str, String cambio) throws UnsupportedEncodingException {
        String retorno = "";
        if (str == null) {
            retorno = cambio;
        } else {
            retorno = str;
        }
        return retorno;
    }

    public String getNumber(Object number) {
        if (number == null) {
            return "0";
        } else {
            String str = String.valueOf(number);
            double value;
            String numberFormat = "###,###,###,###";
            DecimalFormat formatter = new DecimalFormat(numberFormat);
            try {
                value = Double.parseDouble(str);
            } catch (Throwable t) {
                return null;
            }
            return formatter.format(value).toString();
        }
    }

    public String getNumber(String number) {
        //String str = String.valueOf(number);
        if (number == null) {
            return "0";
        } else {
            double value;
            String numberFormat = "###,###,###,###";
            DecimalFormat formatter = new DecimalFormat(numberFormat);
            try {
                value = Double.parseDouble(number);
            } catch (Throwable t) {
                return null;
            }
            return formatter.format(value).toString();
        }
    }

    public String getNumberDecimal(String number) {
        //String str = String.valueOf(number);
        if (number == null) {
            return "0";
        } else {
            double value;
            String numberFormat = "###,###,###,###.00";
            DecimalFormat formatter = new DecimalFormat(numberFormat);
            try {
                value = Double.parseDouble(number);
            } catch (Throwable t) {
                return null;
            }
            return formatter.format(value).toString();
        }
    }

    public String getNumeroDocumento(String number) {
        //String str = String.valueOf(number);
        double value;
        String numberFormat = "###,###,###,###";
        DecimalFormat formatter = new DecimalFormat(numberFormat);
        try {
            value = Double.parseDouble(number);
        } catch (Throwable t) {
            return null;
        }
        return formatter.format(value).toString();
    }

    public double redondear(double numero, int numeroDecimales) {
        long mult = (long) Math.pow(10, numeroDecimales);
        double resultado = (Math.round(numero * mult)) / (double) mult;
        return resultado;
    }

    public String getDocumentoIdentidad(String number) {
        //String str = String.valueOf(number);
        double value;
        String numberFormat = "#'###.###";
        DecimalFormat formatter = new DecimalFormat(numberFormat);
        try {
            value = Double.parseDouble(number);
        } catch (Throwable t) {
            return null;
        }
        return formatter.format(value).toString();
    }

    public String ArmarCadena(String cadena, int longitud, String caracter) {
        //cadena = quitaEspacios(cadena);
        String retorno = "";
        int i = longitud - cadena.length();
        int j = 0;
        while (j < i) {
            retorno = retorno + caracter;
            j++;
        }
        retorno = retorno + cadena;
        return retorno;
    }
}
