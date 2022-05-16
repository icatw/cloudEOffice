<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">云e办</div>
        <el-dropdown class="userInfo" @command="commandHandler">
          <span class="el-dropdown-link">
            {{ user.name }}<i><img :src="user.userface"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="userInfo">个人中心</el-dropdown-item>
            <el-dropdown-item command="setting">设置</el-dropdown-item>
            <el-dropdown-item command="logout">注销登陆</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-container>

        <el-aside :width="isCollapse?'68px':'180px'">

          <el-menu router unique-opened :collapse="isCollapse" :collapse-transition=false>
            <el-submenu
                :index="index + ''"
                v-for="(item, index) in routes"
                :key="index"
                v-if="!item.hidden"
            >
              <template slot="title"
              ><i
                  :class="item.iconcls"
                  style="color: #1accff; margin-right: 5px"
              ></i
              ><span>{{ item.name }}</span></template
              >
              <el-menu-item
                  :index="children.path"
                  v-for="(children, indexj) in item.children"
                  :key="indexj"
              >{{ children.name }}
              </el-menu-item
              >
            </el-submenu>
          </el-menu>


        </el-aside>

        <el-main>
          <!--          折叠菜单-->
          <el-button :icon="isCollapse?unfold:fold"
                     size="small"
                     style="color: #989fa7;margin-bottom: 5px;padding: 8px"
                     @click="foldMenu"></el-button>
          <!--          面包屑导航-->
          <el-breadcrumb
              separator-class="el-icon-arrow-right"
              v-if="this.$router.currentRoute.path != '/home'">
            <el-breadcrumb-item :to="{ path: '/home' }">首页
            </el-breadcrumb-item>
            <el-breadcrumb-item>
              {{ this.$router.currentRoute.name }}
            </el-breadcrumb-item>
          </el-breadcrumb>
          <div class="homeWelcome"
               v-if="this.$router.currentRoute.path == '/home'">
            欢迎来到云E办系统
          </div>
          <!-- 主体 -->
          <router-view class="homeRouterView"/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      //将字符串转为对象
      user: JSON.parse(window.sessionStorage.getItem('user')),
      isCollapse: true,
      //  true折叠，false打开
      unfold: 'el-icon-s-unfold',
      fold: 'el-icon-s-fold'
    }
  },
  computed: {
    routes() {
      return this.$store.state.routes;
    }
  },
  methods: {
    foldMenu() {
      this.isCollapse = !this.isCollapse
    },
    commandHandler(command) {
      if (command == 'logout') {
        this.$confirm('此操作将注销登录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
          // 注销登录
          this.postRequest('/logout')
          // 销毁用户的session
          window.sessionStorage.removeItem('tokenStr')
          window.sessionStorage.removeItem('user')
          // 清空菜单
          this.$store.commit('initRoutes', [])
          // 跳转到登录页面
          this.$router.replace('/')
        })
            .catch(() => {
              this.$message({
                type: 'info',
                message: '已取消操作',
              })
            })
      }
      if (command == 'userinfo') {
        this.$router.push('/userinfo')
      }
    }
  }
}
</script>

<style>
.homeHeader {
  background: #409eff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 15px;
  box-sizing: border-box;
}

.homeHeader .title {
  font-size: 30px;
  font-family: 华文楷体;
  color: white;
}

.homeHeader .userInfo {
  cursor: pointer;
}

.el-dropdown-link img {
  width: 48px;
  height: 48px;
  border-radius: 24px;
  margin-left: 8px;
}

.homeWelcome {
  text-align: center;
  font-size: 30px;
  font-family: 华文楷体;
  color: #409eff;
  padding-top: 50px;
}

.homeRouterView {
  margin-top: 10px;
}
</style>
