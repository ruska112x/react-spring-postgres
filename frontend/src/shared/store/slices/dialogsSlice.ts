import Dialog from "src/entities/dialog/Dialog";

import { createAppSlice } from "../createAppSlice";

type DialogFromBackend = {
  dialogId: number;
  fullName: string;
  messengerType: string;
};

export type DialogsSliceState = {
  value: Dialog[];
  status: "idle" | "loading" | "failed";
};

const initialState: DialogsSliceState = {
  value: [],
  status: "idle",
};

const dialogAttributes = {
  lastMessage: "",
  lastMessageTime: "",
  countOfUnreadMesaages: undefined,
};

const extractDialogs = (response: DialogFromBackend[]) => {
  return response.map((r) => {
    return {
      dialogId: r.dialogId,
      username: r.fullName,
      messenger: r.messengerType,
      dialogAttributes: dialogAttributes,
    };
  });
};

export const dialogsSlice = createAppSlice({
  name: "dialogs",
  initialState,
  reducers: (create) => ({
    getDialogs: create.asyncThunk(
      async () => {
        const response = await fetch(`http://localhost:8080/dialogs`, {
          method: "GET",
          headers: {
            Accept: "application/json",
          },
        }).then((r) => r.json());
        return extractDialogs(response);
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
  }),
  selectors: {
    selectDialogs: (dialogs) => dialogs.value,
    selectDialogsStatus: (dialogs) => dialogs.status,
  },
});

export const { getDialogs } = dialogsSlice.actions;

export const { selectDialogs, selectDialogsStatus } = dialogsSlice.selectors;
