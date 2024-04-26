import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CONFIGURAR ANTES DE INICIAR O PROGRAMA!

  // IntelliJ Terminal colors
  // Theme: Dark Theme Default
  // Console Background: 000000
  // Error: FF0019
  // Standart output: 000000
  // System output: FFFFFF
  // User input: 00FF24

  // Está em ordem nas configurações
  // Black: B16E41 both
  // Bright Red: FFD599 both
  // Cyan: B16E41 both
  // Green: FFFFFF both
  // White (gray): FFD599 both

  // PEÇAS BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
  // PEÇAS PRETAS:  ♚ ♟ ♜ ♞ ♝ ♛

public class Main {

  // Reset
  public static final String RESET = "\033[0m"; // Text Reset

  // Regular Colors
  public static final String RED = "\033[0;31m"; // RED --> errors
  public static final String BLUE = "\033[0;34m"; // BLUE --> press to continue

  public static final String GREEN = "\033[0;32m"; // GREEN --> WHITE CHARACTER IN INTELLIJ

  public static final String RED_BRIGHT = "\033[0;91m"; // RED --> para caracteres brancos
  public static final String CYAN = "\033[0;36m"; // CYAN --> para caracteres pretos

  // Background
  public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
  public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

  public static void printBackground(int i, int j) {
    if (i % 2 == 0) {
        if (j % 2 == 0)
            System.out.print(WHITE_BACKGROUND);
        else
            System.out.print(BLACK_BACKGROUND);
    } else {
        if (j % 2 == 0)
            System.out.print(BLACK_BACKGROUND);
        else
            System.out.print(WHITE_BACKGROUND);
    }
}

  public static void pressToContinue(Scanner input) {
    System.out.println(GREEN + "--------------------------------------------------------------");
    System.out.println(
            GREEN + "- " + BLUE + "Pressione qualquer tecla para continuar..." + RESET + "                 -");
    System.out.println(GREEN + "--------------------------------------------------------------");
    input.nextLine();
  }

  public static void imprimirTabuleiro(List<Peca> pecas) {
    // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
    // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
    int i;
    for (i = 0; i < 15; i++) {
        System.out.println();
    }
    System.out.println(GREEN + "--------------------------------------------------------------");
    System.out.println(GREEN + "-                          TABULEIRO                         -");
    System.out.println(GREEN + "--------------------------------------------------------------");
    System.out.println(GREEN + "- LEGENDA:                                                   -");
    System.out.println(GREEN + "- PEÇAS BRANCAS (VAZIO POR DENTRO): " + RESET + WHITE_BACKGROUND + " ♔ "
            + BLACK_BACKGROUND + " ♙ " + WHITE_BACKGROUND + " ♖ " + BLACK_BACKGROUND + " ♘ " + WHITE_BACKGROUND
            + " ♗ " + BLACK_BACKGROUND + " ♕ " + GREEN + "   -");
    System.out.println(GREEN + "- PEÇAS PRETAS  (PREENCHIDAS):      " + RESET + BLACK_BACKGROUND + " ♚ "
            + WHITE_BACKGROUND + " ♟ " + BLACK_BACKGROUND + " ♜ " + WHITE_BACKGROUND + " ♞ " + BLACK_BACKGROUND
            + " ♝ " + WHITE_BACKGROUND + " ♛ " + GREEN + "   -");
    System.out.println(GREEN + "--------------------------------------------------------------");

    char letra = 'A';
    System.out.print("     \t");
    for (i = 0; i < 8; i++) {
        System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
    }
    System.out.println();
    System.out.println();

    for (int j = 0; j < 8; j++, letra++) {

        System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);

        for (i = 0; i < 8; i++) {
            printBackground(i, j);
            boolean encontrado = false;

            for (Peca p : pecas) {

                if (p.getPosX() == j && p.getPosY() == i) {
                    System.out.print("[ " + p.getIcone() + " ]" + RESET);
                    encontrado = true;
                    break;
                }

            }

            if (!encontrado)
                System.out.print("[   ]" + RESET);

            if (i == 7)
                System.out.print("\t");
        }
        System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);
        System.out.println();
        if (j == 7)
            System.out.println();
    }
    System.out.print("     \t");
    for (i = 0; i < 8; i++) {
        System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
    }
    System.out.println();

    System.out.println();
    System.out.println(GREEN + "--------------------------------------------------------------");
}
  
  public static void main(String[] args) {
    
    try (Scanner input = new Scanner(System.in)) {

      List<Peca> pecas = new ArrayList<>();
  
      boolean menu = true;
      int i, rodada = 0, corPeca;
  
      // PEÇAS BRANCAS
      for (i = 0; i < 8; i++) {
        pecas.add(new Peao(6, i, '♙', false, true));
      }
      pecas.add(new Rei(7, 4, '♔', false, true));
      pecas.add(new Torre(7, 0, '♖', false, true));
      pecas.add(new Torre(7, 7, '♖', false, true));
      pecas.add(new Cavalo(7, 1, '♘', false, true));
      pecas.add(new Cavalo(7, 6, '♘', false, true));
      pecas.add(new Bispo(7, 2, '♗', false, true));
      pecas.add(new Bispo(7, 5, '♗', false, true));
      pecas.add(new Rainha(7, 3, '♕', false, true));
  
      // PEÇAS PRETAS
      for (i = 0; i < 8; i++) {
        pecas.add(new Peao(1, i, '♟', true, false));
      }
      pecas.add(new Rei(0, 4, '♔', true, false));
      pecas.add(new Torre(0, 0, '♜', true, false));
      pecas.add(new Torre(0, 7, '♜', true, false));
      pecas.add(new Cavalo(0, 1, '♞', true, false));
      pecas.add(new Cavalo(0, 6, '♞', true, false));
      pecas.add(new Bispo(0, 2, '♝', true, false));
      pecas.add(new Bispo(0, 5, '♝', true, false));
      pecas.add(new Rainha(0, 3, '♛', true, false));
  
      do {
  
        corPeca = rodada % 2;
        
        imprimirTabuleiro(pecas);
        pressToContinue(input);

        rodada++;
  
      } while (menu);
    }
  }
}
