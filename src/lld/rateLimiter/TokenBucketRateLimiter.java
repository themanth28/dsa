package lld.rateLimiter;

class TokenBucketRateLimiter {
    private static int i = 0;
    private final int capacity;
    private final long refillIntervalInMillis;
    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, long refillIntervalInMillis) {
        this.capacity = capacity;
        this.refillIntervalInMillis = refillIntervalInMillis;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        refill();
        System.out.println("Tokens: "+tokens);
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.currentTimeMillis();
        double tokensToAdd = ((now - lastRefillTime) / (double) refillIntervalInMillis);
        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTime = now;
        }
        System.out.println(++i + ": TokenstoAdd: " + tokensToAdd + " current Miili second: " + now);
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 1000); // 5 tokens/sec

        for (int i = 0; i < 100; i++) {
            System.out.println("Request " + (i+1) + ": " + limiter.allowRequest());
            Thread.sleep(200); // 0.2 sec between requests
        }
    }
}
