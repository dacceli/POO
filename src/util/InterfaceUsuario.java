package util;

import java.util.Scanner;
public class InterfaceUsuario {
    Scanner leitor = new Scanner(System.in);

    public double receberValorImovel() {
        // Loop para validação do valor do imóvel.
        while (true) {
            System.out.println("Digite o valor do imóvel: ");
            double valor = Double.parseDouble(leitor.nextLine());
            if (valor < 0) {
                System.out.println("O valor do imóvel deve ser positivo");
                continue;
            }
            return valor;
        }
    }

    public int receberPrazoFinanciamento() {
        // Loop para validação do prazo do Financiamento
        while (true) {
            System.out.println("Digite agora o prazo do financiamento em anos: ");
            int prazo = Integer.parseInt(leitor.nextLine());
            if (prazo >= 31 || prazo < 0) {
                System.out.println("O prazo de financiamento vai até 30 anos.");
                continue;
            }
            return prazo;
        }
    }

    public double receberTaxaDeJuros() {
        // Loop para a validação da taxa de Juros
        while (true) {
            System.out.println("Digite a taxa de juros anual do financiamento: ");
            double taxaJuros = Double.parseDouble(leitor.nextLine());
            if (taxaJuros >= 30 || taxaJuros < 0) {
                System.out.println("A taxa de Juros deve nao pode ser negativo nem acima de 30%");
                continue;
            }
            return taxaJuros;
        }
    }

    public String receberTipoDeZona() {
        // Loop para validação do tipo de zona
        while (true) {
            System.out.println("Digite agora o tipo de zona do terreno(residencial ou comercial): ");
            return leitor.nextLine();
        }
    }
    public double receberAreaConstruida() {
        // Loop para validação do prazo do Financiamento
        while (true) {
            System.out.println("Digite agora a área contruida no terreno: ");
            return Double.parseDouble(leitor.nextLine());
        }
    }
}
