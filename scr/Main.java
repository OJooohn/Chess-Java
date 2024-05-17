import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CONFIGURAR ANTES DE INICIAR O PROGRAMA!

// IntelliJ Terminal colors
// Está em ordem nas configurações
// Theme: Dark Theme Default

// Black: B16E41 both
// Bright Red: FFD599 both
// Cyan: B16E41 both
// Green: FFFFFF both
// Magenta: 3EBA67
// White (gray): FFD599 both

// Console Background: 000000
// Error: FF0019
// Standart output: 000000
// System output: FFFFFF
// User input: 00FF24

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
  public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE

  public static void backgroundColor(int i, int j) {
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

  public static void imprimirTabuleiro(List<Peca> pecas, int linha, int coluna) {
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
        backgroundColor(i, j);
        boolean encontrado = false;

        for (Peca p : pecas) {

          if (p.getPosX() == j && p.getPosY() == i) {
            if (j == linha && i == coluna) {
              System.out.print(PURPLE_BACKGROUND + "[ " + p.getIcone() + " ]" + RESET);
            } else {
              System.out.print("[ " + p.getIcone() + " ]" + RESET);
            }
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

      int i, rodada = 0, corPeca;
      int indicePeca = 0;

      // PEÇAS BRANCAS
      pecas.add(new Rei(7, 4, '♔', false, true));
      pecas.add(new Torre(7, 0, '♖', false, true));
      pecas.add(new Torre(7, 7, '♖', false, true));
      pecas.add(new Cavalo(7, 1, '♘', false, true));
      pecas.add(new Cavalo(7, 6, '♘', false, true));
      pecas.add(new Bispo(7, 2, '♗', false, true));
      pecas.add(new Bispo(7, 5, '♗', false, true));
      pecas.add(new Rainha(7, 3, '♕', false, true));
      for (i = 0; i < 8; i++) {
        pecas.add(new Peao(6, i, '♙', false, true));
      }

      // PEÇAS PRETAS
      pecas.add(new Rei(0, 4, '♚', true, false));
      pecas.add(new Torre(0, 0, '♜', true, false));
      pecas.add(new Torre(0, 7, '♜', true, false));
      pecas.add(new Cavalo(0, 1, '♞', true, false));
      pecas.add(new Cavalo(0, 6, '♞', true, false));
      pecas.add(new Bispo(0, 2, '♝', true, false));
      pecas.add(new Bispo(0, 5, '♝', true, false));
      pecas.add(new Rainha(0, 3, '♛', true, false));
      for (i = 0; i < 8; i++) {
        pecas.add(new Peao(1, i, '♟', true, false));
      }

      String pecaSelecionada, pecaDestino;
      int linhaSelecionada, colunaSelecionada;
      int linhaDestino, colunaDestino;

      boolean whiteKingAlive, blackKingAlive;
      boolean isWhite, isBlack, casaNaoVazia;
      boolean destinoVerificado;

      char iconePeca = ' ';

      do {

        corPeca = rodada % 2;

        imprimirTabuleiro(pecas, -1, -1);
        if (corPeca == 0) {
          System.out.println(
              GREEN + "- RODADA DAS PEÇAS " + RED_BRIGHT + "BRANCAS" + GREEN + "                                   -");
        } else {
          System.out.println(
              GREEN + "- RODADA DAS PEÇAS " + CYAN + "PRETAS" + GREEN + "                                   -");
        }
        System.out.println(GREEN + "--------------------------------------------------------------");

        // VERIFICAR SE OS REIS ESTÃO VIVOS
        whiteKingAlive = false;
        blackKingAlive = false;

        for (Peca piece : pecas) {
          if (piece.getIcone() == '♔')
            whiteKingAlive = true;
          if (piece.getIcone() == '♚')
            blackKingAlive = true;
        }

        if (!whiteKingAlive) {
          imprimirTabuleiro(pecas, -1, -1);
          System.out.println(
              GREEN + "- PEÇAS " + CYAN + "PRETAS" + GREEN + " VENCERAM!                                     -");
          System.out.println(GREEN + "--------------------------------------------------------------");
          break;
        }

        if (!blackKingAlive) {
          imprimirTabuleiro(pecas, -1, -1);
          System.out.println(
              GREEN + "- PEÇAS " + RED_BRIGHT + "BRANCAS" + GREEN + " VENCERAM!                                    -");
          System.out.println(GREEN + "--------------------------------------------------------------");
          break;
        }

        casaNaoVazia = false;
        isWhite = false;
        isBlack = false;
        destinoVerificado = false;

        System.out.println(
            GREEN + "- DIGITE " + BLUE + "\"SAIR\" " + GREEN + "PARA FINALIZAR O PROGRAMA                    -");
        System.out
            .println(GREEN + "- " + BLUE + "COORDENADAS ENTRE A1 e H8" + GREEN + "                                  -");
        System.out.print(GREEN + "- SELECIONE AS COORDENAS DA PEÇA DESEJADA: ");
        pecaSelecionada = input.nextLine();

        if (pecaSelecionada.equalsIgnoreCase("SAIR")) {
          System.out.println(GREEN + "--------------------------------------------------------------");
          System.out.println(GREEN + "- JOGO FINALIZADO SEM VENCEDORES                             -");
          System.out.println(GREEN + "--------------------------------------------------------------");
          break;
        }

        if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0))
            || !Character.isDigit(pecaSelecionada.charAt(1))) {
          System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
          pressToContinue(input);
        } else {

          // pecaSelecionada = "A1" --> linha = 0 | coluna = 0
          linhaSelecionada = pecaSelecionada.toUpperCase().charAt(0) - 65;
          colunaSelecionada = pecaSelecionada.charAt(1) - 49;

          if ((linhaSelecionada < 0 || linhaSelecionada > 7) || (colunaSelecionada < 0 || colunaSelecionada > 7)) {
            System.out
                .println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8asd'." + GREEN);
            pressToContinue(input);
          } else {

            if (corPeca == 0) {

              for (i = 0; i < pecas.size(); i++) {
                Peca piece = pecas.get(i);

                if (piece.getPosX() == linhaSelecionada && piece.getPosY() == colunaSelecionada && piece.getIsWhite()) {
                  indicePeca = i;
                  iconePeca = piece.getIcone();
                  isWhite = piece.getIsWhite();
                  casaNaoVazia = true;
                  break;
                } else if (piece.getPosX() == linhaSelecionada && piece.getPosY() == colunaSelecionada && piece.getIsBlack()) {
                  casaNaoVazia = true;
                }

              }

              if (!isWhite) {
                System.out.println(GREEN + "--------------------------------------------------------------");
                if (!casaNaoVazia) {
                  System.out.println(GREEN + "- " + RED + "Você selecionou uma casa VAZIA! Selecione uma peça "
                          + RED_BRIGHT + "BRANCA" + GREEN + "! -");
                } else {
                  System.out.println(
                      GREEN + "- " + RED + "Você selecionou uma peça " + CYAN + "PRETA" + GREEN +"!" + RED + " Selecione uma peça " + RED_BRIGHT +"BRANCA" + GREEN + "! -");
                }
                pressToContinue(input);
              }

              if (isWhite) {

                do {

                  imprimirTabuleiro(pecas, linhaSelecionada, colunaSelecionada);
                  System.out.println(
                      GREEN + "- PECA SELECIONADA: " + iconePeca + "                                        -");

                  System.out.println(GREEN + "--------------------------------------------------------------");
                  System.out.println(GREEN + "- DIGITE " + BLUE + "\"VOLTAR\" " + GREEN
                      + "PARA SELECIONAR OUTRA PEÇA:                -");
                  System.out.println(GREEN + "- " + BLUE + "COORDENADAS ENTRE A1 e H8" + GREEN
                      + "                                  -");
                  System.out.print(GREEN + "- SELECIONE A COORDENADA DE DESTINO: ");
                  pecaDestino = input.nextLine();

                  if (pecaDestino.equalsIgnoreCase("VOLTAR")) {
                    break;
                  }

                  if (pecaDestino.length() != 2 || !Character.isLetter(pecaDestino.charAt(0))
                      || !Character.isDigit(pecaDestino.charAt(1))) {
                    System.out.println(
                        GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                    pressToContinue(input);
                  } else {
                    linhaDestino = pecaDestino.toUpperCase().charAt(0) - 65;
                    colunaDestino = pecaDestino.charAt(1) - 49;

                    if ((linhaDestino < 0 || linhaDestino > 7) || (colunaDestino < 0 || colunaDestino > 7)) {
                      System.out.println(
                          GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                      pressToContinue(input);
                    } else {

                      destinoVerificado = pecas.get(indicePeca).moverPeca(pecas, linhaDestino, colunaDestino);

                      if (!destinoVerificado) {
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!" + GREEN
                            + "                                -");
                        pressToContinue(input);
                        break;
                      }

                      // Atualizar a posição da peça caso tenha capturado um inimigo
                      for (i = 0; i < pecas.size(); i++) {
                        Peca piece = pecas.get(i);

                        if (piece.getPosX() == linhaDestino && piece.getPosY() == colunaDestino && piece.getIsWhite()) {
                          indicePeca = i;
                          break;
                        }
                      }

                      pecas.get(indicePeca).aumentarMovimento();
                      rodada++;

                    }
                  }
                } while (!destinoVerificado);
              }
            } else {

              for (i = 0; i < pecas.size(); i++) {
                Peca piece = pecas.get(i);

                if (piece.getPosX() == linhaSelecionada && piece.getPosY() == colunaSelecionada && piece.getIsBlack()) {
                  indicePeca = i;
                  iconePeca = piece.getIcone();
                  isBlack = piece.getIsBlack();
                  break;
                } else if (piece.getPosX() == linhaSelecionada && piece.getPosY() == colunaSelecionada && piece.getIsWhite()) {
                  casaNaoVazia = true;
                }

              }

              if (!isBlack) {
                System.out.println(GREEN + "--------------------------------------------------------------");

                if (!casaNaoVazia) {
                  System.out.println(GREEN + "- " + RED + "Você selecionou uma casa VAZIA! Selecione uma peça " + CYAN + "PRETA" + GREEN + "!  -");
                } else {
                  System.out.println(GREEN + "- " + RED + "Você selecionou uma peça " + RED_BRIGHT + "BRANCA" + GREEN + "! " + RED + "Selecione uma peça " + CYAN + "PRETA" + GREEN + "!  -");
                }
                pressToContinue(input);
              }

              if (isBlack) {

                do {

                  imprimirTabuleiro(pecas, linhaSelecionada, colunaSelecionada);
                  System.out.println(
                      GREEN + "- PECA SELECIONADA: " + iconePeca + "                                        -");

                  System.out.println(GREEN + "--------------------------------------------------------------");
                  System.out.println(GREEN + "- DIGITE " + BLUE + "\"VOLTAR\" " + GREEN
                      + "PARA SELECIONAR OUTRA PEÇA:                -");
                  System.out.println(GREEN + "- " + BLUE + "COORDENADAS ENTRE A1 e H8" + GREEN
                      + "                                  -");
                  System.out.print(GREEN + "- SELECIONE A COORDENADA DE DESTINO: ");
                  pecaDestino = input.nextLine();

                  if (pecaDestino.equalsIgnoreCase("VOLTAR")) {
                    break;
                  }

                  if (pecaDestino.length() != 2 || !Character.isLetter(pecaDestino.charAt(0))
                      || !Character.isDigit(pecaDestino.charAt(1))) {
                    System.out.println(
                        GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                    pressToContinue(input);
                  } else {
                    linhaDestino = pecaDestino.toUpperCase().charAt(0) - 65;
                    colunaDestino = pecaDestino.charAt(1) - 49;

                    if ((linhaDestino < 0 || linhaDestino > 7) || (colunaDestino < 0 || colunaDestino > 7)) {
                      System.out.println(
                          GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                      pressToContinue(input);
                    } else {

                      destinoVerificado = pecas.get(indicePeca).moverPeca(pecas, linhaDestino, colunaDestino);

                      if (!destinoVerificado) {
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!" + GREEN
                            + "                                -");
                        pressToContinue(input);
                        break;
                      }

                      // Atualizar a posição da peça caso tenha capturado um inimigo
                      for (i = 0; i < pecas.size(); i++) {
                        Peca piece = pecas.get(i);

                        if (piece.getPosX() == linhaDestino && piece.getPosY() == colunaDestino && piece.getIsBlack()) {
                          indicePeca = i;
                          break;
                        }
                      }

                      pecas.get(indicePeca).aumentarMovimento();
                      rodada++;
                    }
                  }
                } while (!destinoVerificado);
              }
            }
          }
        }
      } while (!pecaSelecionada.equalsIgnoreCase("SAIR"));
    }
  }
}