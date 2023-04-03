package incometaxcalculator.data.io;


public class TXTLogWriter extends LogWriter {

  private static final String[] txtLogConstants = {"_LOG.txt", "Name: ", "AFM: ", "Income: ", "Basic Tax: ", "Tax Increase: ", "Tax Decrease: ", "Total Tax: ", 
                                                "TotalReceiptsGathered: ", "Entertainment: ", "Basic: ", "Travel: ", "Health: ", "Other: "};
  
  
  public TXTLogWriter() {
    super(txtLogConstants);
  }
  
  public String manipulateConstant(String constant){
    return "";
  }

}
