import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getPhoneNumber(), person.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + "\n"
                + "LastName: " + getLastName() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Phone number: " + getPhoneNumber();
    }

    public static void main(String[] args) {
        Person me = new Person("Roman", "Romaniuk", "out1aw@yahoo.com", "(858)353-5142");
        Person me1 = new Person("Roman", "Romaniuk", "out1aw@yahoo.com","(858)353-5142");
        Person notme = new Person("Roman1", "Romaniuk", "out1aw@yahoo.com","(858)353-5142");//with one small mistake in FirstName -> no more equals
        Person notme1 = new Person(null, null, null, null);
        Person test = new Person("Test", "Test", "test@gmail.com", "111-111");

//        System.out.println(me.equals(me1));//true since it compares values
//        System.out.println(me==me1);//false since it compares address in memory
//        System.out.println(me.equals(notme));//false since values are different
//        System.out.println(me.equals(notme1));
//
//        System.out.println(me.phoneNumber);// will compile in this case, but if it would be different class, wouldnt compile since phoneNUmber set as a private
//                                            // so proper way to do this underneath
//        System.out.println(me.getPhoneNumber());// with getters we can keep our phoneNumber variable and other variables safe from changes and still get the information
//        //But with setter methods we can change value of variables from other classes, even though they are private
//        me.setEmail("123@gmail.com");
//        System.out.println("new email for me: " + me.getEmail());//email var has changed
//        System.out.println(me1.getEmail());
//        //now in me and me1 different emails since we changed them, therefore ->
//        System.out.println(me.equals(me1));//same line that was true before now false since values are different


        DayTimer dt = new DayTimer();
        dt.add(new Person("aaa", "aaa", "aaa@aaa.com", "1111111"));
        dt.add(new Person("zzz", "zzz", "zzz@zzz.com", "6666666"));
        dt.add(new Person("ddd", "ddd", "ddd@ddd.com", "4444444"));
        dt.add(new Person("ccc", "ccc", "ccc@ccc.com", "3333333"));
        dt.add(new Person("ooo", "bbb", "ooo@ooo.com", "5498439"));
        dt.add(new Person("bbb", "bbb", "bbb@bbb.com", "2222222"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        dt.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));

        dt.getSize();
        dt.printAll();
        System.out.println();
        dt.getSortedListByLastName();
        dt.printAll();
        System.out.println();
        System.out.println(dt.getAuthor());
        System.out.println();
        dt.findByEmail("yyy@yyy.com");
        System.out.println();
        dt.find("bbb");
        System.out.println();
















    }
}






