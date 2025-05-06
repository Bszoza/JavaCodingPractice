package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ConfigOptional {

    private static Map<String, String> configs = new HashMap<String, String>();

    public void run() {

        configs.put("key1", "value1");
        configs.put("key2", "value2");
        configs.put("key3", "value3");
        configs.put("key4", "value4");
        configs.put("key5", "value5");
        getValidConfigValue(configs, "key2").ifPresentOrElse(ConfigOptional::printValue, ConfigOptional::errorMessage);
        getValidConfigValue(configs, "key6").ifPresentOrElse(ConfigOptional::printValue, ConfigOptional::errorMessage);
    }

    public Optional<String> getValidConfigValue(Map<String, String> config, String key) {
        return Optional.of(configs.get(key)).filter(value -> !value.isBlank()).filter(value -> value.matches(".*[a-zA-Z].*"));
    }

    public static void errorMessage() {
        System.out.println("Error");
    }

    public static void printValue(String value) {
        System.out.println(value);
    }

}
