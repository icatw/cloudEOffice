import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import Home from "../views/Home";
import Test1 from "../views/Test1";
import Test2 from "../views/Test2";
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
        path: '/home',
        name: '导航一',
        component: Home,
        children: [
            {
                path: '/test1',
                name: '选项一',
                component: Test1
            },
            {
                path: '/test2',
                name: '选项二',
                component: Test2
            }
        ]
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
