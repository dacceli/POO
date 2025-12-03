package util;

import java.util.Locale;
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
            try {
                System.out.println("Digite agora o prazo do financiamento em anos: ");
                int prazo = Integer.parseInt(leitor.nextLine());
                if (prazo >= 31 || prazo < 0) {
                    System.out.println("O prazo de financiamento vai até 30 anos.");

                } else {
                    return prazo;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite somente números!");
            }

        }

    }


    public double receberTaxaDeJuros() {
        // Loop para a validação da taxa de Juros
        while (true) {
            try {
                System.out.println("Digite a taxa de juros anual do financiamento: ");
                double taxaJuros = Double.parseDouble(leitor.nextLine());
                if (taxaJuros >= 30 || taxaJuros < 0) {
                    System.out.println("A taxa de Juros deve nao pode ser negativo nem acima de 30%");
                    continue;
                } else {
                    return taxaJuros;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite somente números!");
            }

        }
    }

    public String receberTipoDeZona() {
        while (true) {
            System.out.println("Digite agora o tipo de zona do terreno(residencial ou comercial): ");
            String zona = leitor.nextLine().toLowerCase();
            if (zona.equals("comercial") || zona.equals("residencial")) {
                return zona;
            } else {
                System.out.println("Tipo de zona inválido!!");
            }

        }
    }

    public double receberAreaConstruida() {
        // Loop para validação do prazo do Financiamento

        while (true) {
            try {
                System.out.println("Digite agora a área contruida no terreno: ");
                int areaConstruida = Integer.parseInt(leitor.nextLine());
                if (areaConstruida <= 0) {
                    System.out.println("A área não pode ser menor ou igual a zero");
                } else {
                    return areaConstruida;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite somente números");
            }
        }
    }
}


