package org.multimes.backend.core.web.model.dto.responses;

public class AllDialogsResponse {
    private final int dialogId;
    private final String fullName;
    private final String messengerType;

    public AllDialogsResponse() {
        this.dialogId = -1;
        this.fullName = null;
        this.messengerType = null;
    }

    public AllDialogsResponse(int dialogId, String fullName, String messengerType) {
        this.dialogId = dialogId;
        this.fullName = fullName;
        this.messengerType = messengerType;
    }

    public int getDialogId() {
        return dialogId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMessengerType() {
        return messengerType;
    }

    @Override
    public String toString() {
        return "GetAllDialogsResponse [dialogId=" + dialogId + ", fullName=" + fullName + ", messengerType="
                + messengerType + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dialogId;
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
        AllDialogsResponse other = (AllDialogsResponse) obj;
        if (dialogId != other.dialogId)
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
