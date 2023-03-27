import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    @BeforeEach
     void setUp(){
    }

    @Test
    void checkTest(){
        assertEquals(false, Main.endOfGame(2,19,2,3));
        assertEquals(true, Main.endOfGame(2,2,2,3));
    }

    @Test
    void generateTheNumberTest(){
        for (int i = 0; i < 100; i++) {
            var temp = Main.generateTheNumber();
            if (temp >= 1 && temp <= 20){

            } else {
                assertTrue(false);
            }
        }
    }

    @AfterEach
    void tearDown(){
    }
}