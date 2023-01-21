package pages;


import bases.utilities.SeleniumBase;

public class AllPages {

    public AllPages(){

    }

    //javada her class return type olabilir
    //Her page class return type ile private instance olusturduk
    private TrendyolHomePageElements trendyolHomePageElements;

    public SeleniumBase lib=new SeleniumBase();


    //her page class icin public method olusturup obje olusturacagiz

    public TrendyolHomePageElements trendyolHomePageElements(){
        if (trendyolHomePageElements==null){ //eger benim burda olusturdugum instance apiDemosPage yani null ise
            trendyolHomePageElements=new TrendyolHomePageElements(); //o zaman bunu bana bir obje olarak olustur daha sonra bu objeyi bana ver
        }
        return trendyolHomePageElements; //ben bu methodu cagirdigim zaman onu kullanayim
    }
}
