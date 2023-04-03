package incometaxcalculator.data.management;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaxpayerTest {

  private static Taxpayer taxpayer;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    taxpayer = new MarriedFilingJointlyTaxpayer("Kostas", 123, 22570);
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGetVariationTaxOnReceiptsHappyDay() {  //test meioshs forou kalei kai calculateBasicTax, foros sxetizetai mono me apodeikseis(no need to test other types of Taxpayers)
    System.out.println(taxpayer.getVariationTaxOnReceipts());
    assertEquals(96.6, taxpayer.getVariationTaxOnReceipts(), 1e-3);
  }

  @Test
  public void testGetVariationTaxOnReceiptsWrong() {  
    System.out.println(taxpayer.getVariationTaxOnReceipts());
    assertNotEquals(9.6, taxpayer.getVariationTaxOnReceipts());
  }
}
