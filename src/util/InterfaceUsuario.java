package util;
import java.util.Locale;
import java.util.Scanner;
import modelo.*;

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
                double areaConstruida = Double.parseDouble(leitor.nextLine());
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

    public int pedirNumeroVagas(){
        while(true)
            try{
                System.out.println("Digite o número de vagas: ");
                int numeroVagas = Integer.parseInt(leitor.nextLine());
                if(numeroVagas <= 0){
                    System.out.println("A área construída não pode ser menor ou igual a zero!");
                }else{
                    return numeroVagas;
                }
            } catch (NumberFormatException e) {
                System.out.println("O número de vagas deve ser maior que zero");
            }
        }

    

    public int pedirAndar(){
        System.out.println("Digite o andar: ");
        return Integer.parseInt(leitor.nextLine());
    }


    public double receberAreaTerreno() {
        while (true) {
            try {
                System.out.println("Digite o tamanho da área do terreno: ");
                double areaTerreno = Double.parseDouble(leitor.nextLine());
                if (areaTerreno <= 0) {
                    System.out.println("A área do terreno deve ser maior que zero.");
                } else {
                    return areaTerreno;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite somente números.");
            }
        }
    }

    public Financiamento cadastrarFinanciamento() {

        double valor = receberValorImovel();
        int prazo = receberPrazoFinanciamento();
        double taxa = receberTaxaDeJuros();

        while (true) {
            System.out.println("Escolha o tipo de financiamento:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");

            String tipo = leitor.nextLine();

            if (tipo.equals("1")) {
                double areaConstruida = receberAreaConstruida();
                double areaTerreno = receberAreaTerreno();

                return new Casa(valor, prazo, taxa, areaConstruida, areaTerreno);

            } else if (tipo.equals("2")) {
                // Pede dados do Apartamento
                int vagas = pedirNumeroVagas();
                int andar = pedirAndar();

                return new Apartamento(valor, prazo, taxa, vagas, andar);

            } else if (tipo.equals("3")) {
                // Pede dados do Terreno
                String zona = receberTipoDeZona();

                return new Terreno(valor, prazo, taxa, zona);

            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}


