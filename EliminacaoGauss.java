public class EliminacaoGauss {

    public static void main(String[] args) {
        double[][] matriz = {
            { 2, 1, -1, 8 },
            { -3, -2, 2, -11 },
            { -3, 1, 2, -3 }
        };

        int n = matriz.length;

        // Aplicando eliminação de Gauss
        for (int i = 0; i < n; i++) {
            // Encontrar o pivô
            int piv = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matriz[j][i]) > Math.abs(matriz[piv][i])) {
                    piv = j;
                }
            }

            // Trocar linhas (pivô com a linha atual)
            double[] temp = matriz[i];
            matriz[i] = matriz[piv];
            matriz[piv] = temp;

            // Fazer a eliminação gaussiana
            for (int j = i + 1; j < n; j++) {
                double fator = matriz[j][i] / matriz[i][i];
                for (int k = i + 1; k <= n; k++) {
                    matriz[j][k] -= matriz[i][k] * fator;
                }
                matriz[j][i] = 0;
            }
        }

        // Resolvendo o sistema
        double[] solucao = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solucao[i] = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                solucao[i] -= matriz[i][j] * solucao[j];
            }
            solucao[i] /= matriz[i][i];
        }

        // Exibindo a solução
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + solucao[i]);
        }
    }
}
