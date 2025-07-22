import "./App.css";
import TypingGame from "./components/TypingGame";
import ClickCounter from "./components/ClickCounter";
import EffectExample from "./components/EffectExample";
import RandomQuote from "./components/RandomQuote";
import ContextExample from "./components/ContextExample";
import ReducerExample from "./components/ReducerExample";
import CallbackExample from "./components/CallbackExample";
import MemoExample from "./components/MemoExample";
import LayoutEffectExample from "./components/LayoutEffectExample";
import ImperativeExample from "./components/ImperativeExample";
import TimerComponent from "./components/TimerComponent";
import ToggleComponent from "./components/ToggleCompoenet";
import InputComponent from "./components/InputComponent";
import CompareRefAndLet from "./components/CompareRefAndLet";
import Register from "./components/Register";

function App() {
  return (
    <>
      <ClickCounter />
      <hr />
      <EffectExample />
      <hr />
      <RandomQuote />
      <hr />
      <ContextExample />
      <hr />
      <ReducerExample />
      <hr />
      <CallbackExample />
      <hr />
      <MemoExample />
      <hr />
      <LayoutEffectExample />
      <hr />
      <ImperativeExample />
      <hr />
      <TimerComponent />
      <hr />
      <ToggleComponent />
      <hr />
      <InputComponent />
    </>
  );
}

export default App;
