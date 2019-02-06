/*Essa classe serve esfecificamente para tratar exce��es da classe <Reservation>
 * A classe <Exception> do tipo <serializable> precisa de um n�mero de vers�o
 * */
package model.exceptions;

public class ReservationExcecoes extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	/*Construtor da classe*/
	public ReservationExcecoes(String message) {
		super(message);
	}
}
