public class Student {

    private String id;
    private String name;
    private int grade;
    private int coursesNum;
    private GradeCard gradeCard;

    public Student() {
        id = "0000000";
        name = "000";
        grade = 0;
        gradeCard = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCoursesNum() {
        return coursesNum;
    }

    public void setCoursesNum(int coursesNum) {
        this.coursesNum = coursesNum;
    }

    public GradeCard getGradeCard() {
        return gradeCard;
    }

    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }

    @Override
    public String toString() {
        return "--- 학생 프로필 ---\n" +
                "이름: " + name + "\n" +
                "학번: " + id + "\n" +
                "학년: " + grade + "\n" +
                "평균 점수: " + gradeCard.getMean() + "\n";
    }
}
