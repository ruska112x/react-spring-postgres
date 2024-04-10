import { createAppSlice } from "../createAppSlice";

export type Message = {
  text: string;
  time: string;
  isInter: boolean;
};

export type MessageToBack = {
  text: string;
  dialogId: number;
};

export type MessageSliceState = {
  value: Message[];
  status: "idle" | "loading" | "failed";
};

const initialState: MessageSliceState = {
  value: [],
  status: "idle",
};

export const messagesSlice = createAppSlice({
  name: "messages",
  initialState,
  reducers: (create) => ({
    getMessages: create.asyncThunk(
      async (dialogId: number) => {
        const response = await fetch(
          `http://localhost:8080/messages?id=${dialogId}`,
        ).then((r) => r.json());
        return response as Message[];
      },
      {
        pending: (state) => {
          state.status = "loading";
        },
        fulfilled: (state, action) => {
          state.status = "idle";
          state.value = action.payload;
        },
        rejected: (state) => {
          state.status = "failed";
        },
      },
    ),
    sendMessage: create.asyncThunk(
      (message: MessageToBack) => {
        fetch("http://localhost:8080/messages", {
          method: "POST",
          body: JSON.stringify(message),
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
        });
        return message;
      },
      {
        pending: (state) => {
          state.status = "loading";
        },
        fulfilled: (state) => {
          state.status = "idle";
        },
        rejected: (state) => {
          state.status = "failed";
        },
      },
    ),
  }),
  selectors: {
    selectMessages: (messages) => messages.value,
    selectStatus: (messages) => messages.status,
  },
});

export const { getMessages, sendMessage } = messagesSlice.actions;

export const { selectMessages, selectStatus } = messagesSlice.selectors;
