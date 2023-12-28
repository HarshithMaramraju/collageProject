package springBoot_CollageProject.ExceptionHandiling;

public class BranchIdNotFound extends RuntimeException
{
	private String fetchMessage = "Branch id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
