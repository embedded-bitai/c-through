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
    routes: [{
        path: '/dashboard1',
        name: 'Dashboard1',
        component: Dashboard1,
    },
        {
            path: '/dashboard2',
            name: 'Dashboard2',
            component: Dashboard2,
        },
        {
            path: '/dashboard3',
            name: 'Dashboard3',
            component: Dashboard3,
        },
        {
            path: '/coming-soon',
            name: 'ComingSoon',
            component: ComingSoon,
        },
        {
            path: '/Menu',
            name: 'Menu',
            components: {
                default: Menu
            },
            props: {
                default: true
            }
        },
        {
            path: '/',
            name: 'Home',
            component: Home,
        },
        {
            path: '/add-menu',
            name: 'AddMenu',
            component: AddMenu
        },
        ////////////////    여기부터 로그인    ////////////////
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/register',
            name: 'Register',
            component: Register
        },
        {
            path: '/login/findid',
            name: 'FindId',
            components: {
                default: FindId
            }
        },
        {
            path: '/login/findpw',
            name: 'FindPw',
            component: FindPw,
            props: true
        },
        {
            path: '/login/showid',
            name: 'ShowId',
            components: {
                default: ShowId
            },
            props: {
                default: true
            }
        },
        {
            path: '/login/havepw',
            name: 'HavePw',
            component: HavePw
        }
    ]
})
