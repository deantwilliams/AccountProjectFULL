<template>
  <div class="NewAccount" style="width:80%;margin: 0 auto">
    <br><h1>{{title}}</h1><br>
    <div style="width:50%;margin: 0 auto">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="grpFirstName" label="First Name:" label-for="firstName">
        <b-form-input id="firstName" type="text" v-model="form.firstName"
                      required placeholder="Enter first name" :state="!$v.form.firstName.$invalid" aria-describedby="firstNameFeedBack">
        </b-form-input>
          <b-form-invalid-feedback id="firstNameFeedBack">
            This field is required and must only contain alphabetic characters.
          </b-form-invalid-feedback>
      </b-form-group>
      <b-form-group id="grpLastName" label="Last Name:" label-for="lastName">
        <b-form-input id="lastName" type="text" v-model="form.lastName" required placeholder="Enter last name" :state="!$v.form.lastName.$invalid" aria-describedby="lastNameFeedBack">
        </b-form-input>
        <b-form-invalid-feedback id="lastNameFeedBack">
          This field is required and must only contain alphabetic characters.
        </b-form-invalid-feedback>
      </b-form-group>
      <b-form-group id="grpAccountNo" label="Account Number:" label-for="accountNo">
        <b-form-input id="accountNo" type="text" v-model="form.accountNo" required placeholder="Enter account no." :state="!$v.form.accountNo.$invalid" aria-describedby="accountNoFeedBack">
        </b-form-input>
        <b-form-invalid-feedback id="accountNoFeedBack">
          This field is required and must contain exactly 6 digits.
        </b-form-invalid-feedback>
      </b-form-group>
      <b-button type="submit" variant="primary" :disabled="$v.form.$invalid">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    </div>
  </div>
</template>

<script>
  import {validationMixin} from 'vuelidate'
  import {required,minLength,maxLength,alpha,numeric} from 'vuelidate/lib/validators'
import axios from 'axios'
export default {
  name: 'NewAccount',
  data () {
    return {
      title: 'Create a new account',
      form: {
        firstName: '',
        lastName: '',
        accountNo: ''
      },
      show: true
    }
  },
  mixins:[
    validationMixin
  ],
  validations:{
    form:{
      firstName:{
        required,
        alpha
      },
      lastName:{
        required,
        alpha
      },
      accountNo:{
        required,
        numeric,
        maxLength: maxLength(6),
        minLength: minLength(6)
      }
    }
  },
  methods: {
    	onSubmit (evt) {
    		const that = this
    		axios({
        method: 'post',
        url: 'http://localhost:8088/accounts/create',
        data: {
          firstName: that.form.firstName,
          lastName: that.form.lastName,
          accountNumber: that.form.accountNo
        }
      }).then(response => console.log(JSON.stringify(response)), this.$router.push('Accounts')).catch(e => console.log(e))
    	},
    	onReset (evt) {
    		evt.preventDefault()
    		this.form.firstName = ''
    		this.form.lastName = ''
    		this.form.accountNo = ''
    		this.show = false
    	}
  }
}
</script>
