import java.util.List;

public class Peca extends Main{
 
  private int posX;
  private int posY;
  private int movimentos;
  private char icone;
  private boolean isBlack;
  private boolean isWhite;

  Peca (int posX, int posY, char icone, boolean isBlack, boolean isWhite) {

    this.posX = posX;
    this.posY = posY;

    this.icone = icone;

    this.isBlack = isBlack;
    this.isWhite = isWhite;

    this.movimentos = 0;

  }

  public int getPosX() {
    return this.posX;
  }

  public int getPosY() {
    return this.posY;
  }

  public int getMovimentos() {
    return this.movimentos;
  }

  public char getIcone() {
    return this.icone;
  }

  public boolean getIsBlack() {
    return this.isBlack;
  }

  public boolean getIsWhite() {
    return this.isWhite;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setMovimentos(int movimentos) {
    this.movimentos = movimentos;
  }

  public void setIcone(char icone) {
    this.icone = icone;
  }

  public void setIsBlack(boolean isBlack) {
    this.isBlack = isBlack;
  }

  public void setIsWhite(boolean isWhite) {
    this.isWhite = isWhite;
  }

  public void aumentarMovimento() {
    this.setMovimentos(getMovimentos() + 1);
  }

  public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {

    return true;
  }

  public boolean verificarMovimento(List<Peca> pecas, int linha, int coluna) {

    return false;
  }

  public boolean verificarColisaoAliado(List<Peca> pecas, int linha, int coluna) {
    
    return false;
  }

  public boolean verificarCaptura(List<Peca> pecas, int linha, int coluna) {
    
    return false;
  }

}
