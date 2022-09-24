public class Person {

    private String name;
    private Phone phone;

    public Person(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void playGame() {
        System.out.println(phone.getType() + "으로 게임을 합니다.");
    }

    public void sendMessage(Person person) {
        System.out.println(person.getName() + "의 번호 " + person.getPhone().getNumber() + "에 문자를 보냈습니다.");
    }

}
