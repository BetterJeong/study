import java.util.Scanner;

public class ScoreManagement {

    public void run() {
        Student student = initStudentInfo();
        Subject[] subjects = initSubjectsInfo(student.getCoursesNum());
        student.setGradeCard(new GradeCard(calculateMean(subjects)));
        System.out.println(student);
    }

    private Student initStudentInfo() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.print("학생의 이름을 입력해주세요 >> ");
        student.setName(sc.next());
        System.out.print("학번을 입력해주세요 >> ");
        student.setId(sc.next());
        System.out.print("학년을 입력해주세요 >> ");
        student.setGrade(sc.nextInt());
        System.out.print("몇 개의 과목을 수강하셨나요? >> ");
        student.setCoursesNum(sc.nextInt());

        return student;
    }

    private Subject[] initSubjectsInfo(int length) {
        Subject[] subjects = new Subject[length];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < subjects.length; i++) {
            Subject s = new Subject();

            System.out.println((i+1)+"번째 과목 입력");
            System.out.print("과목명 >> ");
            s.setName(sc.next());
            System.out.print("점수 >> ");
            s.setScore(sc.nextInt());

            subjects[i] = s;
        }

        return subjects;
    }

    private double calculateMean(Subject[] subjects) {
        int sum = 0;

        for (Subject subject : subjects) {
            sum += subject.getScore();
        }

        return (double) sum / subjects.length;
    }
}
