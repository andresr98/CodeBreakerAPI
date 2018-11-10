package udea.codebreaker.codebreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeBreakerController {
	CodeBreaker code;
	String secret = "";
	
	@GetMapping("/guess")
    public Response guess(@RequestParam(value="number", defaultValue="0000") String number) {
        //code = new CodeBreaker(secret);
        Response response;
        
        if(secret.length() == 0) {
        	response = new Response("","No se ha seteado un secret");
        	return response;
        }
        
        if(number.length() != 4 ) {
        	response = new Response("","El código debe ser de 4 digitos");
        	return response;
        }
        
        String result = code.validarCoincidencia(number);
        
        if(result.equals("XXXX")) {
        	response = new Response(code.getResult(),"Ha ganado");
        	return response;
        }
        response = new Response(code.getResult(),"Sigue intentando");
		return response;
    }
	
	@PostMapping("/guess")
	public Response guess(@RequestBody Request request) {
		
		if(request.getSecret().length() != 4 ) {
			code = new CodeBreaker();
			secret = code.getSecret();
			return new Response("", "Se asigno un secret aleatorio. Debido a que el secret es de 4 digitos ");
		}
		
		secret = request.getSecret();
		code = new CodeBreaker(secret);
		return new Response("", "Se cambio el secret");
	}
}