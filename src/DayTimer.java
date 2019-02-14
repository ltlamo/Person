import java.util.*;
import java.util.stream.Collectors;

public class DayTimer implements WhoDoneIt, Organizer {

    List<Person> ls = new ArrayList<>();
//    Set<Person> set = new HashSet<Person>(ls);

    @Override
    public void add(Person p) {
//        set.add(p);
//        ls.clear();
//        ls.addAll(set);

        ls.add(p);
        ls=ls.stream().distinct().collect(Collectors.toList());
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
                System.out.println(checkedPerson);
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
        return new Person("Roma", "Romaniuk", "out1aw@yahoo.com", "(858)-353-5142");

    }

    public void printAll(){
        for(Person a : ls){
            System.out.println(a);
        }
    }
}
