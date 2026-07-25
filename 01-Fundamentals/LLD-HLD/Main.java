// LLD: inside the URL Shortener service.
// Strategy pattern lets us swap the encoding algorithm
// without touching the service that uses it.
import java.util.HashMap;
import java.util.Map;

interface KeyGenerationStrategy {
    String generate(long counter);
}

class Base62Strategy implements KeyGenerationStrategy {
    private final String alphabet =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate(long counter) {
        long n = counter;
        StringBuilder key = new StringBuilder();
        int base = alphabet.length();
        while (n > 0) {
            key.insert(0, alphabet.charAt((int) (n % base)));
            n /= base;
        }
        while (key.length() < 6) key.insert(0, 'a');
        return key.toString();
    }
}

interface UrlRepository {
    void save(String shortKey, String longUrl);
    String find(String shortKey);
}

class InMemoryUrlRepository implements UrlRepository {
    private final Map<String, String> store = new HashMap<>();

    public void save(String shortKey, String longUrl) { store.put(shortKey, longUrl); }
    public String find(String shortKey) { return store.get(shortKey); }
}

class UrlShortenerService {
    private final KeyGenerationStrategy keyStrategy;
    private final UrlRepository repository;
    private long counter = 1000;

    public UrlShortenerService(KeyGenerationStrategy keyStrategy, UrlRepository repository) {
        this.keyStrategy = keyStrategy;
        this.repository = repository;
    }

    public String shorten(String longUrl) {
        String shortKey = keyStrategy.generate(counter++);
        repository.save(shortKey, longUrl);
        return shortKey;
    }

    public String resolve(String shortKey) {
        String longUrl = repository.find(shortKey);
        if (longUrl == null) throw new RuntimeException("Short URL not found");
        return longUrl;
    }
}

public class Main {
    public static void main(String[] args) {
        UrlShortenerService service = new UrlShortenerService(
            new Base62Strategy(), new InMemoryUrlRepository());
        String key = service.shorten("https://algorithmxlr8.io/dsa/graphs");
        System.out.println("short key: " + key);
        System.out.println("resolved: " + service.resolve(key));
    }
}