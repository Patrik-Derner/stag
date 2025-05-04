package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Main2Test
{
    @Test
    void test01()
    {
        assertEquals(
                252,
                Main2.maxPersonsCount("KIKM",2024)
        );
    }
}