<template>
  <div class="AllAccounts" style="width:80%;margin: 0 auto">
    <br>
    <h1>{{ title }}</h1>
  <br>
  <b-table striped hover :items="accounts" :sort-by.sync="sortBy" fixed :fields="fields">
    <template slot="actions" slot-scope="data">
      <div>
        <button class="action-btn btn btn-info" @click="editAccount(data.item.id)">
          Edit
        </button>
        <button class="action-btn btn btn-danger" @click="deleteAccount(data.item.id)">
          Delete
        </button>
      </div>
    </template>
  </b-table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'AllAccounts',
  data () {
    return {
      title: 'All Accounts',
      sortBy: 'Id',
      sortDesc: false,
      accounts: [],
      fields: {
        id: {
          key: 'id',
          label: 'ID',
          sortable: true
        },
        firstName: {
          label: 'First Name',
          sortable: true
        },
        lastName: {
          label: 'Last Name',
          sortable: true
        },
        accountNumber: {
          label: 'Account No.',
          sortable: true
        },
        actions: {
          label: '',
          sortable: false
        }
      }
    }
  },

  mounted () {
    axios.get('http://localhost:8088/accounts/all')
      .then(response => { this.accounts = response.data; console.log(this.accounts) })
      .catch(error => { error.log(error) })
  },

  methods: {
    deleteAccount (id) {
      let idx = this.accounts.map(item => item.id).indexOf(id)
      axios.delete('http://localhost:8088/accounts/delete/' + id)
        .then(this.$delete(this.accounts, idx),
          alert('Account has been removed')
        )
        .catch(error => { console.log(error) })
    },
    editAccount(ID) {
      this.$router.push({name: 'Edit Account', params: {id: ID}})
    }
  }
}
</script>
