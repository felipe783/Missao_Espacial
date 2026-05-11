import { useState, useEffect } from "react";

interface UseTypingEffectProps {
  text: string;
  typingSpeed?: number;
  deletingSpeed?: number;
  pauseDuration?: number;
  pauseAfterDelete?: number;
  repeat?: boolean;
}

export const useTypingEffect = ({
  text,
  typingSpeed = 100,
  deletingSpeed = 100,
  pauseDuration = 2000,
  pauseAfterDelete = 2000,
  repeat = true,
}: UseTypingEffectProps) => {
  const [displayText, setDisplayText] = useState("");
  const [showCursor, setShowCursor] = useState(true);
  const [isTyping, setIsTyping] = useState(true);

  useEffect(() => {
    let currentIndex = 0;
    let phase: "typing" | "pause" | "deleting" | "pauseAfterDelete" = "typing";
    let typingInterval: ReturnType<typeof setTimeout>;
    let pauseTimeout: ReturnType<typeof setTimeout>;

    const animate = () => {
      if (phase === "typing") {
        if (currentIndex <= text.length) {
          setDisplayText(text.slice(0, currentIndex));
          currentIndex++;
          typingInterval = setTimeout(animate, typingSpeed);
        } else if (repeat) {
          phase = "pause";
          setIsTyping(false);
          pauseTimeout = setTimeout(() => {
            phase = "deleting";
            animate();
          }, pauseDuration);
        }
      } else if (phase === "deleting") {
        if (currentIndex > 0) {
          currentIndex--;
          setDisplayText(text.slice(0, currentIndex));
          typingInterval = setTimeout(animate, deletingSpeed);
        } else {
          // Terminou de deletar, agora pausa
          phase = "pauseAfterDelete";
          setIsTyping(false);
          pauseTimeout = setTimeout(() => {
            phase = "typing";
            currentIndex = 0;
            animate();
          }, pauseAfterDelete);
        }
      }
    };

    animate();

    return () => {
      clearTimeout(typingInterval);
      clearTimeout(pauseTimeout);
    };
  }, [
    text,
    typingSpeed,
    deletingSpeed,
    pauseDuration,
    pauseAfterDelete,
    repeat,
  ]);

  // Efeito do cursor piscante
  useEffect(() => {
    const cursorInterval = setInterval(() => {
      setShowCursor((prev) => !prev);
    }, 500);

    return () => clearInterval(cursorInterval);
  }, []);

  return { displayText, showCursor, isTyping };
};
