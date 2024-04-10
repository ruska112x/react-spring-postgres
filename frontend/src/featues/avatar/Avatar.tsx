import "./Avatar.css";

type AvatarProps = {
  name?: string;
  messengerIcon: string | undefined;
  size: string;
};

const Avatar = ({ name, messengerIcon, size }: AvatarProps) => {
  return (
    <div className={"avatar " + size}>
      <p className="avatar-name"> {name}</p>
      {messengerIcon != undefined && messengerIcon != "" && (
        <img
          className={"messenger-icon " + size + "-icon"}
          src={`src/assets/svg/${messengerIcon}.svg`}
          alt={messengerIcon}
        ></img>
      )}
    </div>
  );
};

export default Avatar;
