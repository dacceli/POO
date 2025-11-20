package main;
import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args){
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();
        InterfaceUsuario interface1 = new InterfaceUsuario();

        System.out.println("Bem vindo ao calculador de financiamento!");

        // Loop com valor de repetição definido conforme o requisito da Atividade Somativa.
        for(int i = 0; i < 4; i++){
            double valorImovel = interface1.receberValorImovel();
            int prazoFinanciamento = interface1.receberPrazoFinanciamento();
            double taxaJuros = interface1.receberTaxaDeJuros();
            String tipoDeZona = interface1.receberTipoDeZona();


            listaDeFinanciamentos.add(new modelo.Terreno(valorImovel, prazoFinanciamento, taxaJuros, tipoDeZona));
        }

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        System.out.println("\nResumo dos Financiamentos");

        for(Financiamento fin : listaDeFinanciamentos){
            totalImoveis += fin.getValorImovel();
            totalFinanciamentos += fin.pagamentoTotal();
        }

        System.out.printf("\nTotal de todos os imóveis: R$ %.2f\n", totalImoveis);
        System.out.printf("\nTotal de todos os Financiamentos: R$ %.2f\n", totalFinanciamentos);
    }
}
