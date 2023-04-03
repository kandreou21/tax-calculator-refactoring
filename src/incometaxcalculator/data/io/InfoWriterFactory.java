package incometaxcalculator.data.io;

public class InfoWriterFactory {

  public FileWriter createInfoWriter(String kind){
    if (kind.equals("_INFO.xml")) {
      return new XMLInfoWriter();
    } else {
      return new TXTInfoWriter();
    }
  }
}
