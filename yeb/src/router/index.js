import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import NotFound from "../views/NotFound";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login,
        hidden: true
    },
    {
        path: '/404',
        name: '404',
        component: NotFound
    },
    {
        path: '*',
        redirect: '/404'
    }


]

const router = new VueRouter({
    routes
})

export default router
