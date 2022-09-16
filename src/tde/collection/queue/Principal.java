/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tde.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author LucasM
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("-------------------Fila de Vacinação de um Consultorio-------------------");
        //Usando a interface Queue e a implementação LinkedList
        Queue fila = new LinkedList();
        //inserindo elementos  pré-definidos na fila
        System.out.println("FILA PRÉ-DEFINIDA ");
        fila.add("1° João");
        fila.add("2° Jose");
        fila.add("3° Carlos");
        fila.add("4° Ana");

        fila.forEach((obj) -> {
            System.out.printf(" | " + obj);
        });
        int aux = 0;

        do {
            try {
                do {
                    System.out.println("\nDigite (1) para inserir um novo elemento 'NOME' ou numero na fila ");
                    System.out.println("Digite (2) para remover elemento ");
                    System.out.println("Digite (3)Para ver o primeiro elemento ");
                    System.out.println("Digite (4)Para ver toda fila ");
                    System.out.println("Digite (0) para sair");
                    aux = teclado.nextInt();
                    while (aux < 0 || aux > 4) {
                        System.out.println("ERRO, DIGITE 1, 2, 3, 4 ou 0 para sair");
                        aux = teclado.nextInt();
                    }
                    if (aux == 1) {
                        System.out.println("Digite um nome ou numero para inserir na fila");
                        String ins = teclado.next();
                        fila.add(ins);
                        System.out.println("Fila atualizada:");
                        fila.forEach((obj) -> {
                            System.out.printf(" | " + obj);
                        });
                    }
                    //Removendo da fila, será removido o primeiro elemento que foi inserido
                    if (aux == 2) {
                        fila.remove();
                        System.out.println("Depois de remover um elemento:");
                        //percorrendo a fila novamente
                        fila.forEach((obj) -> {
                            System.out.printf(" | " + obj);
                        });
                        System.out.printf(" |");
                        System.out.println();
                    }
                    //Busca o primeiro valor da fila
                    if (aux == 3) {
                        System.out.println("Busca do primeiro elemento: ");
                        System.out.printf(" | " + fila.peek());
                    }
                    if (aux == 4) {
                        System.out.println("Fila no momento atual:");
                       fila.forEach((obj) -> {
                            System.out.printf(" | " + obj);
                        });
                        System.out.printf(" |");
                        System.out.println();
                        
                    }
                    //Enquanto for diferente de 0 o menu continuará executando
                } while (aux != 0);
                break;
                //Tratamento de exceções que permitirão um bom funcionamento do programa sem erros    
            } catch (InputMismatchException ex) {
                String str = teclado.nextLine();
                System.out.println("Caractere: " + str);
                System.out.println("CARACTERE INVALIDO NESTA ETAPA, DIGITE UM NUMERO");
            } catch (NoSuchElementException ex) {
                System.out.println("FILA SEM ELEMENTOS, INSIRA UM NOVO ELEMENTO");
            }
            //Enquanto for true o programa continuará rodando    
        } while (true);
    }
}
