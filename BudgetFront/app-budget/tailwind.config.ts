import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
    },
    screens: {
      'sm': '460px',
      'md': '768px',
      'lg': '1024px'
    },
    colors: {
      lime: {
        light:'#BDE198',
        dark:'#84CC16'
      },
      fontColorPrimary: '--font-color-primary',
      fontColorSecondary: '--font-color-secondary',
    },
  },
  plugins: [],
};
export default config;
