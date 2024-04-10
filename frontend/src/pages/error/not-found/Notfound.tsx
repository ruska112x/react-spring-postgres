import "./Notfound.css";

import pigein from "src/assets/svg/pigeon_404.svg";
import Button from "src/shared/ui/button/Button";

type NotFoundProps = {
  link: string;
};

const NotFound = ({ link }: NotFoundProps) => {
  return (
    <>
      <div className="not-found__main">
        <img src={pigein} alt="pigeon_404" className="not-found__pigeon" />
        <div className="not-found__context">
          <h3 className="context__title">Кажется, вы потерялись...</h3>
          <h4 className="context__subtext">
            Страница не найдена. Такой страницы не существует или она была
            удалена.
          </h4>
          <Button link="">Вернуться к чатам</Button>
        </div>
      </div>
    </>
  );
};

export default NotFound;
