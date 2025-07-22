import useInput from "../hooks/useInput";

const InputComponent = () => {
  const [input, onChange] = useInput();
  const [input2, onChange2] = useInput();

  return (
    <div>
      <h2>
        {input}
        {input2}
      </h2>
      <input type={input} onChange={onChange} />
      <input type={input2} onChange={onChange2} />
    </div>
  );
};

export default InputComponent;
