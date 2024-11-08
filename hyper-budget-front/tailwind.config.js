/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}"
  ],
  theme: {
    fontFamily: {
      'body': ['"Lexend Deca"', 'sans-serif']
    },
    extend: {
      screens: {
        xs: "375px",
        s: "425px"
      },
      spacing: {
        '6px': "6px",
        '10px': "10px",
        '12px': "12px",
        '16px': "16px",
        '20px': "20px",
        '24px': "24px",
        '32px': "32px",
        '48px': "48px"
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
        },
        tertiary: {
          DEFAULT: "#FFFFFF",
          light: "#FFFFFF"
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
        tertiary: {
          DEFAULT: "#9570FF",
          light: "#9570FF"
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

