import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class MainTest {
     @BeforeEach
      void setUp(){
     }

     @Test
     void resultTest(){
         assertEquals("Welcome!", Main.result(2));
         assertEquals("""
                     You approach the cave...
                     It is dark and spooky...
                     A large dragon jumps out in front of you! He opens his jaws and...
                     Gobbles you down in one bite!
                     """, Main.result(1));
         assertEquals("Wrong answer!", Main.result(3));
     }

     @AfterEach
     void tearDown(){
     }
 }
