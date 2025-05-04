package pro1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main5Test
{
    @Test
    void test01()
    {
        assertEquals(
                "93240,A3,A4,A5,J1,J10,J11,J12,J13,J14,J15,J17,J2,J20,J21,J22,J23,J24,J28,J3,J30,J31,J6,J8,J9",
                Main5.roomsSummary("KIKM",2024)
        );
    }
}