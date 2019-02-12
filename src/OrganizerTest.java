import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
public class OrganizerTest
{
    public static final Person SORTED[] =
            {
                    new Person("aaa", "aaa", "aaa@aaa.com", "1111111"),
                    new Person("bbb", "bbb", "bbb@bbb.com", "2222222"),
                    new Person("ccc", "ccc", "ccc@ccc.com", "3333333"),
                    new Person("ddd", "ddd", "ddd@ddd.com", "4444444"),
                    new Person("yyy", "yyy", "yyy@yyy.com", "5555555"),
                    new Person("zzz", "zzz", "zzz@zzz.com", "6666666"),
            };
    public static final Person SORTED_CCC[] =
            {
                    new Person("ccc", "ccc", "ccc@ccc.com", "3333333"),
                    new Person("ddd", "CCC", "ddd@ddd.com", "4444444"),
                    new Person("yyy", "CcC", "yyy@yyy.com", "5555555"),
            };
    @Before
    public void setUp()
    {
        this.organizer = new DayTimer();
    }
    @After
    public void tearDown()
    {
        System.out.println("This was implemented by: " + ((WhoDoneIt) this.organizer).getAuthor());
    }
    @Test
    public void testBasic()
    {
        this.organizer.add(new Person("aaa", "aaa", "aaa@aaa.com", "1111111"));
        this.organizer.add(new Person("zzz", "zzz", "zzz@zzz.com", "6666666"));
        this.organizer.add(new Person("ddd", "ddd", "ddd@ddd.com", "4444444"));
        this.organizer.add(new Person("ccc", "ccc", "ccc@ccc.com", "3333333"));
        this.organizer.add(new Person("bbb", "bbb", "bbb@bbb.com", "2222222"));
        this.organizer.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        Person[] sortedList = this.organizer.getSortedListByFirstName();
        for(int i = 0; i < sortedList.length; i++)
        {
            assertEquals("Sort by First Name Test Failed!", SORTED[i], sortedList[i]);
        }
        this.organizer.empty();

        // Testing empty and getSize
        assertEquals("Failed empty or getSize() test!", this.organizer.getSize(), 0);
        this.organizer.add(new Person("aaa", "aaa", "aaa@aaa.com", "1111111"));
        this.organizer.add(new Person("zzz", "zzz", "zzz@zzz.com", "6666666"));
        this.organizer.add(new Person("ddd", "ddd", "ddd@ddd.com", "4444444"));
        this.organizer.add(new Person("ccc", "ccc", "ccc@ccc.com", "3333333"));
        this.organizer.add(new Person("bbb", "bbb", "bbb@bbb.com", "2222222"));
        this.organizer.add(new Person("yyy", "yyy", "yyy@yyy.com", "5555555"));
        sortedList = this.organizer.getSortedListByLastName();
        for(int i = 0; i < sortedList.length; i++)
        {
            assertEquals("Sortby Last Name Test Failed!", SORTED[i], sortedList[i]);
        }
        this.organizer.add(new Person("ccc", "ccc", "ccc@ccc.com", "3333333"));
        sortedList = this.organizer.getSortedListByLastName();
        for(int i = 0; i < sortedList.length; i++)
        {
            assertEquals("Failed duplicate test!", SORTED[i], sortedList[i]);
            System.out.println(sortedList[i]);
        }
        Person toRemove = organizer.findByEmail("zzz@zzz.com");
        assertNotNull("Failed findByEmail Test!", toRemove);
        if(toRemove != null)
        {
            this.organizer.remove("zzz@zzz.com");
            Person removed = organizer.findByEmail("zzz@zzz.com");
            assertNull("Failed remove Test!", removed);
            assertEquals("Failed remove or getSize() test!", this.organizer.getSize(), SORTED.length -1);
            sortedList = this.organizer.getSortedListByLastName();
            for(int i = 0; i < sortedList.length; i++)
            {
                //System.out.println(sortedList[i]);
                assertEquals("Failed duplicate test!", SORTED[i], sortedList[i]);
            }
        }
        Person[] allCCC = organizer.find("ccc");
        for(int i = 0; i < allCCC.length; i ++)
        {
            assertEquals("Failed find by last name test!", SORTED_CCC[i], allCCC[i]);
        }
        this.organizer.add(new Person("ddd", "CCC", "ddd@ddd.com", "4444444"));
        this.organizer.add(new Person("yyy", "CcC", "yyy@yyy.com", "5555555"));
        for(int i = 0; i < allCCC.length; i ++)
        {
            assertEquals("Failed find by last name test!", SORTED_CCC[i], allCCC[i]);
        }
        this.organizer.empty();
    }
    private Organizer organizer;
    private WhoDoneIt author;
}