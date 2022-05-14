import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
import router from './router'
import store from './store/index'
import 'font-awesome/css/font-awesome.css'

import { postRequest } from './utils/api'
import { putRequest } from "./utils/api";
import { getRequest } from "./utils/api";
import { deleteRequest } from "./utils/api";
import { initMenu } from './utils/menus'
import { downloadRequest } from './utils/download';

import Router from 'vue-router'

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}


//插件
Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.downloadRequest = downloadRequest;
Vue.config.productionTip = false
Vue.use(ElementUI, { size: 'small' });
Vue.use(VueAxios, axios)
Vue.prototype.$axios = axios


router.beforeEach((to, from, next) => {
  if (window.sessionStorage.getItem('tokenStr')) {
    initMenu(router, store)
    if (!window.sessionStorage.getItem("user")) {
      return getRequest('/admin/info').then(resp => {
        if (resp) {
          //存入用户信息
          window.sessionStorage.setItem("user", JSON.stringify(resp));
          store.commit('INIT_ADMIN',resp)
          next('/home');
        }
      });
    }
    next()
  } else {
    if (to.path == '/') {
      next();
    } else {
      next('/?redirect=' + to.path)
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
