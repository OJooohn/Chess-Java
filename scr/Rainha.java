import java.util.List;

public class Rainha extends Peca{

	Rainha(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
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
			aumentarMovimento();
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

		if (getPosX() == linha || getPosY() == coluna) {
			if(getPosX() == linha) {
        if (getPosY() - coluna < 0) {
          for (i = getPosY() + 1; i < coluna; i++) {
            for (Peca piece : pecas) {
              if (piece.getPosY() == i && piece.getPosX() == getPosX()) {
                colisao = true;
                break;
              }
            }
          }
        } else {
          for (i = getPosY() - 1; i > coluna; i--) {
            for (Peca piece : pecas) {
              if (piece.getPosY() == i && piece.getPosX() == getPosX()) {
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
              if(piece.getPosX() == i && piece.getPosY() == getPosY()) {
                colisao = true;
                break;
              }
            }
          }
        } else {
          for (i = getPosX() - 1; i > linha; i--) {
            for (Peca piece : pecas) {
              if (piece.getPosX() == i && piece.getPosY() == getPosY()) {
                colisao = true;
                break;
              }
            }
          }
        }
      }

			if (!colisao) {
				return true;
			} else {
				return false;
			}
		} else if (deltaX == deltaY) {
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
