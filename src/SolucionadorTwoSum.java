import java.util.Arrays;

// A classe que guarda tudo
public class SolucionadorTwoSum {

    // --- MÉTODO 1: O main (só para testar) ---
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5};
        int alvo = 6;

        // Chamando o método irmão
        int[] resultado = encontrarSoma(array, alvo);

        System.out.println("Números encontrados: " + Arrays.toString(resultado));
    }

    // --- MÉTODO 2: O solucionador (é aqui que focamos) ---
    public static int[] encontrarSoma(int[] array, int alvo) {

        // PASSO 1: Ordenar (Faltou este passo no seu código!)
        // QuickSort.sort(array); // O array agora é [1, 3, 5, 8]

        // PASSO 2: OS PONTEIROS
        int esquerda = 0;
        int direita = array.length - 1;

        // PASSO 3: O LOOP DE BUSCA
        while (esquerda < direita) {


            int soma = array[esquerda] + array[direita];


            if (soma == alvo) {
                // O que retornamos aqui?
                // Dica: Queremos os *valores* que somamos.
                return new int[]{array[esquerda], array[direita]};
            }


            else if (soma > alvo) {
                 direita--;
            }


            else {
                esquerda++;
            }
        }
        return new int[0];
    }
}