package org.multimes.backend.core.web.model.dto.responses;

public class AllMessagesByDialogIdResponse {
    private final String text;
    private final String time;
    private final boolean isInter;

    public AllMessagesByDialogIdResponse() {
        this.text = null;
        this.time = null;
        this.isInter = false;
    }

    public AllMessagesByDialogIdResponse(String text, String time, boolean isInter) {
        this.text = text;
        this.time = time;
        this.isInter = isInter;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public boolean getIsInter() {
        return isInter;
    }

    @Override
    public String toString() {
        return "AllMessagesByDialogIdResponse [text=" + text + ", time=" + time + ", isInter=" + isInter + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + (isInter ? 1231 : 1237);
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
        AllMessagesByDialogIdResponse other = (AllMessagesByDialogIdResponse) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (isInter != other.isInter)
            return false;
        return true;
    }

}
