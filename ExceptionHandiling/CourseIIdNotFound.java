package springBoot_CollageProject.ExceptionHandiling;

public class CourseIIdNotFound extends RuntimeException
{
	private String fetchMessage = "Course id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
