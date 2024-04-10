import "./Navbar.css";

import Space from "src/shared/ui/space/Space";

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className={"navbar-list"}>
        <li className="navbar-list_item">
          <Space chosenSpace={"add"} />
        </li>
        <li className="navbar-list_item">
          <Space chosenSpace={"icon-all-chat"} />
        </li>
        <li className="navbar-list_item">
          <Space chosenSpace={"inactive-space"}>name</Space>
        </li>
        <li className="navbar-list_item">
          <Space chosenSpace={"icon-account"}></Space>{" "}
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
