public class Peao extends Peca{

	Peao(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

  @Override
  public boolean verificarMovimento() {
    System.out.println("sobrepondo o void Peca");

    return true;
  }
  
}
