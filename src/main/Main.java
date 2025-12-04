package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {

    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();
        int opcao = 0;

        System.out.println("=== SGF - Sistema de Gestão de Financiamentos ===");


        do {
            mostrarMenu();


            try {

                System.out.print("Digite a opção: ");
                java.util.Scanner scannerMenu = new java.util.Scanner(System.in);
                opcao = Integer.parseInt(scannerMenu.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:

                    Financiamento novoFinanciamento = interfaceUsuario.cadastrarFinanciamento();
                    try {
                        novoFinanciamento.calcularPagamentoMensal();

                        listaDeFinanciamentos.add(novoFinanciamento);
                        System.out.println("\n*** Financiamento cadastrado com sucesso! ***");

                    } catch (util.AumentoMaiorDoQueJurosException e) {
                        System.out.println("\n[ERRO] Não foi possível cadastrar este financiamento:");
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:

                    if (listaDeFinanciamentos.isEmpty()) {
                        System.out.println("\nNenhum financiamento cadastrado ainda.");
                    } else {
                        System.out.println("\n--- Lista de Financiamentos ---");

                        for (Financiamento f : listaDeFinanciamentos) {
                            f.dadosFinanciamento();
                            System.out.println("------------------------------");
                        }
                    }
                    break;

                case 3:

                    if (listaDeFinanciamentos.isEmpty()) {
                        System.out.println("Lista vazia. Cadastre algo antes de salvar.");
                    } else {
                        salvarArquivoTexto(listaDeFinanciamentos, "financiamentos.txt");
                        lerArquivoTexto("financiamentos.txt");
                    }
                    break;

                case 4:

                    if (listaDeFinanciamentos.isEmpty()) {
                        System.out.println("Lista vazia. Cadastre algo antes de salvar.");
                    } else {
                        salvarArquivoSerializado(listaDeFinanciamentos, "financiamentos.ser");
                        lerArquivoSerializado("financiamentos.ser");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }



    private static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Cadastrar Financiamento");
        System.out.println("2. Listar Todos os Financiamentos");
        System.out.println("3. Salvar e Ler (Arquivo Texto .txt)");
        System.out.println("4. Salvar e Ler (Arquivo Serializado .ser)");
        System.out.println("0. Sair");
    }


    private static void salvarArquivoTexto(List<Financiamento> lista, String nomeArquivo) {
        try (FileWriter arq = new FileWriter(nomeArquivo);
             PrintWriter gravarArq = new PrintWriter(arq)) {

            for (Financiamento f : lista) {

                gravarArq.println(f.toString());
            }
            System.out.println("\n[TXT] Dados salvos com sucesso em " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo texto: " + e.getMessage());
        }
    }

    private static void lerArquivoTexto(String nomeArquivo) {
        System.out.println("[TXT] Lendo arquivo de volta para conferência...");
        try (FileReader arq = new FileReader(nomeArquivo);
             BufferedReader lerArq = new BufferedReader(arq)) {

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.println("Lido do arquivo: " + linha);
                linha = lerArq.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo texto: " + e.getMessage());
        }
    }


    private static void salvarArquivoSerializado(List<Financiamento> lista, String nomeArquivo) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            output.writeObject(lista);
            System.out.println("\n[SER] Lista serializada salva com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void lerArquivoSerializado(String nomeArquivo) {
        System.out.println("[SER] Lendo arquivo serializado de volta...");
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(nomeArquivo))) {

            List<Financiamento> listaLida = (ArrayList<Financiamento>) input.readObject();

            System.out.println("Sucesso! Recuperados " + listaLida.size() + " financiamentos do arquivo serializado.");

            if(!listaLida.isEmpty()) {
                System.out.println("Exemplo do primeiro item recuperado: " + listaLida.get(0).getValorImovel());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler serializado: " + e.getMessage());
        }
    }
}