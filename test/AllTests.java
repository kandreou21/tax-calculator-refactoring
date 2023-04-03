import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({incometaxcalculator.data.management.TaxpayerManagerTest.class, incometaxcalculator.data.management.TaxpayerTest.class, incometaxcalculator.gui.TaxpayerDataTest.class})
public class AllTests {

}
