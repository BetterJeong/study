package builder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskBuilder taskBuilder1 = new TaskBuilder(999);
		taskBuilder1.setSummary("test");
		taskBuilder1.setDescription("this is a example");
		taskBuilder1.setDone(false);
		
		Task task1 = taskBuilder1.build();
		System.out.println(task1);
	}

}
