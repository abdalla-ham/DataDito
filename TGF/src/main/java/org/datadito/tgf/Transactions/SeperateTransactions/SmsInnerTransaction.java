package org.datadito.tgf.Transactions.SeperateTransactions;

public class SmsInnerTransaction {
    private String senderMsisdn;
    private String receiverMsisdn;
    final private int location = 90;

    public SmsInnerTransaction(String senderMsisdn, String receiverMsisdn) {
        this.senderMsisdn = senderMsisdn;
        this.receiverMsisdn = receiverMsisdn;
    }

    public SmsInnerTransaction() {
    }

    public String getSenderMsisdn() {
        return senderMsisdn;
    }

    public void setSenderMsisdn(String senderMsisdn) {
        this.senderMsisdn = senderMsisdn;
    }

    public String getReceiverMsisdn() {
        return receiverMsisdn;
    }

    public void setReceiverMsisdn(String receiverMsisdn) {
        this.receiverMsisdn = receiverMsisdn;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "SmsInnerTransaction{" +
                "senderMsisdn='" + senderMsisdn + '\'' +
                ", receiverMsisdn='" + receiverMsisdn + '\'' +
                ", location=" + location +
                '}';
    }
}
