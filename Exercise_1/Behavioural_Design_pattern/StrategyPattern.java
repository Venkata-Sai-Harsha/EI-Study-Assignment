package Exercise_1.Behavioural_Design_pattern;
//usecase-2: Strategy Pattern [Behavioural]

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

// Concrete Strategy 3
class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Cryptocurrency: " + walletAddress);
    }
}

// Context
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Please select a payment method.");
        }
    }
}

// Demo
public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // User selects Credit Card as payment method
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentContext.processPayment(250.75);

        // User selects PayPal as payment method
        paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentContext.processPayment(89.99);

        // User selects Crypto as payment method
        paymentContext.setPaymentStrategy(new CryptoPayment("crypto-wallet-xyz"));
        paymentContext.processPayment(500.00);
    }
}
