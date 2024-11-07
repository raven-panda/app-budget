import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import path from 'path';
import tailwindcss from 'tailwindcss';

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  css: {
    postcss: {
      plugins: [tailwindcss()],
    },
  },
  resolve: {
    alias: [{
      find: '@', replacement: path.resolve(__dirname, 'src')
    },
    {
      find: '@component', replacement: path.resolve(__dirname, 'src/component')
    },
    {
      find: '@scene', replacement: path.resolve(__dirname, 'src/scene')
    },
    {
      find: '@service', replacement: path.resolve(__dirname, 'src/service')
    },
    {
      find: '@model', replacement: path.resolve(__dirname, 'src/model')
    }]
  }
})
