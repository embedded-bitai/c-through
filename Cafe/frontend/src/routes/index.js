import Vue from 'vue'
import Router from 'vue-router'

const Dashboard1 = () => import('../views/Dashboard1.vue')
const Dashboard2 = () => import('../views/Dashboard2.vue')
const Dashboard3 = () => import('../views/Dashboard3.vue')
const ComingSoon = () => import('../views/ComingSoon.vue')
const Menu = () => import('../views/Menu.vue')
const Home = () => import('../views/Home.vue')
const AddMenu = () => import('../views/AddMenu.vue')
const Login = () => import('../views/register/Login.vue')
const Register = () => import('../views/register/Register.vue')
const FindId = () => import('../views/register/FindId.vue')
const FindPw = () => import('../views/register/FindPw.vue')
const ShowId = () => import('../views/register/ShowId.vue')
const HavePw = () => import('../views/register/HavePw.vue')
Vue.use(Router)


export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home,
        },
    ]
})
