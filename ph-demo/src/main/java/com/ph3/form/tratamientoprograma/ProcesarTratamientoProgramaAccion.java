package com.ph3.form.tratamientoprograma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.TratamientoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;
import com.ph3.vo.Tratamiento;

public class ProcesarTratamientoProgramaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        Tratamiento tratamiento = new Tratamiento();

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa unPrograma = new Programa();
        List<Programa> listaDeProgramas = new ArrayList<Programa>();
        List<Programa> listaDeProgramasEnBD = new ArrayList<Programa>();

        @SuppressWarnings("unchecked")
        Map<String, String[]> parametros = request.getParameterMap();

        int[] a1 = null;
        int[] a2 = null;
        int a2l = 0;
        List<Integer> ltemp = new ArrayList<Integer>();
        // recogida de datos
        for (Entry<String, String[]> entry : parametros.entrySet()) {
            for (String valor : entry.getValue()) {
                if (entry.getKey().equals("idTratamiento")) // recolectar valor selector tratamiento
                {
                    tratamiento = tratamientoDAO.buscarPorClave(Integer.parseInt(valor));
                } else if (entry.getKey().equals("listaDeProgramasEnBD")) {

                    String[] a0 = null;
                    if (valor != "") {
                        System.out.println("listaDeProgramasEnBD: " + valor);
                        a0 = valor.split(",");
                    }
                    if (a0 == null) {
                        a1 = new int[0];
                    } else {
                        a1 = new int[a0.length];
                        for (int d = 0; d < a1.length; d++) {
                            a1[d] = Integer.valueOf(a0[d]);
                        }

                        for (int inbd : a1) {
                            unPrograma = programaDAO.buscarPorClave(inbd);
                            listaDeProgramasEnBD.add(unPrograma);
                        }
                    }
                } else // recolectar valores de los checkbox

                {
                    System.out.println("Valor: " + valor);
                    a2l++;
                    ltemp.add(Integer.parseInt(valor));
                    unPrograma = programaDAO.buscarPorClave(Integer.parseInt(valor));
                    listaDeProgramas.add(unPrograma);
                }
            }
        }

        a2 = new int[a2l];

        for (int i = 0, k = 0; i < ltemp.size() && k < a2l; i++, k++) {
            a2[k] = ltemp.get(i);
        }

        System.out.println("valores de a2 (programas)");
        for (int l : a2) {
            System.out.print(l + " ");
        }
        System.out.println();

        int[][][][] b = new int[0][][][];

        if ((a1.length == 0) && (a2.length == 0)) {
            System.out.println("Detectado a1.l == 0 && a2.l == 0");
        } else if ((a1.length == 0) && (a2.length != 0)) {
            System.out.println("Detectado a1.l == 0 && a2.l != 0");
        } else {
            System.out.println("Detectado a1.l != 0 y a2.l != 0");
        }
        int c;
        b = buscar(a1, a2, request);
        c = b[0][0][0][0];
        System.out.println("c: " + c);
        switch (c) {

            case 1 :
                System.out.println("Entramos por todos");
                break;

            case 0 :
                System.out.println("Entramos por alguno");
                break;

            case -1 :
                System.out.println("Entramos por ninguno");
                break;
        }
        System.out.println();

        request.setAttribute("idTratamiento", tratamiento.getIdTratamiento());
        request.setAttribute("listaDeProgramas", listaDeProgramas);
        return "protegido/admin/form/tratamientoprogramas/mostrarTratamientoPrograma.jsp";
    }

    private int[][][][] buscar(int[] a1, int[] a2, HttpServletRequest request) {

        int encontrado = 0;
        int desmarcado = 0;
        int contadorPos = 0;
        int contadorNeg = 0;
        int contadorDes = 0;
        int[] aRetorno = null;
        int[] aValRepetidos = null;
        int[] aValDistintos = null;
        int[] aValDesmarcados = null;
        Programa unPrograma = new Programa();
        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();

        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println("Buscando dentro del array1 cada valor del array2");

        for (int i = 0; i < a2.length; i++) {
            encontrado = Arrays.binarySearch(a1, a2[i]);
            System.out.print(encontrado + " ");
            if (encontrado >= 0) {
                contadorPos++;
            } else {
                contadorNeg++;
            }
        }
        System.out.println("\ndesmarcados: ");
        for (int i = 0; i < a1.length; i++) {
            desmarcado = Arrays.binarySearch(a2, a1[i]);
            if (desmarcado < 0) {
                contadorDes++;
                System.out.print(a1[i] + " ");
            }
        }

        System.out.println("\nEl contador de positivos: " + contadorPos);
        System.out.println("El contador de negativos: " + contadorNeg);

        aValRepetidos = new int[contadorPos];
        aValDistintos = new int[contadorNeg];
        aValDesmarcados = new int[contadorDes];

        for (int i = 0, j = 0; i < a2.length; i++) {
            encontrado = Arrays.binarySearch(a1, a2[i]);
            if (encontrado >= 0) {
                aValRepetidos[j++] = a2[i];
            }
        }
        for (int i = 0, j = 0; i < a2.length; i++) {
            encontrado = Arrays.binarySearch(a1, a2[i]);
            if (encontrado < 0) {
                aValDistintos[j++] = a2[i];
            }
        }

        for (int i = 0, j = 0; i < a1.length; i++) {
            desmarcado = Arrays.binarySearch(a2, a1[i]);
            if (desmarcado < 0) {
                aValDesmarcados[j++] = a1[i];
            }
        }

        aRetorno = new int[1];
        if (contadorPos == 0) {
            System.out.println("No hay ninguno");
            aRetorno[0] = -1;
        } else if (contadorPos == a2.length) {
            System.out.println("Estan todos");
            aRetorno[0] = 1;
            if (aValRepetidos.length == a1.length) {
                System.out.println("Completamente todos");

            } else {
                System.out.println("Parcialmente todos");
            }
        } else {
            System.out.println("Estan algunos");
            aRetorno[0] = 0;
        }

        List<Programa> listaSinCambios = new ArrayList<Programa>();
        List<Programa> listaDeNuevosMarcados = new ArrayList<Programa>();
        List<Programa> listaDeDesmarcados = new ArrayList<Programa>();

        System.out.println("valores de aValRepetidos:");
        for (int i = 0; i < aValRepetidos.length; i++) {
            System.out.print(aValRepetidos[i] + " ");
            unPrograma = programaDAO.buscarPorClave(aValRepetidos[i]);
            listaSinCambios.add(unPrograma);
        }
        request.setAttribute("listaSinCambios", listaSinCambios);

        System.out.println("\nvalores de aValDistintos:");
        for (int i = 0; i < aValDistintos.length; i++) {
            System.out.print(aValDistintos[i] + " ");
            unPrograma = programaDAO.buscarPorClave(aValDistintos[i]);
            listaDeNuevosMarcados.add(unPrograma);
        }
        request.setAttribute("listaDeNuevosMarcados", listaDeNuevosMarcados);

        System.out.println("\nvalores de aValDesmarcados:");
        for (int i = 0; i < aValDesmarcados.length; i++) {
            System.out.print(aValDesmarcados[i] + " ");
            unPrograma = programaDAO.buscarPorClave(aValDesmarcados[i]);
            listaDeDesmarcados.add(unPrograma);
        }
        request.setAttribute("listaDeDesmarcados", listaDeDesmarcados);

        System.out.println();
        System.out.println("\nTrabajando con array multidimensional:");

        int[][][][] aMultiRetRepDisyDes = {{{aRetorno}, {aValRepetidos}, {aValDistintos}, {aValDesmarcados}}};

        for (int m = 0; m < aMultiRetRepDisyDes.length; m++) {
            for (int n = 0; n < aMultiRetRepDisyDes[m].length; n++) {
                for (int o = 0; o < aMultiRetRepDisyDes[m][n].length; o++) {
                    for (int p = 0; p < aMultiRetRepDisyDes[m][n][o].length; p++) {
                        System.out.print("aMultiRyD[" + m + "][" + n + "][" + o + "][" + p + "]: " + aMultiRetRepDisyDes[m][n][o][p] + " \n");
                    }
                }
            }
        }
        System.out.println();
        return aMultiRetRepDisyDes;
    }

}
