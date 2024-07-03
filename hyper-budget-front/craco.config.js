const path = require('path');
module.exports = {
  webpack: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
      '@component': path.resolve(__dirname, 'src/component'),
      '@scene': path.resolve(__dirname, 'src/scene'),
      '@service': path.resolve(__dirname, 'src/service')
    },
  },
};