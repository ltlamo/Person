import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DayTimer implements WhoDoneIt, Organizer {

    List<Person> ls = new ArrayList<Person>();

    @Override
    public void add(Person p) {
        ls.add(p);
    }

    @Override
    public void remove(String email) {
        Person checkedPerson = findByEmail(email);
        if(checkedPerson!=null){
            ls.remove(checkedPerson);
        }

    }

    @Override
    public void empty() {
        ls.clear();

    }


    @Override
    public Person[] find(String lastName) {
        for(Person checkedPerson : this.ls){
            if(checkedPerson.getLastName().equals(lastName)) {
                System.out.println(checkedPerson);
            }
            }
        return new Person[0];
}

    @Override
    public Person findByEmail(String email) {
        for(Person checkedPerson : this.ls){
            if(checkedPerson.getEmail().equals(email)){
                return checkedPerson;
            }
        }
        return null;
    }

    @Override
    public Person[] getSortedListByLastName() {
        Collections.sort(ls, Comparator.comparing(Person::getLastName));
        return new Person[0];
    }

    @Override
    public Person[] getSortedListByFirstName() {
        Collections.sort(ls, Comparator.comparing(Person::getFirstName));
        return new Person[0];
    }

    @Override
    public int getSize() {
        int size = ls.size();
        System.out.println(size);
        return size;
    }

    @Override
    public Person getAuthor() {
        return null;
    }

    public void printAll(){
        for(Person a : this.ls){
            System.out.println(a);
        }
    }
}
