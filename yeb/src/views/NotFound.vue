<template>
  <div>
    <h2>抱歉，您输入的地址没有找到</h2>
    <h3>o(╥﹏╥)o</h3>
    <el-button type="text" @click="goLogin">点击返回主页</el-button>

  </div>
</template>

<script>
export default {
  name: 'NotFound',
  data() {
    return {}
  },
  methods: {
    goLogin() {
      //如果已经登陆，跳转到首页，否则跳转到登陆页
      if (window.sessionStorage.getItem('tokenStr')) {
        this.$router.push({
          path: '/home'
        })
      } else {
        this.$router.push({
          path: '/'
        })
      }
    }
  }
}
</script>
<style scoped>

</style>
