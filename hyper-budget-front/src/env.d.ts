/// <reference types="vite/client" />

interface ImportMetaEnv {
  readonly VITE_STRICT_MODE_ENABLED: string;
  // Ajoutez d'autres variables d'environnement ici si nécessaire
}

interface ImportMeta {
  readonly env: ImportMetaEnv;
}