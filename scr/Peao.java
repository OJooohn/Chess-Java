import java.util.List;

public class Peao extends Peca{

	Peao(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

  @Override
  public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {

    boolean movimentoVerificado = verificarMovimento(pecas, linha, coluna);
    boolean verificarNaoColisaoAliado;
    
    if (movimentoVerificado) {
      verificarNaoColisaoAliado = verificarColisaoAliado(pecas, linha, coluna);
    } else {
      return false;
    }

    if (verificarNaoColisaoAliado) {
      verificarCaptura(pecas, linha, coluna);
    }

    if (verificarNaoColisaoAliado) {
      setPosX(linha);
      setPosY(coluna);
      return true;
    } else {
      return false;
    }

  }

  @Override
  public boolean verificarMovimento(List<Peca> pecas, int linha, int coluna) {
    boolean movimentoDiagonalDireita = false;
    boolean movimentoDiagonalEsquerda = false;
    boolean inimigoFrente = false;
    
    // SE A PEÇA FOR BRANCA
    if(getIsWhite()) {

      if(getPosX() == 6 && (getPosX() - linha == 2 && getPosY() == coluna)) {
        for (Peca piece : pecas) {
          if(piece.getPosY() == getPosY() && piece.getPosX() + 1 == getPosX()) {
            return false;
          }
          if (piece.getIsBlack() && (piece.getPosX() == linha && piece.getPosY() == coluna)) {
            return false;
          }
        }

        return true;
      }

      // Verificar se o movimento na diagonal terá um inimigo
      for (Peca piece : pecas) {
        if (piece.getIsBlack() && (getPosX() - 1 == piece.getPosX() && getPosY() + 1 == piece.getPosY())) {
          movimentoDiagonalDireita = true;
        }
        if (piece.getIsBlack() && (getPosX() - 1 == piece.getPosX() && getPosY() - 1 == piece.getPosY())) {
          movimentoDiagonalEsquerda = true;
        }
      }

      if (movimentoDiagonalDireita && movimentoDiagonalEsquerda) {
        if ((getPosX() - linha == 1 && getPosY() - coluna == -1) || (getPosX() - linha == 1 && getPosY() - coluna == 1)) {
          return true;
        }
      }

      if (movimentoDiagonalDireita) {
        if (getPosX() - linha == 1 && getPosY() - coluna == -1) {
          return true;
        }
      }

      if (movimentoDiagonalEsquerda) {
        if (getPosX() - linha == 1 && getPosY() - coluna == 1) {
          return true;
        }
      }

      if (getPosX() - linha == 1 && getPosY() == coluna) {

        System.out.println("teste");

        // Verificar se tem inimigo na frente do Peão
        for (Peca piece : pecas) {
          if (piece.getIsBlack() && (getPosX() - piece.getPosX() == 1 && piece.getPosY() == getPosY())) {
            return false;
          }
        }
  
        if (!inimigoFrente) {
          if (getPosY() == coluna && getPosX() - linha == 1) {
            return true;
          }
        }
      } else {
        return false;
      }

    } else {

      if(getPosX() == 1 && (getPosX() - linha == -2 && getPosY() == coluna)) {
        for (Peca piece : pecas) {
          if(piece.getPosY() == getPosY() && piece.getPosX() - 1 == getPosX()) {
            return false;
          }
        }

        return true;
      }

      for (Peca piece : pecas) {
        if (piece.getIsWhite() && (getPosX() + 1 == piece.getPosX() && getPosY() + 1 == piece.getPosY())) {
          movimentoDiagonalDireita = true;
        }
        if (piece.getIsWhite() && (getPosX() + 1 == piece.getPosX() && getPosY() - 1 == piece.getPosY())) {
          movimentoDiagonalEsquerda = true;
        }
      }

      if (movimentoDiagonalDireita && movimentoDiagonalEsquerda) {
        System.out.println("D ambos");
        if ((getPosX() - linha == -1 && getPosY() - coluna == -1) || (getPosX() - linha == -1 && getPosY() - coluna == 1)) {
          return true;
        }
      }

      if (movimentoDiagonalDireita) {
        System.out.println("D Direita");
        if (getPosX() - linha == -1 && getPosY() - coluna == -1) {
          System.out.println("sim");
          return true;
        }
      }

      if (movimentoDiagonalEsquerda) {
        System.out.println("D Esquerda");
        if (getPosX() - linha == -1 && getPosY() - coluna == 1) {
          return true;
        }
      }

      if (getPosX() - linha == -1 && getPosY() == coluna) {

        // Verificar se tem inimigo na frente do Peão
        for (Peca piece : pecas) {
          if (piece.getIsWhite() && (getPosX() - piece.getPosX() == -1 && piece.getPosY() == getPosY())) {
            return false;
          }
        }
  
        if (!inimigoFrente) {
          if (getPosY() == coluna && getPosX() - linha == -1) {
            return true;
          }
        }
      } else {
        return false;
      }

    }

    return true;
  }

  @Override
  public boolean verificarColisaoAliado(List<Peca> pecas, int linha, int coluna) {

    if (getIsWhite()) {

      for (Peca piece : pecas) {
        if (piece.getIsWhite() && (piece.getPosY() == coluna && piece.getPosX() == linha)) {
          return false;
        }
      }

      return true;

    } else {

      for (Peca piece : pecas) {
        if (piece.getIsBlack() && (piece.getPosY() == coluna && piece.getPosX() == linha)) {
          System.out.println("Peca = " + piece.getIcone() + " | X = " + piece.getPosX() + " | Y = " + piece.getPosY());
          return false;
        }
      }

    }

    return true;
  }

  @Override
  public boolean verificarCaptura(List<Peca> pecas, int linha, int coluna) {

    int i;

    if (getIsWhite()) {
        for (i = 0; i < pecas.size(); i++) {
          Peca piece = pecas.get(i);
          if(piece.getIsBlack() && (piece.getPosX() == linha && piece.getPosY() == coluna)) {
            pecas.remove(i);
            return true;
          }
        }
    } else {
      for (i = 0; i < pecas.size(); i++) {
        Peca piece = pecas.get(i);
        if(piece.getIsWhite() && (piece.getPosX() == linha && piece.getPosY() == coluna)) {
          pecas.remove(i);
          return true;
        }
      }
    }

  return false;
  }
  
}
