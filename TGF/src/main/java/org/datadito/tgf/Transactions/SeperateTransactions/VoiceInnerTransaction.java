package org.datadito.tgf.Transactions.SeperateTransactions;

public class VoiceInnerTransaction {
    private String callerMsisdn;
    private String calleeMsisdn;
    final private int location = 90;
    private int duration;

    public VoiceInnerTransaction(String callerMsisdn, String calleeMsisdn, int duration) {
        this.callerMsisdn = callerMsisdn;
        this.calleeMsisdn = calleeMsisdn;
        this.duration = duration;
    }

    public VoiceInnerTransaction() {
    }

    public String getCallerMsisdn() {
        return callerMsisdn;
    }

    public void setCallerMsisdn(String callerMsisdn) {
        this.callerMsisdn = callerMsisdn;
    }

    public String getCalleeMsisdn() {
        return calleeMsisdn;
    }

    public void setCalleeMsisdn(String calleeMsisdn) {
        this.calleeMsisdn = calleeMsisdn;
    }

    public int getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "VoiceInnerTransaction{" +
                "callerMsisdn='" + callerMsisdn + '\'' +
                ", calleeMsisdn='" + calleeMsisdn + '\'' +
                ", location=" + location +
                ", duration=" + duration +
                '}';
    }
}
