class Liquid {
  private static final double FL_OUNCES_PER_ML = 12.0/355.0;
  private static final double ML_PER_FL_OUNCES = 355.0/12/0;
  public static int convertOzToMl(int ounces) {
    double d  = ounces * ML_PER_FL_OUNCES;
    d+=0.5; //adding 0.5 as int will truncate;
    return (int) d; // Result is rounded up if fraction is >= 0.5
  }

  //Test client
  public static void main(String[] args) {
        int mlFor8Oz = Liquid.convertOzToMl(8);
        int mlFor12Oz = Liquid.convertOzToMl(12);
        int mlFor16Oz = Liquid.convertOzToMl(16);
        System.out.println("Ml for 8 oz is: " + mlFor8Oz);
        System.out.println("Ml for 12 oz is: " + mlFor12Oz);
        System.out.println("Ml for 16 oz is: " + mlFor16Oz);
    }
}
