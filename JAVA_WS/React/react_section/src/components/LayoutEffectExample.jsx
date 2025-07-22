import { useRef, useLayoutEffect, useState } from "react";

const LayoutEffectExample = () => {
  const boxRef = useRef();
  const [width, setWidth] = useState(0);

  useLayoutEffect(() => {
    setWidth(boxRef.current.getBoundingClientRect().width);
  }, []);

  return (
    <>
      <div ref={boxRef} style={{ width: "80%", border: "1px soild black" }}>
        {" "}
        너비 측정용 박스
      </div>
      <p>측정된 너비: {width}</p>
    </>
  );
};

export default LayoutEffectExample;
