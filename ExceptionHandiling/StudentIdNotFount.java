package springBoot_CollageProject.ExceptionHandiling;

public class StudentIdNotFount extends RuntimeException {

	private String fetchMessage = "Principal id not found";

	public String getFetchMessage() {
		return fetchMessage;
	}
}
