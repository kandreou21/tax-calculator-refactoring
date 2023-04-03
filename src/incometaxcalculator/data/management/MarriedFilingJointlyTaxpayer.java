package incometaxcalculator.data.management;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {
  
  private static final double incomeConstants[] = {0, 36080, 90000, 143350, 254240};
  private static final double addConstants[] = {0, 1930.28, 5731.64, 9492.82, 18197.69};
  private static final double mulConstants[] = {0.0535, 0.0705, 0.0705, 0.0785, 0.0985};

  public MarriedFilingJointlyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income, incomeConstants, addConstants, mulConstants);
  }
}