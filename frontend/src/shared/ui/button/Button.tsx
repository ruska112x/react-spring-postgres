import { Children } from "react";
import "./Button.css";

type ButtonProps = {
  link: string;
  children: string;
};

const Button = ({ link, children }: ButtonProps) => {
  return (
    <>
      <button className="button">{children}</button>
    </>
  );
};

export default Button;
