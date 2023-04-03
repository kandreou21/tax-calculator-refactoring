package incometaxcalculator.data.io;


public class XMLLogWriter extends LogWriter {


  private static final String[] xmlLogConstants = {"_LOG.xml", "<Name>", "<AFM>", "<Income>", "<BasicTax>", "<TaxIncrease>", "<TaxDecrease>", "<TotalTax>", "<Receipts>", 
                                                "<Entertainment>", "<Basic>", "<Travel>", "<Health>", "<Other>"};
  
  
  public XMLLogWriter() {
    super(xmlLogConstants);
  }
  
  public String manipulateConstant(String constant) {
    return constant.replaceFirst("<", "</");
  }

}
