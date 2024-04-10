package org.multimes.backend.core.web.model.entities;

public class Dialog {
    private final int interId;
    private final long idInMessenger;
    private final String fullName;
    private final String messengerType;

    public Dialog() {
        this.interId = -1;
        this.idInMessenger = -1;
        this.fullName = null;
        this.messengerType = null;
    }

    public Dialog(int interId, long idInMessenger, String fullName, String messengerType) {
        this.interId = interId;
        this.idInMessenger = idInMessenger;
        this.fullName = fullName;
        this.messengerType = messengerType;
    }

    public int getInterId() {
        return interId;
    }

    public long getIdInMessenger() {
        return idInMessenger;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMessengerType() {
        return messengerType;
    }

    @Override
    public String toString() {
        return "Dialog [interId=" + interId + ", idInMessenger=" + idInMessenger + ", fullName=" + fullName
                + ", messengerType=" + messengerType + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + interId;
        result = prime * result + (int) (idInMessenger ^ (idInMessenger >>> 32));
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((messengerType == null) ? 0 : messengerType.hashCode());
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
        Dialog other = (Dialog) obj;
        if (interId != other.interId)
            return false;
        if (idInMessenger != other.idInMessenger)
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (messengerType == null) {
            if (other.messengerType != null)
                return false;
        } else if (!messengerType.equals(other.messengerType))
            return false;
        return true;
    }

}
