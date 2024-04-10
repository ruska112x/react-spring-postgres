import "./App.css";

import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";

import Main from "./app/Main";
import { store } from "./shared/store/store";

const App = () => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Main />
      </BrowserRouter>
    </Provider>
  );
};

export default App;
