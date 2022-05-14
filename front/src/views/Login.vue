<template>
  <div>
    <el-form
      :rules="rules"
      v-loading="loading"
      element-loading-text="正在登录。。"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      ref="loginForm"
      :model="loginForm"
      class="loginContainer"
    >
      <h3 class="loginTitle">系统登录</h3>
      <!-- 用户名 -->
      <el-form-item prop="username">
        <el-input
          type="text"
          auto-complete="false"
          v-model="loginForm.username"
          placeholder="请输入用户名"
        ></el-input>
      </el-form-item>
      <!-- 密码 -->
      <el-form-item prop="password">
        <el-input
          type="password"
          auto-complete="false"
          show-password
          v-model="loginForm.password"
          placeholder="请输入密码"
        ></el-input>
      </el-form-item>
      <!-- 验证码 -->
      <el-form-item prop="code">
        <el-input
          type="text"
          auto-complete="false"
          v-model="loginForm.code"
          placeholder="点击图片更换验证码"
          style="width: 250px; margin-right: 5px"
        ></el-input>
        <!-- 验证码图片 -->
        <img :src="captchaUrl" @click="updateCaptcha" class="login_img" />
      </el-form-item>
      <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
      <!-- 登录按钮 -->
      <el-button type="primary" style="width: 100%" @click="submitLogin"
        >登录</el-button
      >
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      captchaUrl: '/captcha?time=' + new Date(),
      loginForm: {
        username: 'admin',
        password: '123',
        code: '',
      },
      checked: true,
      rules: {
        username: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
        ],
        code: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
      },
      loading: false,
    }
  },
  methods: {
    submitLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true
          this.postRequest('/login', this.loginForm, 'form').then((resp) => {
            if (resp) {
              console.log(resp);
              this.loading = false
              // 存储用户token
              const tokenStr = resp.data.tokenHead + resp.data.token
              window.sessionStorage.setItem('tokenStr', tokenStr)
              let path = this.$route.query.redirect
              this.$router.replace(
                path == '/' || path == undefined ? '/home' : path
              )
            }
            if (resp == undefined) {
              this.loading = false
            }
          })
        } else {
          this.$message.error('你还有未填写的信息')
          return false
        }
      })
    },
    updateCaptcha() {
      this.captchaUrl = '/captcha?time=' + new Date()
    },
  },
}
</script>

<style >
.loginContainer {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 15px 35px 15px 35px;
  background-color: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.loginTitle {
  margin: 0px auto 40px auto;
  text-align: center;
}
.loginRemember {
  text-align: left;
  margin: 0px 0px 15px 0px;
}
.el-form-item__content {
  display: flex;
  align-items: center;
}
</style>