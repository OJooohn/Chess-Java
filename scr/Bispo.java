import java.util.List;

public class Bispo extends Peca{

	Bispo(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

  @Override
  public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {

    boolean movimentoVerificado = verificarMovimento(pecas, linha, coluna);
    boolean verificarNaoColisaoAliado;

    System.out.println("bispaiada do capeta");

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

    //System.out.println("deltaX = " + deltaX + " | deltaY = " + deltaY);
    //System.out.println("getposX() = " + getPosX() + " | getposY() = " + getPosY());

    if (deltaX == deltaY) {
      
      if (!Xnegativo && !Ynegativo) {
        for (i = getPosX() - 1; i >= linha; i--) {
          for (j = getPosY() - 1; j >= coluna; j--) {
            System.out.println("i(X) = " + i + " | j(Y) = " + j);
            //System.out.println("Peca = " + pecas.get(i).getIcone() + " X = " + pecas.get(i).getPosX() + " | Y = " + pecas.get(i).getPosY());
            for (Peca pieces : pecas) {
              if (getIsWhite()) {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                  System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              } else {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                  //System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              }
            }
          }
        }
      } else if (Xnegativo && Ynegativo) {
        for (i = getPosX() + 1; i <= linha; i++) {
          for (j = getPosY() + 1; j <= coluna; j++) {
            System.out.println("i(X) = " + i + " | j(Y) = " + j);
            //System.out.println("Peca = " + pecas.get(i).getIcone() + " X = " + pecas.get(i).getPosX() + " | Y = " + pecas.get(i).getPosY());
            for (Peca pieces : pecas) {
              if (getIsWhite()) {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                  System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              } else {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                  //System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              }
            }
          }
        }
      } else if (Xnegativo && !Ynegativo) {
        for (i = getPosX() + 1; i <= linha; i++) {
          for (j = getPosY() - 1; j >= coluna; j--) {
            System.out.println("i(X) = " + i + " | j(Y) = " + j);
            //System.out.println("Peca = " + pecas.get(i).getIcone() + " X = " + pecas.get(i).getPosX() + " | Y = " + pecas.get(i).getPosY());
            for (Peca pieces : pecas) {
              if (getIsWhite()) {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                  System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              } else {
                if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                  //System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                  return false;
                } else {
                  verificado = true;
                }
              }
            }
          }
        }
      } else if (!Xnegativo && Ynegativo) {
          for (i = getPosX() - 1; i >= linha; i--) {
            for (j = getPosY() + 1; j <= coluna; j++) {
            System.out.println("i(X) = " + i + " | j(Y) = " + j);
                for (Peca pieces : pecas) {
                  if (getIsWhite()) {
                    if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsWhite()) {
                      System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                      return false;
                    } else {
                      verificado = true;
                    }
                  } else {
                    if (pieces.getPosX() == i && pieces.getPosY() == j && pieces.getIsBlack()) {
                      System.out.println("Peca = " + pieces.getIcone() + " X = " + pieces.getPosX() + " | Y = " + pieces.getPosY());
                      return false;
                    } else {
                      verificado = true;
                    }
                  }
                }
            }
          }
        }
    }

    if(!verificado) {
      if(getIsWhite()) {
        for (Peca piece : pecas) {
          if (piece.getPosX() == i && piece.getPosY() == j && piece.getIsWhite()) {
            return false;
          } else {
            verificado = true;
          }
        }
      } else {
        for (Peca piece : pecas) {
          if (piece.getPosX() == i && piece.getPosY() == j && piece.getIsBlack()) {
            return false;
          } else {
            verificado = true;
          }
        }
      }
      
      System.out.println("i = " + i + " | linha = " + linha + " | j = " + j + " | coluna = " + coluna);
      if (i == linha && j == coluna) {
        return true;
      }
    } else {
      return true;
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
