package springBoot_CollageProject.ExceptionHandiling;

public class AddressIdNotFound extends RuntimeException
{
private String fetchMessage = "Address id not found";
	
	public String getFetchMessage() {
		return fetchMessage;
	}
}
