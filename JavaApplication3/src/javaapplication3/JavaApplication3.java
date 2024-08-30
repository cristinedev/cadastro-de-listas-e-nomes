import javax.swing.JOptionPane;

public class JavaApplication3 {

    // Criação de dois arrays que armazenam 5 elementos cada
    String[] nomes = new String[5];
    double[] salar = new double[5];

    // Método para buscar um nome
    public int buscaNome(String nomeBus) {
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomes[i].equals(nomeBus)) {
                return i;  // Retorna a posição do nome encontrado
            }
        }
        return -1; // Retorna -1 se o nome não for encontrado
    }

    // Método para ordenar os nomes usando Bubble Sort
    public void bubbleNome() {
        for (int i = 0; i < nomes.length - 1; i++) {
            for (int j = 0; j < nomes.length - 1 - i; j++) {
                if (nomes[j] != null && nomes[j + 1] != null && nomes[j].compareTo(nomes[j + 1]) > 0) {
                    String temp = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = temp;
                }
            }
        }
    }

    // Método para ordenar os salários usando Bubble Sort
    public void bubbleSalario() {
        for (int i = 0; i < salar.length - 1; i++) {
            for (int j = 0; j < salar.length - 1 - i; j++) {
                if (salar[j] > salar[j + 1]) {
                    double temp = salar[j];
                    salar[j] = salar[j + 1];
                    salar[j + 1] = temp;
                }
            }
        }
    }

    // Método para listar nomes e salários
    public void listarDados() {
        StringBuilder listaNomes = new StringBuilder("Nomes:\n");
        StringBuilder listaSalarios = new StringBuilder("Salários:\n");

        for (int i = 0; i < nomes.length; i++) {
            listaNomes.append(nomes[i]).append("\n");
            listaSalarios.append(salar[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, listaNomes.toString());
        JOptionPane.showMessageDialog(null, listaSalarios.toString());
    }

    // Método para listar apenas os salários
    public void listarSalarios() {
        StringBuilder listaSalarios = new StringBuilder("Salários:\n");

        for (int i = 0; i < salar.length; i++) {
            listaSalarios.append(salar[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, listaSalarios.toString());
    }

    // Método para exibir o menu e interagir com o usuário
    public void menu() {
        int opcao;
        do {
            String menu = """
                Menu:
                1. Ler Nome
                2. Ler Salário
                3. Listar Nomes
                4. Listar Salários
                5. Buscar Nome
                6. Buscar Salário
                7. Classificar por Nome
                8. Classificar por Salário
                9. Finalizar
                """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> {
                    for (int i = 0; i < nomes.length; i++) {
                        nomes[i] = JOptionPane.showInputDialog("Digite o nome " + (i + 1) + ":");
                    }
                }
                case 2 -> {
                    for (int i = 0; i < salar.length; i++) {
                        salar[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário " + (i + 1) + ":"));
                    }
                }
                case 3 -> listarDados();
                case 4 -> listarSalarios();
                case 5 -> {
                    String nomeBus = JOptionPane.showInputDialog("Digite o nome a ser buscado:");
                    int pos = buscaNome(nomeBus);
                    if (pos >= 0) {
                        JOptionPane.showMessageDialog(null, "Nome encontrado na posição " + pos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome não encontrado.");
                    }
                }
                case 7 -> {
                    bubbleNome();
                    JOptionPane.showMessageDialog(null, "Nomes classificados com sucesso!");
                }
                case 8 -> {
                    bubbleSalario();
                    JOptionPane.showMessageDialog(null, "Salários classificados com sucesso!");
                }
                case 9 -> JOptionPane.showMessageDialog(null, "Programa finalizado.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 9);
    }

    public static void main(String[] args) {
        JavaApplication3 javaApplication = new JavaApplication3();
        javaApplication.menu();
    }
}
    

