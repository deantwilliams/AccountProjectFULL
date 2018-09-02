<template>
  <div id="app">
    <b-navbar toggleable="md" type="dark" variant="info">

	  <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
	
	  <b-navbar-brand b-link to="/">Individual Project</b-navbar-brand>
	
	  <b-collapse is-nav id="nav_collapse">
	
	    <b-navbar-nav>
	      <b-nav-item-dropdown text="Accounts">
	      	<b-dropdown-item b-link to="/Accounts">View All</b-dropdown-item>
	      	<b-dropdown-item b-link to="/NewAccount">Create New</b-dropdown-item>
	      </b-nav-item-dropdown>
	   	</b-navbar-nav>
	  </b-collapse>
	</b-navbar>

    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
