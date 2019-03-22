<template>
  <el-scrollbar wrapClass="scrollbar-wrapper">
    <el-menu
      mode="vertical"
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <sidebar-item v-for="route in routes" :key="route.name" :item="route" :base-path="route.path"></sidebar-item>
    </el-menu>
  </el-scrollbar>
</template>

<script>
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'
import store from '@/store';

export default {
  created(){
    store.dispatch('InitMenus');
  },
  components: { SidebarItem },
  computed: {
    ...mapGetters([
      'sidebar'
    ]),
    routes() {
      this.$router.addRoutes(this.$store.state.menu.routes);
      this.$router.options.routes = this.$router.options.routes.concat(this.$store.state.menu.routes);
      return this.$store.state.menu.routes
    },
    isCollapse() {
      return !this.sidebar.opened
    }
  }
}
</script>
