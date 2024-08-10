import GrowMoneyImage from "@component/icon/GrowMoneyImage";

export default function WelcomePage() {
  return (
    <main className="min-h-screen bg-primary flex flex-col">
      <section className="flex items-center justify-center flex-1 py-20px">
        <GrowMoneyImage />
      </section>
      <section className="bg-tertiary py-48px px-32px rounded-t-[48px] text-center">
        <h1 className="text-3xl font-bold mb-20px">L’application pour gérer votre budget</h1>
        <p className="mb-20px">
          <b>HyperBudget</b> est conçu pour simplifier la gestion de votre argent et vous aider à atteindre vos objectifs financiers avec sérénité.
        </p>
        <a href="/auth/login" className="btn-primary w-full py-16px">Se connecter</a>
        <p>ou</p>
        <a href="/auth/register" className="text-tertiary">Créer un compte</a>
      </section>
    </main>
  )
}