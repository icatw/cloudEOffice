<template>
  <div>
    <el-card class="box-card" style="width: 400px">
      <div slot="header" class="clearfix">
        <span>{{ admin.name }}</span>
      </div>
      <div>
        <div style="display: flex; justify-content: center">
          <el-upload
              action="/upload"
              :headers="headers"
              :on-success="onSuccess"
              :show-file-list="false"
          >
            <img
                title="点击修改用户头像"
                :src="admin.userface"
                alt=""
                style="height: 100px; width: 100px; border-radius: 50px"
            />
          </el-upload>
        </div>
        <div>
          电话号码：
          <el-tag>{{ admin.telephone }}</el-tag>
        </div>
        <div>
          手机号码：
          <el-tag>{{ admin.phone }}</el-tag>
        </div>
        <div>
          居住地址：
          <el-tag>{{ admin.address }}</el-tag>
        </div>
        <div>
          用户标签：
          <el-tag
              v-for="(r, index) in admin.roles"
              :key="index"
              type="success"
          >{{ r.namezh }}
          </el-tag
          >
        </div>
        <div
            style="display: flex; justify-content: space-around; margin-top: 10px"
        >
          <el-button type="primary" @click="showUpdateAdminInfoView"
          >修改信息
          </el-button
          >
          <el-button type="danger" @click="showUpdatePasswordView"
          >修改密码
          </el-button
          >
        </div>
      </div>
    </el-card>
    <el-dialog title="编辑用户信息" :visible.sync="dialogVisible" width="30%">
      <div>
        <table>
          <tr>
            <td>用户昵称</td>
            <td>
              <el-input v-model="admin.name"></el-input>
            </td>
          </tr>
          <tr>
            <td>电话号码</td>
            <td>
              <el-input v-model="admin.telephone"></el-input>
            </td>
          </tr>
          <tr>
            <td>手机号码</td>
            <td>
              <el-input v-model="admin.phone"></el-input>
            </td>
          </tr>
          <tr>
            <td>用户地址</td>
            <td>
              <el-input v-model="admin.address"></el-input>
            </td>
          </tr>
        </table>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateAdminInfo">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
        title="更新密码"
        :visible.sync="passwordDialogVisible"
        width="30%"
        :before-close="handleClose"
    >
      <div>
        <el-form
            :model="ruleForm"
            status-icon
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
        >
          <el-form-item label="请输入旧密码" prop="oldPass">
            <el-input
                type="password"
                v-model="ruleForm.oldPass"
                autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="请输入新密码" prop="pass">
            <el-input
                type="password"
                v-model="ruleForm.pass"
                autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="确认新密码" prop="checkPass">
            <el-input
                type="password"
                v-model="ruleForm.checkPass"
                autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
            >提交
            </el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer"> </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'AdminInfo',
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      headers: {
        Authorization: window.sessionStorage.getItem('tokenStr'),
      },
      admin: {},
      dialogVisible: false,
      passwordDialogVisible: false,
      ruleForm: {
        pass: '',
        checkPass: '',
        oldPass: '',
      },
      rules: {
        pass: [{validator: validatePass, trigger: 'blur'}],
        checkPass: [{validator: validatePass2, trigger: 'blur'}],
        oldPass: [{validator: validatePass, trigger: 'blur'}],
      },
    }
  },
  methods: {
    initAdmin() {
      this.getRequest('/admin/info').then((resp) => {
        if (resp) {
          this.admin = resp
          window.sessionStorage.setItem('user', JSON.stringify(resp))
          this.$store.commit('INIT_ADMIN', resp)
        }
      })
    },
    showUpdateAdminInfoView() {
      this.dialogVisible = true
    },
    updateAdminInfo() {
      this.putRequest('/admin/info', this.admin).then((resp) => {
        if (resp) {
          this.dialogVisible = false
          this.initAdmin()
          location.reload()
        }
      })
    },
    showUpdatePasswordView() {
      this.passwordDialogVisible = true
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.ruleForm.adminId = this.admin.id
          this.putRequest('/admin/pass', this.ruleForm).then((resp) => {
            if (resp) {
              // 更新密码成功之后退出登录
              this.postRequest('/logout')
              window.sessionStorage.removeItem('user')
              window.sessionStorage.removeItem('tokenStr')
              this.$store.commit('initRoutes', [])
              this.$router.replace('/')
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    onSuccess(response) {
      console.log(response)
      if (response.code == 200) {
        this.$message.success("头像上传成功！");
        this.admin.userface = response.data
      } else {
        this.$message.error(response.msg);
      }
    },

    handleClose(done) {
      this.ruleForm = ''
      done();
    }
  },
  mounted() {
    this.initAdmin()
  },
}
</script>

<style>
</style>
