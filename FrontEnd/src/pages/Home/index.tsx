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
        <h1>
          No ano de 2089, um erro em um laboratório criou um psicopata chamdo Ederson🚀.Ele penseu em um onde controla astronautas, foguetes e missões espaciais, além de calcular tempo e custos das viagens. Dizem que, se alguém cancelar uma missão de madrugada, o sistema toca funk espacial nos alto-falantes 😭🔥, e pediu pros seus "estagarios" vulgo alunos criarem ele
        </h1>
      </div>

      <div className="menu">
        <span>Astronautas</span>
        <span>Equipes</span>
        <span>Foguetes</span>
        <span>Missão</span>
      </div>


    </>
  );
}

export default Home;
