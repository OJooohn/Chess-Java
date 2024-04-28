import java.util.List;

public class Cavalo extends Peca {

  Cavalo(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
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
    }

    return false;
  }

  @Override
  public boolean verificarMovimento(List<Peca> pecas, int linha, int coluna) {

    if (getPosX() - linha == 2 || getPosX() - linha == -2) {

      if (getPosY() - coluna == 1 || getPosY() - coluna == -1) {
        return true;
      }

    } else {

      if (getPosY() - coluna == 2 || getPosY() - coluna == -2) {

        if (getPosX() - linha == 1 || getPosX() - linha == -1)
          return true;

      } else {
        return false;
      }

    }

    return false;
  }

  @Override
  public boolean verificarCaptura(List<Peca> pecas, int linha, int coluna) {

    int i;

    if (getIsWhite()) {

      for (i = 0; i < pecas.size(); i++) {
        Peca piece = pecas.get(i);

        if (piece.getIsBlack() && (piece.getPosX() == linha && piece.getPosY() == coluna)) {
          pecas.remove(i);
          return true;
        }
      }

    } else {

      for (i = 0; i < pecas.size(); i++) {
        Peca piece = pecas.get(i);

        if (piece.getIsWhite() && (piece.getPosX() == linha && piece.getPosY() == coluna)) {
          pecas.remove(i);
          return true;
        }
      }

    }

    return false;
  }

}
