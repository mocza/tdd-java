import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Salty on 5/20/2018.
 */
public class PortfolioHoldings {

    public static final String PIPE = "\\|";
    public static final String COMMA = ",";
    public static final String COLON = ":";

    public enum TransactionType {
        BUY, SELL;
    }

    public static class Transaction {
        private TransactionType transactionType;
        private String ticker;
        private long quantity;

        public TransactionType getTransactionType() {
            return transactionType;
        }

        public String getTicker() {
            return ticker;
        }

        public long getQuantity() {
            return quantity;
        }

        public static Optional<Transaction> of(Holding holding, Holding benchmark) {
            if (!holding.getTicker().equals(benchmark.getTicker()) || holding.getQuantity() == benchmark.getQuantity()) {
                return Optional.empty();
            } else {
                return Optional.of(new Transaction(holding.getQuantity() > benchmark.getQuantity() ? TransactionType.SELL : TransactionType.BUY,
                        holding.getTicker(), Math.abs(holding.getQuantity() - benchmark.getQuantity())));
            }
        }

        private Transaction(TransactionType transactionType, String ticker, long quantity) {
            this.transactionType = transactionType;
            this.ticker = ticker;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return new StringJoiner(COMMA + " ", "[" , "]")
                    .add(transactionType.name()).add(ticker).add(String.format("%.2f", Double.valueOf(quantity))).toString();
        }
    }

    static String generateTransactions(String input) {
        List<Transaction> transcations = new ArrayList<>();
        Pattern p = Pattern.compile("([a-zA-Z]+)"+ COMMA + "([a-zA-Z]+)"+ COMMA + "([0-9]+)");

        StringTokenizer pairs = new StringTokenizer(input, PIPE);
        while (pairs.hasMoreTokens()) {
            StringTokenizer stringTokenizer = new StringTokenizer(pairs.nextToken(), COLON);
            List<Holding> holdings = new ArrayList<>();
            while (stringTokenizer.hasMoreTokens()) {
                Matcher m = p.matcher(stringTokenizer.nextToken());
                while (m.find()) {
                    String ticker = m.group(1);
                    String name = m.group(2);
                    long quantity = Long.valueOf(m.group(3));
                    Holding holding = new Holding(ticker, name, quantity);
                    holdings.add(holding);
                }
            }
            Optional<Transaction> transaction = Transaction.of(holdings.get(0), holdings.get(1));
            if (transaction.isPresent()) {
                transcations.add(transaction.get());
            }
        }

        return transcations.stream().sorted((transaction1, transaction2) -> transaction1.getTicker().compareTo(transaction2.getTicker()))
                .map(Transaction::toString).collect(Collectors.joining(COMMA + " "));

    }

    static String printHoldings(String portfolioString) {
        List<Holding> holdings = new ArrayList<>();
        Pattern p = Pattern.compile("([a-zA-Z]+)"+ COMMA + "([a-zA-Z]+)"+ COMMA + "([0-9]+)");

        StringTokenizer stringTokenizer = new StringTokenizer(portfolioString, PIPE);
        while (stringTokenizer.hasMoreTokens()) {
            Matcher m = p.matcher(stringTokenizer.nextToken());
            while (m.find()) {
                String ticker = m.group(1);
                String name = m.group(2);
                long quantity = Long.valueOf(m.group(3));
                Holding holding = new Holding(ticker, name, quantity);
                holding.toString();
                holdings.add(holding);
            }
        }
        return holdings.stream().sorted((holding1, holding2) -> holding1.getTicker().compareTo(holding2.getTicker()))
                .map(Holding::toString).collect(Collectors.joining(COMMA));
    }


    public static class Holding {
        private String name;
        private String ticker;
        private long quantity;

        public Holding(String ticker, String name, long quantity) {
            this.ticker = ticker;
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTicker() {
            return ticker;
        }

        public void setTicker(String ticker) {
            this.ticker = ticker;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return new StringJoiner(COMMA + " " , "[", "]").add(ticker).add(name).add(String.valueOf(quantity)).toString();
        }
    }

    public static int countHoldings(String input) {
        Set<Holding> holdings = new HashSet<>();
        Pattern p = Pattern.compile("([a-zA-Z]+),([a-zA-Z]+),([0-9]+)");

        StringTokenizer stringTokenizer = new StringTokenizer(input, "|");
        while (stringTokenizer.hasMoreTokens()) {
            Matcher m = p.matcher(stringTokenizer.nextToken());
            while (m.find()) {
                String ticker = m.group(1);
                String name = m.group(2);
                long quantity = Long.valueOf(m.group(3));
                Holding holding = new Holding(ticker, name, quantity);
                holding.toString();
                holdings.add(holding);
            }
        }
        return holdings.size();
    }

}
