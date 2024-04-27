import java.util.List;

public class Rei extends Peca{

	Rei(int posX, int posY, char icone, boolean isBlack, boolean isWhite) {
		super(posX, posY, icone, isBlack, isWhite);
	}

	public boolean verificarCastling(List<Peca> pecas, int linha, int coluna) {

		boolean torreDireita = false, torreEsquerda = false;
		int i = 0, indiceTorre = 0;

		int Xdireita, Ydireita, Xesquerda, Yesquerda;

		if (getIsWhite()) {
			Xdireita = 7; Ydireita = 7;
			Xesquerda = 7; Yesquerda = 0;
		} else {
			Xdireita = 0; Ydireita = 7;
			Xesquerda = 0; Yesquerda = 0;
		}

		if ( (linha == Xesquerda && coluna == Yesquerda) || (linha == Xdireita && coluna == Ydireita)) {
			if (getMovimentos() == 0) {

				if (getIsWhite()) {
					for (i = 0; i < pecas.size(); i++) {
						Peca piece = pecas.get(i);

						if (piece.getMovimentos() == 0 && piece.getIcone() == '♖') {
							if (piece.getPosX() == linha && piece.getPosY() == coluna && (linha == Xdireita && coluna == Ydireita)) {
								torreDireita = true;
								break;
							}
							if (piece.getPosX() == linha && piece.getPosY() == coluna && (linha == Xesquerda && coluna == Yesquerda)) {
								torreEsquerda = true;
								break;
							}
						}
					}
				} else {
					for (i = 0; i < pecas.size(); i++) {
						Peca piece = pecas.get(i);

						if (piece.getMovimentos() == 0 && piece.getIcone() == '♜') {
							if (piece.getPosX() == linha && piece.getPosY() == coluna && (linha == Xdireita && coluna == Ydireita)) {
								torreDireita = true;
								break;
							}
							if (piece.getPosX() == linha && piece.getPosY() == coluna && (linha == Xesquerda && coluna == Yesquerda)) {
								torreEsquerda = true;
								break;
							}
						}
					}
				}

				if (!torreDireita && !torreEsquerda) {
					return false;
				}

				indiceTorre = i;

				if (torreDireita) {
					if (getIsWhite()) {

						for (i = getPosY(); i < 7; i++){

							for (Peca piece : pecas) {
								if (piece.getPosX() == 7 && piece.getPosY() == i && piece.getIcone() != '♖' && piece.getIcone() != '♔') {
									return false;
								}
							}

						}

						setPosY(6);
						pecas.get(indiceTorre).setPosY(5);

					} else {

						for (i = getPosY(); i < 7; i++) {
							for (Peca piece : pecas) {

									if (piece.getPosX() == 0 && piece.getPosY() == i && piece.getIcone() != '♜' && piece.getIcone() != '♚') {
											return false;
									}

							}
						}

						setPosY(6);
						pecas.get(indiceTorre).setPosY(5);

					}
				
					return true;

				}

				if (torreEsquerda) {

					if (getIsWhite()) {

						for (i = getPosY(); i > 0; i--) {
							for (Peca piece : pecas) {
								if (piece.getPosX() == 7 && piece.getPosY() == i && piece.getIcone() != '♖' && piece.getIcone() != '♔') {
                  return false;
                }
							}
						}

						setPosY(2);
						pecas.get(indiceTorre).setPosY(3);
					} else {

						for (i = getPosY(); i > 0; i--) {
							for (Peca piece : pecas) {
								if (piece.getPosX() == 0 && piece.getPosY() == i && piece.getIcone() != '♜' && piece.getIcone() != '♚') {
									return false;
								}
							}
						}

						setPosY(2);
						pecas.get(indiceTorre).setPosY(3);
					}

					return true;
				}

			}

		}

		return false;
	}

	@Override
	public boolean moverPeca(List<Peca> pecas, int linha, int coluna) {

		boolean movimentoVerificado = verificarMovimento(pecas, linha, coluna);
    boolean verificarNaoColisaoAliado = false;
		boolean castling = verificarCastling(pecas, linha, coluna);

		if (castling) {
			aumentarMovimento();
			return true;
		}
		
    
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

		if (getIsWhite()) {

			for (Peca piece : pecas) {
				if (piece.getPosX() == linha && piece.getPosY() == coluna && piece.getIcone() == '♚') {
					return false;
				}
			}

		} else {

			for (Peca piece : pecas) {
				if (piece.getPosX() == linha && piece.getPosY() == coluna && piece.getIcone() == '♔') {
					return false;
				}
			}

		}
	
		return (getPosX() - linha) <= 1 && (getPosX() - linha) >= -1 && (getPosY() - coluna) <= 1 && (getPosY() - coluna) >= -1;
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
          if(piece.getIsBlack() && (piece.getPosX() == linha && piece.getPosY() == coluna) && piece.getIcone() != '♚') {
            pecas.remove(i);
            return true;
          }
        }
    } else {
      for (i = 0; i < pecas.size(); i++) {
        Peca piece = pecas.get(i);
        if(piece.getIsWhite() && (piece.getPosX() == linha && piece.getPosY() == coluna && piece.getIcone() != '♔')) {
          pecas.remove(i);
          return true;
        }
      }
    }

    return false;
	}
  
}
