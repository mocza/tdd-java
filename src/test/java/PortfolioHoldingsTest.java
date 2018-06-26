import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 5/20/2018.
 */
public class PortfolioHoldingsTest {

    @Test
    public void test1() throws Exception {
        assertEquals(3, PortfolioHoldings.countHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));

    }


    @Test
    public void test2() throws Exception {
        assertEquals("[GOOG, Google, 15],[MSFT, Microsoft, 12],[VOD, Vodafone, 10]" , PortfolioHoldings.printHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));

    }


    @Test
    public void test3() throws Exception {
        assertEquals( " [SELL, GOOG, 5.00], [BUY, MSFT, 13.00], [BUY, VOD, 6.00]" , PortfolioHoldings.generateTransactions("VOD,Vodafone,10:VOD,Vodafone,16|GOOG,Google,15:GOOG,Google,10|MSFT,Microsoft,12:MSFT,Microsoft,25"));

    }


}
