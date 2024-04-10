package org.multimes.backend.core.web.model.dto.requests;

public class SendMessageRequest {
    private final String text;
    private final int dialogId;

    public SendMessageRequest() {
        this.text = null;
        this.dialogId = -1;
    }

    public SendMessageRequest(String text, int dialogId) {
        this.text = text;
        this.dialogId = dialogId;
    }

    public String getText() {
        return text;
    }

    public int getDialogId() {
        return dialogId;
    }

    @Override
    public String toString() {
        return "SendMessageRequest [text=" + text + ", dialogId=" + dialogId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + dialogId;
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
        SendMessageRequest other = (SendMessageRequest) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (dialogId != other.dialogId)
            return false;
        return true;
    }

}
