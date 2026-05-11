import "./style.css";
import { useTypingEffect } from "../../hooks/useTypingEffect";

function Home() {
  const { displayText, showCursor } = useTypingEffect({
    text: 'Espacial',
    typingSpeed: 100,
    deletingSpeed: 50,
    pauseDuration: 2000,      // Pausa Final Digitação
    pauseAfterDelete: 1000,   // Pausa Depois de Deletar
    repeat: true,
})

  return (
    <>
      <div className="container-options">
        <h1>Astronautas</h1>
        <h1>Equipes</h1>
        <h1>Foguetes</h1>
        <h1>Missão</h1>
      </div>

      <div className="main-title">
        <span id="title-mission">Missão</span>
        <span id="title-special">
          {displayText}
          {showCursor && <span className="cursor">|</span>}
        </span>
      </div>


    </>
  );
}

export default Home;
