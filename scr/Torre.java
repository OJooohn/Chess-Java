import java.util.List;

public class Torre extends Peca{

	Torre(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

  @Override
  public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {
    
    boolean movimentoVerificado = verificarMovimento(pecas, linha, coluna);
    boolean verificarNaoColisaoAliado = false;

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

    boolean colisao = false;
    int i;

    if (getPosX() == linha || getPosY() == coluna) {

      if(getPosX() == linha) {
        if (getPosY() - coluna < 0) {
          for (i = getPosY() + 1; i < coluna; i++) {
            for (Peca piece : pecas) {
              if (getPosY() == i && piece.getPosX() == getPosX()) {
                colisao = true;
                break;
              }
            }
          }
        } else {
          for (i = getPosY() - 1; i > coluna; i--) {
            for (Peca piece : pecas) {
              if (getPosY() == i && piece.getPosX() == getPosX()) {
                colisao = true;
                break;
              }
            }
          }
        }
      } else if (getPosY() == coluna) {
        if (getPosX() - linha < 0) {
          for (i = getPosX() + 1; i < linha; i++) {
            for (Peca piece : pecas) {
              if(getPosX() == i && piece.getPosY() == getPosY()) {
                colisao = true;
                break;
              }
            }
          }
        } else {
          for (i = getPosX() - 1; i > linha; i--) {
            for (Peca piece : pecas) {
              if (getPosX() == i && piece.getPosY() == getPosY()) {
                colisao = true;
                break;
              }
            }
          }
        }
      }
    }

    if (!colisao) {
      return true;
    }
    
    return false;
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
