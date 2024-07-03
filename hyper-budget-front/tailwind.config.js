/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}"
  ],
  theme: {
    fontFamily: {
      'body': ['"Lexend Deca"', 'sans-serif']
    },
    extend: {
      screens: {
        xs: "425px"
      },
      spacing: {
        '6px': "6px",
        '10px': "10px",
        '16px': "16px",
        '20px': "20px",
        '24px': "24px"
      },
      borderWidth: {
        1: "1px",
      },
      borderRadius: {
        '10px': "10px",
      },
      backgroundColor: {
        primary: {
          DEFAULT: "#9570FF",
          light: "#9570FF"
        },
        secondary: {
          DEFAULT: "#FFDEDE",
          light: "#FFDEDE"
        }
      },
      colors: {
        primary: {
          DEFAULT: "#000000",
          light: "#000000",
          faded: "rgba(0, 0, 0, 0.5)"
        },
        secondary: {
          DEFAULT: "#FFFFFF",
          light: "#FFFFFF",
          faded: "rgba(255, 255, 255, 0.5)"
        },
        important: {
          DEFAULT: "#FF0000",
          light: "#FF0000"
        },
      },
    },
  },
  plugins: [],
}

