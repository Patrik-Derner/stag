package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class Main1Test
{
    @Test
    void test01()
    {
        assertEquals(
                0,
                Main1.emptyActionsCount("KIKM",2024)
        );
    }
}