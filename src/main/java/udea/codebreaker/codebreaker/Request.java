package udea.codebreaker.codebreaker;

public class Request {
	private String secret;
	
	public Request(String secret) {
		this.secret =  secret;
	}
	
	public Request() {}
	
	public String getSecret() {
		return secret;
	}
	
	public void setCode(String secret) {
		this.secret = secret;
	}
}
