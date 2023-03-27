import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HangmanTest {
    @BeforeEach
    void setUp(){
    }

    @Test
    void printHangedManTest(){

        assertEquals( """
                     +---+
                         |
                         |
                         |
                         |
                         ====
                    """, Hangman.printHangedMan(0), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                         |
                         |
                         |
                         ====
                    """, Hangman.printHangedMan(1), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                     \\   |
                         |
                         |
                         ====
                    """, Hangman.printHangedMan(2), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                     \\ / |
                         |
                         |
                         ====
                    """, Hangman.printHangedMan(3), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                     \\ / |
                      |  |
                         |
                         ====
                    """, Hangman.printHangedMan(4), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                     \\ / |
                      |  |
                     /   |
                         ====
                    """, Hangman.printHangedMan(5), "Print method failed");

        assertEquals( """
                     +---+
                      O  |
                     \\ / |
                      |  |
                     / \\ |
                         ====
                    """, Hangman.printHangedMan(6), "Print method failed");

    }

    @Test
    void printWordStateTest() {
        assertEquals(true, Hangman.printGameState("cat", List.of('a', 'd', 'c', 't')));
    }

    @AfterEach
    void tearDown(){
    }
}
