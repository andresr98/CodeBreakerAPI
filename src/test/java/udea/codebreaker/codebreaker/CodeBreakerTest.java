package udea.codebreaker.codebreaker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBreakerTest {
	public CodeBreaker codeBreaker=new CodeBreaker("1534");

	@Test
	public void validarNumero4Digitos() {
		//Arrange
			String number="1234";
			boolean isValidateNumber=false;
		//Act
			isValidateNumber=codeBreaker.longitudeNumber(number);
		//Assert
			assertTrue(isValidateNumber);
	}
	
	@Test
	public void validarNumero3Digitos() {
		//Arrange
			String number="123";
			boolean isValidateNumber=false;
		//Act
			isValidateNumber=codeBreaker.longitudeNumber(number);
		//Assert			
			assertFalse(isValidateNumber);
	}

	@Test
	public void validarNumeroEsNulo() {
		//Arrange
			String number=null;
			boolean isValidateNumber=false;
		//Act
			isValidateNumber=codeBreaker.longitudeNumber(number);
		//Assert			
			assertFalse(isValidateNumber);
	}
	
	
	@Test
	public void validarDatoNumerico() throws Exception {
		// Arrange
		String number = "abcd";
		boolean isValidateNumber = false;
		// Act
		isValidateNumber = codeBreaker.validateNumeric(number);
		// Assert
		assertFalse(isValidateNumber);
	}
	
	@Test
	public void validarDatoNumericoNull() throws Exception {
		// Arrange
		String number = "";
		boolean isValidateNumber = false;
		// Act
		isValidateNumber = codeBreaker.validateNumeric(number);
		// Assert
		assertFalse(isValidateNumber);
	}
	
	@Test
	public void validarUnaCoincidenciaPos()  {
		// Arrange
		String number = "8838";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("X", result);
	}
	
	@Test
	public void validarDosCoincidenciaPos()  {
		// Arrange
		String number = "1586";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("XX", result);
	}	
	
	@Test
	public void validarTresCoincidenciaPos()  {
		// Arrange
		String number = "1537";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("XXX", result);
	}	
	
	@Test
	public void validarCoincidenciaPosTodos()  {
		// Arrange
		String number = "1534";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("XXXX", result);
	}	
	
	@Test
	public void validarUnaCoincidenciaSinPos()  {
		// Arrange
		String number = "4999";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("_", result);
	}	
	
	@Test
	public void validarDosCoincidenciaSinPos()  {
		// Arrange
		String number = "4993";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("__", result);
	}
	
	@Test
	public void validarTresCoincidenciaSinPos()  {
		// Arrange
		String number = "4953";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("___", result);
	}
	
	@Test
	public void validarCuatroCoincidenciaSinPos()  {
		// Arrange
		String number = "4153";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("____", result);
	}
	
	@Test
	public void validarTresCoincidenciaConUnaPos()  {
		// Arrange
		String number = "5314";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("X___", result);
	}
	
	@Test
	public void validarDosCoincidenciaConDosPos()  {
		// Arrange
		String number = "5134";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("XX__", result);
	}
	
	@Test
	public void validarUnaCoincidenciaConDosPosUnaNoExiste()  {
		// Arrange
		String number = "5934";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("XX_", result);
	}
	@Test
	public void validarDosCoincidenciaConUnaPosUnaNoExiste()  {
		// Arrange
		String number = "5914";
		String result;
		// Act
		result = codeBreaker.validarCoincidencia(number);
		// Assert
		assertEquals("X__", result);
	}
}
