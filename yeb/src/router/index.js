import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import NotFound from "../views/NotFound";
import Home from "../views/Home";
import FriendChat from "../views/chat/FriendChat";

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
        name: 'Home',
        component: Home,
        children: [
            {
                path: '/chat',
                name: '在线聊天',
                component: FriendChat
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
