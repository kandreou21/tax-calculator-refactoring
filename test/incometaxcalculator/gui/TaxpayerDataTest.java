package incometaxcalculator.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import incometaxcalculator.data.management.TaxpayerManager;

public class TaxpayerDataTest {

  private static TaxpayerManager manager;
  private static TaxpayerData taxpayerData;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    manager = new TaxpayerManager();
    manager.loadTaxpayer("123456789_INFO.txt");
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testSelectTaxpayerHappyDay() {
    taxpayerData = new TaxpayerData(manager.getTaxpayer(123456789).getTaxRegistrationNumber(),manager);   
    assertNotNull(taxpayerData); //chekaro an tha dhmioyrgithei TaxpayerData Object kathos einai h klash pou periexei tis use cases pou mporoun na ektelestoun meta to select
  }

}
