import java.util.List;

public class Bispo extends Peca{

	Bispo(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

  @Override
  public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {

    boolean movimentoVerificado = verificarMovimento(pecas, linha, coluna);


    if (movimentoVerificado) {
      verificarCaptura(pecas, linha, coluna);
      setPosX(linha);
      setPosY(coluna);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean verificarMovimento(List<Peca> pecas, int linha, int coluna) {

    boolean verificado = false;
    boolean Xnegativo = false, Ynegativo = false;

    int deltaX, deltaY;
    int i = -1, j = -1;

    deltaX = getPosX() - linha;
    deltaY = getPosY() - coluna;

    if (deltaX < 0) {
      deltaX *= -1;
      Xnegativo = true;
    } 
    if (deltaY < 0) {
      deltaY *= -1;
      Ynegativo = true;
    }

    if (deltaX == deltaY) {
      
      if (!Xnegativo && !Ynegativo) {
        i = getPosX() - 1;
        j = getPosY() - 1;
        do {
          for (Peca pieces : pecas) {
            if (getIsWhite()) {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                return false;
              } else {
                verificado = true;
              }
            } else {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                return false;
              } else {
                verificado = true;
              }
            }
          }
          i--;
          j--;
        } while (i >= linha && j >= coluna);
        
      } else if (Xnegativo && Ynegativo) {

        i = getPosX() + 1;
        j = getPosY() + 1;

        do {
          for (Peca pieces : pecas) {
            if (getIsWhite()) {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                return false;
              } else {
                verificado = true;
              }
            } else {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                return false;
              } else {
                verificado = true;
              }
            }
          }
          i++;
          j++;
        } while (i <= linha && j <= coluna);
        
      } else if (Xnegativo && !Ynegativo) {

        i = getPosX() + 1;
        j = getPosY() - 1;

        do {
          for (Peca pieces : pecas) {
            if (getIsWhite()) {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                return false;
              } else {
                verificado = true;
              }
            } else {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                return false;
              } else {
                verificado = true;
              }
            }
          }
          i++;
          j--;
        } while (i <= linha && j >= coluna);
        
      } else if (!Xnegativo && Ynegativo) {
        i = getPosX() - 1;
        j = getPosY() + 1;

        do {
          for (Peca pieces : pecas) {
            if (getIsWhite()) {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                return false;
              } else {
                verificado = true;
              }
            } else {
              if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                return false;
              } else {
                verificado = true;
              }
            }
          }
          i--;
          j++;
        } while (i <= linha && j <= coluna);
      }

      return verificado;

    }

    return false;
  }

  @Override
  public boolean verificarColisaoAliado(List<Peca> pecas, int linha, int coluna) {

    return super.verificarColisaoAliado(pecas, linha, coluna);
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
