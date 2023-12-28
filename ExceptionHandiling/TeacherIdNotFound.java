package springBoot_CollageProject.ExceptionHandiling;

public class TeacherIdNotFound extends RuntimeException
{
	private String fetchMessage = "Teacher id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
