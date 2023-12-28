package springBoot_CollageProject.ExceptionHandiling;

public class CollageIdNotFound extends RuntimeException
{
	private String fetchMessage = "Collage id not found";
	
	public String getFetchMessage() {
		return fetchMessage;
	}
}
