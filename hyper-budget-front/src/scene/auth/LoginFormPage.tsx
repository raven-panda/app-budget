import { FormTextField } from "@component/form/FormTextField";
import GreetingsImage from "@component/icon/GreetingsImage";
import { Checkbox } from "@mui/material";
import ApiUrls from "@service/ApiUrls";
import {  useState } from "react";
import { CookiesProvider, useCookies } from "react-cookie";
import { toast } from "react-toastify";
import { twMerge } from "tailwind-merge";

export default function LoginFormPage() {
  const [cookies, setCookie, removeCookie] = useCookies();
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [isValid, setIsValid] = useState(true);

  const onFormSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setIsSubmitting(true);
    
    const form = event.currentTarget as HTMLFormElement;
    const formData = {
      email: form.email.value,
      password: form.password.value
    };

    
    if (form.checkValidity()) {
      fetch(ApiUrls.LOGIN, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      })
      .then(response => {
        if (!response.ok) {
          throw new Error("Erreur lors de la connexion : " + response.statusText);
        }
        return response.json();
      })
      .then(data => {
        setCookie("token", data.token, { path: "/", sameSite: "strict" });
      })
      .catch(error => {
        setIsValid(false);
        console.error(error);
        toast.error("Vos identifiants sont incorrects");
      })
    } else {
      setIsValid(form.checkValidity());
    }

    setIsSubmitting(false);
  }

  return (
    <main className="min-h-screen bg-primary flex flex-col">
      <section className="flex items-center justify-center flex-1 py-20px">
        <GreetingsImage />
      </section>
      <section className="bg-tertiary rounded-t-[48px] text-center py-48px px-24px">
        <h1 className="text-3xl font-bold">Re-bonjour !</h1>
        <p className="mb-20px">Connectez vous à votre compte</p>

        <form id="login-form" className={twMerge("flex flex-col gap-20px", !isValid ? "invalid" : "")} onSubmit={onFormSubmit} action="#" noValidate>
          <FormTextField 
            id="email"
            name="email"
            type="email"
            label="Adresse email"
            formSubmitted={!isValid}
            pattern={/^(.)+@[a-z0-9\.\-]+\.[a-z]{2,4}$/}
            patternMessage="Veuillez entrer une adresse email valide, ex : john.doe@gmail.com"
          />
          <FormTextField 
            id="password"
            name="password"
            type="password"
            label="Mot de passe"
            formSubmitted={!isValid}
            minLength={8}
          />

          <div className="flex justify-between items-center">
            <a href="#" className="text-tertiary text-sm">Mot de passe oublié ?</a>
            <label htmlFor="rememberMe" className="flex items-center">
              <Checkbox name="rememberMe" id="rememberMe" />
              <span className="text-sm">Se souvenir de moi</span>
            </label>
          </div>

          <button type="submit" className="btn-primary w-full py-12px">Se connecter</button>

          <p className="text-sm">Vous n'avez pas de compte ? <a href="/auth/register" className="text-tertiary underline">Créer un compte</a></p>
        </form>

      </section>
    </main>
  );
}