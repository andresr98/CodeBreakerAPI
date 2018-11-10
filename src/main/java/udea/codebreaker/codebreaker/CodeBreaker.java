package udea.codebreaker.codebreaker;


import java.util.Random;

public class CodeBreaker {
	
	private String secret;
	private String result;
	
	public CodeBreaker() {
			String generador="";
			Random random = new Random();
			String ran = "";
			int i=0;
			while(i<4) {
				ran = String.format("%01d", random.nextInt(10));
				if (!generador.contains(ran)) {
					generador+=ran;
					i++;
				}
			}
			this.secret = generador;
	}
	
	public CodeBreaker(String secret) {
		this.secret = secret;
	} 

	public boolean longitudeNumber(String number) {
		
		return (number!=null) && (number.length()==4);
	}
	
	public boolean validateNumeric(String number)  {				
		boolean result;
		try {
			Integer.parseInt(number);
			result=true;
		} catch (NumberFormatException c){
			result=false;
		}
		return result;
	}
	
	public String validarCoincidencia(String number){
		
		this.result ="";
		String aux_ = "";
		
		for(int i = 0; i < secret.length(); i++) {			
			if(secret.charAt(i) == number.charAt(i)) {
				this.result += "X";
			}else if(secret.contains(number.substring(i, i+1))) {				
				aux_ += "_";
			}
		}
		this.result += aux_;
		return this.result;
	}
	
	public String getResult() {
		return result;
	}
	
	public String getSecret() {
		return this.secret;
	}
}

