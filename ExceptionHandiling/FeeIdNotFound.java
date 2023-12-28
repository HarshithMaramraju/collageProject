package springBoot_CollageProject.ExceptionHandiling;

public class FeeIdNotFound extends RuntimeException
{
	private String fetchMessage = "Fee id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
