package com.ph3.form.programafase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.ProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.Programa;

public class ProcesarProgramaFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa programa = new Programa();

        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase unaFase = new Fase();
        List<Fase> listaDeFases = new ArrayList<Fase>();
        List<Fase> listaDeFasesEnBD = new ArrayList<Fase>();

        @SuppressWarnings("unchecked")
        Map<String, String[]> parametros = request.getParameterMap();

        int[] a1 = null;
        int[] a2 = null;
        int a2l = 0;
        List<Integer> ltemp = new ArrayList<Integer>();
        // recogida de datos
        for (Entry<String, String[]> entry : parametros.entrySet()) {
            for (String valor : entry.getValue()) {
                if (entry.getKey().equals("idPrograma")) {
                    System.out.println("idPrograma: " + valor);
                    programa = programaDAO.buscarPorClave(Integer.parseInt(valor));
                } else if (entry.getKey().equals("listaDeFasesEnBD")) {
                    String[] a0 = null;
                    if (valor != "") {
                        System.out.println("listaDeFasesEnBD: " + valor);
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
                            unaFase = faseDAO.buscarPorClave(inbd);
                            listaDeFasesEnBD.add(unaFase);
                        }
                    }
                } else // recolectar valores de los checkbox
                {
                    System.out.println("Valor: " + valor);
                    a2l++;
                    ltemp.add(Integer.parseInt(valor));
                    unaFase = faseDAO.buscarPorClave(Integer.parseInt(valor));
                    listaDeFases.add(unaFase);
                }
            }
        }

        a2 = new int[a2l];

        for (int i = 0, k = 0; i < ltemp.size() && k < a2l; i++, k++) {
            a2[k] = ltemp.get(i);
        }

        System.out.println("valores de a2 (fases)");
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
        request.setAttribute("idPrograma", programa.getIdPrograma());

        return "protegido/admin/form/programafases/mostrarProgramaFase.jsp";
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
        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase unaFase = new Fase();
        
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

        List<Fase> listaSinCambios = new ArrayList<Fase>();
        List<Fase> listaDeNuevosMarcados = new ArrayList<Fase>();
        List<Fase> listaDeDesmarcados = new ArrayList<Fase>();
        
        System.out.println("valores de aValRepetidos:");
        for (int i = 0; i < aValRepetidos.length; i++) {
            System.out.print(aValRepetidos[i] + " ");
            unaFase = faseDAO.buscarPorClave(aValRepetidos[i]);
            listaSinCambios.add(unaFase);
        }
        request.setAttribute("listaSinCambios", listaSinCambios);
        
        System.out.println("\nvalores de aValDistintos:");
        for (int i = 0; i < aValDistintos.length; i++) {
            System.out.print(aValDistintos[i] + " ");
            unaFase = faseDAO.buscarPorClave(aValDistintos[i]);
            listaDeNuevosMarcados.add(unaFase);
        }
        request.setAttribute("listaDeNuevosMarcados", listaDeNuevosMarcados);

        System.out.println("\nvalores de aValDesmarcados:");
        for (int i = 0; i < aValDesmarcados.length; i++) {
            System.out.print(aValDesmarcados[i] + " ");
            unaFase = faseDAO.buscarPorClave(aValDesmarcados[i]);
            listaDeDesmarcados.add(unaFase);
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
