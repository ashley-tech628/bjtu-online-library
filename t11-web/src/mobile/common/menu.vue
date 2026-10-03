<template>
  <ul class="menuUnit" v-for="item in menuArrRef">
    <li class="menu1">{{item.title}}</li>
    <li class="menu2" v-for="child in item.children">
      <RouterLink :to="child.path">{{child.title}}</RouterLink>
    </li>
  </ul>
</template>
<script lang="ts" setup>

import { useMenuData } from "@/mobile/common/menuData"
import {ref} from "vue";

const menuArrRef = ref()
const { initMenuData } = useMenuData()
initMenuData('', menuArrRef)
</script>
<style scoped>
.menuUnit{

}
.menuUnit li{
  list-style-type: none;
}
.menuUnit .menu1{

}
.menuUnit .menu2{
  margin-left: 10px;
}
</style>