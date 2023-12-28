package springBoot_CollageProject.ExceptionHandiling;

public class PrincipalIdNotFound extends RuntimeException
{
	private String fetchMessage = "Principal id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
