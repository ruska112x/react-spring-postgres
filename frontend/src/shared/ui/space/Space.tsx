import "./Space.css";

export type SpaceProps = {
  children?: string;
  chosenSpace: string;
};

const Space = ({ children, chosenSpace }: SpaceProps) => {
  return (
    <a href="#space" className="space">
      <img
        className="space-img"
        src={`src/assets/svg/${chosenSpace}.svg`}
        alt="space"
      />
      <p className={"space-name"}> {children}</p>
    </a>
  );
};
export default Space;
