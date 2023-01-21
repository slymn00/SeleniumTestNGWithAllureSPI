package bases.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Resources;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class DataFaker {

    private static final Random random=new Random();
    private static DataFaker instance;

    private List<String> firstname;
    private List<String> lastname;
    private List<String> gender;
    private List<String> countryEN;
    private List<String> countryTR;
    private List<String> cities;
    private List<String> gameOfThronesCharacters;


    private DataFaker(){}

    public static DataFaker getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(Resources.getResource("data_faker.yaml"), DataFaker.class);
            } catch (Exception e) {
                Log.fail("data_faker.yaml Config Dosyası Okunurken hata alındı!", e);
            }
        }
        return instance;
    }

    /**
     * Random kullanılarak fake bir data olusturuluyor
     * @param min = min doğum tarihi
     * @param max = max doğrum tarihi
     */
    public int nextInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Returns a string with the '#' characters in the parameter replaced with random digits between 0-9 inclusive.
     * <p/>
     * For example, the string "ABC##EFG" could be replaced with a string like "ABC99EFG".
     */
    public String numerify(String numberString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '#') {
                sb.append(random.nextInt(10));
            } else {
                sb.append(numberString.charAt(i));
            }
        }

        return sb.toString();
    }

    public String subscriberNumber(int length) {
        return numerify("#".repeat(Math.max(0, length)));
    }
}
