package org.multimes.backend.core.web.model.entities;

public class Message {
    private final int mesId;
    private final String mesText;
    private final String mesTime;
    private final boolean isInter;
    private final int interId;

    public Message() {
        this.mesId = -1;
        this.mesText = null;
        this.mesTime = null;
        this.isInter = false;
        this.interId = -1;

    }

    public Message(int mesId, String mesText, String mesTime, boolean isInter, int interId) {
        this.mesId = mesId;
        this.mesText = mesText;
        this.mesTime = mesTime;
        this.isInter = isInter;
        this.interId = interId;
    }

    public int getMesId() {
        return mesId;
    }

    public String getMesText() {
        return mesText;
    }

    public String getMesTime() {
        return mesTime;
    }

    public boolean getIsInter() {
        return isInter;
    }

    public int getInterId() {
        return interId;
    }

    @Override
    public String toString() {
        return "Message [mesId=" + mesId + ", mesText=" + mesText + ", mesTime=" + mesTime + ", isInter=" + isInter
                + ", interId=" + interId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mesId;
        result = prime * result + ((mesText == null) ? 0 : mesText.hashCode());
        result = prime * result + ((mesTime == null) ? 0 : mesTime.hashCode());
        result = prime * result + (isInter ? 1231 : 1237);
        result = prime * result + interId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (mesId != other.mesId)
            return false;
        if (mesText == null) {
            if (other.mesText != null)
                return false;
        } else if (!mesText.equals(other.mesText))
            return false;
        if (mesTime == null) {
            if (other.mesTime != null)
                return false;
        } else if (!mesTime.equals(other.mesTime))
            return false;
        if (isInter != other.isInter)
            return false;
        if (interId != other.interId)
            return false;
        return true;
    }

}
