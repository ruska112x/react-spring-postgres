import "./Spacebar.css";

import searchParamSvg from "src/assets/svg/icon-param.svg";
import searchSvg from "src/assets/svg/icon-search.svg";
import settingsSvg from "src/assets/svg/icon-settings.svg";
import Dialog from "src/entities/dialog/Dialog";
import { short_name } from "src/shared/shortName";
import { useAppDispatch } from "src/shared/store/hooks";
import {
  setCurrentDialog,
} from "src/shared/store/slices/currentDialogSlice";

import Avatar from "../../featues/avatar/Avatar";

export type SpacebarProps = {
  title?: string;
  dialogList: Dialog[];
};

const Spacebar = ({ title, dialogList }: SpacebarProps) => {
  const dispatch = useAppDispatch();
  return (
    <section className="spacebar">
      <header className="spacebar__header">
        <h1 className="spacebar__header-title">{title}</h1>
        <ul className="spacebar__header_functional">
          <li className="functional_element">
            <button className="functional_search">
              <img src={searchSvg} alt="Space search button" />
            </button>
          </li>
          <li className="functional_element">
            <button className="functional_search-parametr">
              <img src={searchParamSvg} alt="Space search parametr button" />
            </button>
          </li>
          <li className="functional_element">
            <button className="functional_settings">
              <img src={settingsSvg} alt="Space settings button" />
            </button>
          </li>
        </ul>
      </header>
      <main className="spacebar__main">
        {dialogList.map((dialog) => (
          <div
            key={dialog.username}
            className="dialog"
            onClick={() => {
              dispatch(setCurrentDialog(dialog));
            }}
          >
            <Avatar
              name={short_name(dialog.username)}
              messengerIcon={dialog.messenger}
              size="big"
            ></Avatar>
            <div className="dialog__content">
              <header className="dialog__content_header">
                <h1 className="dialog__content_header-username">
                  {dialog.username}
                </h1>
                <p className="dialog__content_header-last-message-time">
                  {dialog.dialogAttributes?.lastMessageTime}
                </p>
              </header>
              <main className="dialog__content_main">
                <p className="dialog__content_main-last-message">
                  {dialog.dialogAttributes?.lastMessage}
                </p>
                {dialog.dialogAttributes?.countOfUnreadMesaages != undefined &&
                  dialog.dialogAttributes?.countOfUnreadMesaages != 0 && (
                    <div className="dialog__content_main-count-of-unread-messages">
                      <p>{dialog.dialogAttributes?.countOfUnreadMesaages}</p>
                    </div>
                  )}
              </main>
            </div>
          </div>
        ))}
      </main>
    </section>
  );
};

export default Spacebar;
