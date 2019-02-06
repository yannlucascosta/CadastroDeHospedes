/*Essa classe serve esfecificamente para tratar exceções da classe <Reservation>
 * A classe <Exception> do tipo <serializable> precisa de um número de versão
 * */
package model.exceptions;

public class ReservationExcecoes extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	/*Construtor da classe*/
	public ReservationExcecoes(String message) {
		super(message);
	}
}
