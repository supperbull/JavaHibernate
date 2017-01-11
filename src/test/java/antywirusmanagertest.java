import domain.pakiet;
import domain.antywirus;
import service.antywirusmanager;
import java.lang.*;
import java.lang.Object;
import java.util.List;
import java.util.Random;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import service.Iantywirusmanager;

/**
 * Created by Redbullek on 2017-01-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class antywirusmanagertest {
    private String randomString="";

    @Autowired
    private Iantywirusmanager antywirusmanager;

    @Before
    public void setUp() throws Exception {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        randomString= sb.toString();
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void addpakiet() throws Exception {
       pakiet PAKIECIK=new pakiet();
        PAKIECIK.setNazwapakiet("Ultimate");
        PAKIECIK.setfunkcje("Wszystkie");
        PAKIECIK.setcena(199.9);

        Long idM= antywirusmanager.addpakiet(PAKIECIK);
        assertEquals(PAKIECIK.getNazwapakiet(),antywirusmanager.findByNazwa(PAKIECIK.getNazwapakiet()).getPakiety());
    }
    @Test
    public void addantywirus() throws Exception {
        antywirus ANTYWIR=new antywirus();
        ANTYWIR.setnazwaantywirus(randomString);
        ANTYWIR.setOpis("Codzoenny uzytek");
        ANTYWIR.setocena(3.5);
        antywirusmanager.addantywirus(ANTYWIR);
        assertEquals(ANTYWIR.getnazwaantywirus(),antywirusmanager
                                                                .findByNazwa(ANTYWIR.getnazwaantywirus())
                                                                .getPakiety());

    }




}