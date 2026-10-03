import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import '../assets/js/vendor.min.js'
import '../assets/js/plugins.min.js'
import '../assets/js/main.min.js'
import '../assets/js/plugins/jquery.countdown.min.js'
import '../assets/js/vendor/jquery-3.6.0.min.js'
import '../assets/css/style.min.css'
import '../assets/css/plugins.min.css'
const app = createApp(App)
app.use(router)
app.mount('#app')