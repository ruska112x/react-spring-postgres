import { PayloadAction } from "@reduxjs/toolkit";
import Dialog from "src/entities/dialog/Dialog";

import { createAppSlice } from "../createAppSlice";

type CurrentDialogSliceState = {
  value: Dialog;
  status: "idle" | "loading" | "failed";
};

const dialogAttributes = {
  lastMessage: "",
  lastMessageTime: "",
  countOfUnreadMesaages: undefined,
};

const initialState: CurrentDialogSliceState = {
  value: {
    dialogId: 0,
    username: "",
    messenger: "vk",
    dialogAttributes: dialogAttributes,
  },
  status: "idle",
};

export const currentDialogSlice = createAppSlice({
  name: "currentDialog",
  initialState,
  reducers: (create) => ({
    setCurrentDialog: create.reducer((state, action: PayloadAction<Dialog>) => {
      return { ...state, value: action.payload };
    }),
  }),
  selectors: {
    selectCurrentDialog: (currentDialog) => currentDialog.value,
    selectCurrentDialogStatus: (currentDialog) => currentDialog.status,
  },
});

export const { setCurrentDialog } = currentDialogSlice.actions;

export const { selectCurrentDialog, selectCurrentDialogStatus } =
  currentDialogSlice.selectors;
