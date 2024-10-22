<template>
  <!-- this template should not be touched by the poc -->
  <div class="my-component">
    <h1>{{ message }}</h1>
    <button @click="handleClick">Click me</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: 'Hello Vue.js!'
    }
  },
  methods: {
    handleClick() {
      this.message = 'You clicked the button!'
    }
  }
}
</script>

<style scoped>
.my-component {
  color: #42b983;
}
</style>


