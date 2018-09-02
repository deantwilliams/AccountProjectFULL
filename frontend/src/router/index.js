import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import AllAccounts from '@/components/AllAccounts'
import CreateNew from '@/components/NewAccount'
import EditAccount from '@/components/EditAccount'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
    	path: '/Accounts',
    	name: 'All Accounts',
    	component: AllAccounts
    },
    {
    	path: '/NewAccount',
    	name: 'Create New Account',
    	component: CreateNew
    },
    {
      path: '/EditAccount',
      name: 'Edit Account',
      component: EditAccount,
      props: true
    }
  ]
})
