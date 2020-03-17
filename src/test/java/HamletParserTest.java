import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class HamletParserTest {
    private String name;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.name = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String name = hamletParser.changeHamlet("Leon");
        Integer expected=0;
        Integer actual = hamletParser.countHamlet(hamletParser.changeHamlet("Leon"));
        assertEquals(expected,actual);
        assertTrue(name.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String name= hamletParser.changeHoratio("Tariq");
        Integer expected=0;
        Integer actual= hamletParser.countHoratio(hamletParser.changeHoratio("Tariq"));
        assertEquals(expected, actual);
        assertTrue(name.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        Integer expected= 158;
        Integer actual =hamletParser.countHoratio(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        Integer expected= 472;
        Integer actual= hamletParser.countHamlet(name);
        assertEquals(expected, actual);
    }
}