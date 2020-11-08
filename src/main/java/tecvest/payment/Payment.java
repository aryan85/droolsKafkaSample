package tecvest.payment;

import java.math.BigDecimal;

public class Payment {
    private String cardNo;
    private BigDecimal amount;
    private BigDecimal monthlyTotalAmount;
    private boolean monthlyLimitApproved = false;
    private boolean transactionMaxLimitApproved = false;

    public Payment(String cardNo, BigDecimal amount) {
        this.cardNo = cardNo;
        this.amount = amount;
    }

    public Payment(String cardNo, BigDecimal amount, BigDecimal monthlyTotalAmount) {
        this.cardNo = cardNo;
        this.amount = amount;
        this.monthlyTotalAmount = monthlyTotalAmount;
    }

    public Payment() {
    }

    public BigDecimal getMonthlyTotalAmount() {
        return monthlyTotalAmount;
    }

    public void setMonthlyTotalAmount(BigDecimal monthlyTotalAmount) {
        this.monthlyTotalAmount = monthlyTotalAmount;
    }

    public boolean isMonthlyLimitApproved() {
        return monthlyLimitApproved;
    }

    public void setMonthlyLimitApproved(boolean monthlyLimitApproved) {
        this.monthlyLimitApproved = monthlyLimitApproved;
    }

    public boolean isTransactionMaxLimitApproved() {
        return transactionMaxLimitApproved;
    }

    public void setTransactionMaxLimitApproved(boolean transactionMaxLimitApproved) {
        this.transactionMaxLimitApproved = transactionMaxLimitApproved;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "cardNo='" + cardNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
