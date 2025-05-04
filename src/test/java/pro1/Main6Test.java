package pro1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main6Test
{
    @Test
    void test01()
    {
        assertEquals(
                244417,
                Main6.idOfBestTeacher("KIKM",2024)
        );
    }
}