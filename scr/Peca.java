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

  // Lembrando que o @Override sobrepõe todo o void da classe Peca

  // void moverPeca() --> primeiro a ser chamado, dentro dessa função irá chamar as 3 seguintes funções:

  // EXCEÇÕES: 
  // Para o movimento Roque a colisao com aliado deverá ser verdadeiro para realizar o movimento
  // Para promoção de Peões pode ser com captura ou sem, sendo o movimento válido para ambos --> realizar a escolha da nova peça no Main
  // Após realizar o movimento imprimir na tela as opções das peças e mudar o icone

  // void verificarMovimento() --> apenas verificar se a peça pode andar até a coordenada selecionada
  // void verificarColisaoAliado() --> apenas verificar se no caminho da peça existe alguma outra peça no caminho (exceção cavalo)
  // void verificarCaptura() --> apenas verificar se a peça selecionada ao ir para o destino irá matar uma peça inimiga

  public boolean verificarMovimento(List<Peca> pecas, int linha, int coluna) {

    return true;
  }

  public boolean verificarColisaoAliado(List<Peca> pecas, int linha, int coluna) {
    
    return true;
  }

  public boolean verificarCaptura(List<Peca> pecas, int linha, int coluna) {
    
    return true;
  }

}
