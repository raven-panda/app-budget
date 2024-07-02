/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}"
  ],
  theme: {
    extend: {
      spacing: {
        '24px': "24px"
      }
    },
    colors: {
      primary: {
        '': "#9570FF"
      },
      secondary: {
        '': "#FFDEDE"
      }
    },
  },
  plugins: [],
}

