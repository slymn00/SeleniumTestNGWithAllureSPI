package pages;


import bases.utilities.SeleniumBase;

public class AllPages {

    public AllPages(){

    }

    //javada her class return type olabilir
    //Her page class return type ile private instance olusturduk
    private AmazonHomePageElements amazonHomePageElements;

    public SeleniumBase lib=new SeleniumBase();


    //her page class icin public method olusturup obje olusturacagiz

    public AmazonHomePageElements amazonHomePageElements(){
        if (amazonHomePageElements ==null){ //eger benim burda olusturdugum instance trendyolHomePageElements yani null ise
            amazonHomePageElements =new AmazonHomePageElements(); //o zaman bunu bana bir obje olarak olustur daha sonra bu objeyi bana ver
        }
        return amazonHomePageElements; //ben bu methodu cagirdigim zaman onu kullanayim
    }
}
