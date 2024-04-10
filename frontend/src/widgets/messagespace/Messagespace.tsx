import "./Messagespace.css";

import { SetStateAction, useEffect, useRef, useState } from "react";
import Message from "src/featues/message/Message";
import { short_name } from "src/shared/shortName";
import { useAppDispatch, useAppSelector } from "src/shared/store/hooks";
import {
  selectCurrentDialog,
} from "src/shared/store/slices/currentDialogSlice";

import logo from "../../assets/svg/icon-logo.svg";
import send from "../../assets/svg/icon-send.svg";
import Avatar from "../../featues/avatar/Avatar";
import {
  getMessages,
  MessageToBack,
  selectMessages,
  sendMessage,
} from "../../shared/store/slices/messagesSlice";

const Messagespace = () => {
  let i = 0;

  const dispatch = useAppDispatch();
  const messages = useAppSelector(selectMessages);

  const currentDialog = useAppSelector(selectCurrentDialog);

  const messagesEndRef = useRef<null | HTMLDivElement>(null);

  useEffect(() => {
    if (messages.length) {
      messagesEndRef.current?.scrollIntoView({
        behavior: "smooth",
        block: "end",
      });
    }
  }, [messages.length]);

  useEffect(() => {
    const interval = setInterval(() => {
      dispatch(getMessages(currentDialog.dialogId));
    }, 1000);
    return () => clearInterval(interval);
  }, [dispatch, currentDialog]);

  const [messageText, setMessage] = useState("");

  const handleMessageChange = (event: {
    target: { value: SetStateAction<string> };
  }) => {
    setMessage(event.target.value);
  };

  const sendMessageLambda = () => {
    if (messageText !== "") {
      const mes: MessageToBack = {
        text: messageText,
        dialogId: currentDialog.dialogId,
      };
      dispatch(sendMessage(mes));
    }
    setMessage("");
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLInputElement>) => {
    if (event.key === "Enter") {
      sendMessageLambda();
    }
  };

  return (
    <div className="chat">
      <div className="chat_header">
        <div className="user">
          <Avatar
            name={short_name(currentDialog.username)}
            messengerIcon={currentDialog.messenger}
            size="small"
          />
          <p className="user-name">{currentDialog.username}</p>
        </div>
        <a href="#link">
          <img src={logo} alt="logo Multimes" />
        </a>
      </div>
      <div className="chat_messages">
        {messages.map((message) => (
          <Message
            key={message.time + ++i}
            userName={currentDialog.username}
            text={message.text}
            messageTime={message.time}
            isInter={message.isInter}
          />
        ))}
        <div ref={messagesEndRef} />
      </div>
      <div className="chat-input">
        <input
          className="chat-input_field"
          type="text"
          name="Message-input"
          id="0"
          onChange={handleMessageChange}
          value={messageText}
          placeholder="Message..."
          onKeyDown={handleKeyDown}
        />
        <span className="chat-input_send" onClick={sendMessageLambda}>
          <img src={send} alt="send message icon" />
        </span>
      </div>
    </div>
  );
};

export default Messagespace;
