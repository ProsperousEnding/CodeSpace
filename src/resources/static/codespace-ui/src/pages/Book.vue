<script setup>
import { defineComponent, h, ref } from "vue";
import infiniteSlideBar from "../utils/vue-infinite-slide-bar.vue"


</script>


<template>
  <h1>书山有路</h1>
  <infinite-slide-bar :barStyle="{ background: '#42b883', padding: '5px 0' }">
      <span style="color: #fff;">Helo World, I love Vue Infinite Slide Bar</span>
    </infinite-slide-bar>
</template>


<style>

</style>