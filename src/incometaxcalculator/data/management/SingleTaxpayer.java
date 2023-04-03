package incometaxcalculator.data.management;

public class SingleTaxpayer extends Taxpayer {

  private static final double[] incomeConstants = {0, 24680, 81080, 90000, 152540};
  private static final double[] addConstants = {0, 1320.38, 5296.58, 5996.80, 10906.19};
  private static final double[] mulConstants = {0.0535, 0.0705, 0.0785, 0.0785, 0.0985};
  
  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income, incomeConstants, addConstants, mulConstants);
  }

}